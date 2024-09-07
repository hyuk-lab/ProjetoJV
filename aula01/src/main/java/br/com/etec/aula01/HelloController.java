package br.com.etec.aula01;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private CheckBox chkCasado;

    @FXML
    private ToggleGroup grpSexo;

    @FXML
    private ToggleGroup grpSexo1;

    @FXML
    private RadioButton rbFeminino;

    @FXML
    private RadioButton rbMasculino;

    @FXML
    private TextArea txtAreaDados;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;

    private Cliente cliente;

    private List<Cliente> listaClientes = new ArrayList<>();

    @FXML
    protected void onClickCadastrar(){

       if(txtNome.getText().equals("")){
        avisoBranco("Nome em branco");
        txtNome.requestFocus();
        return;
       }

        if(txtEmail.getText().equals("")){
            avisoBranco("Email em branco");
            return;
        }


       if(txtTelefone.getText().equals("")){
           avisoBranco("Telefone em branco");
            return;
       }



        String sexo = rbMasculino.isSelected()?"Masculino":"Feminino";
        int id = listaClientes.size()+1;
        cliente = new Cliente(id,txtNome.getText(),txtEmail.getText(),txtTelefone.getText(),sexo,chkCasado.isSelected());

        listaClientes.add(cliente);
        txtAreaDados.setText(listaClientes.toString());
        limparCampos();
    }
    private void limparCampos(){
        txtNome.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        rbMasculino.setSelected(false);
        rbFeminino.setSelected(false);
        chkCasado.setSelected(false);
        txtNome.requestFocus();
    }


    private void avisoBranco(String msg){
        Alert alertaErro = new Alert(Alert.AlertType.ERROR);
        alertaErro.setTitle("erro");
        alertaErro.setHeaderText("Campo em branco");
        alertaErro.setContentText(msg);
        alertaErro.show();
    }
}