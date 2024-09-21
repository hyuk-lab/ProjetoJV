package org.example.projectavaliacao;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    private List<Conta> contas = new ArrayList<>();

        @FXML
    private ToggleGroup grpTipo;

    @FXML
    private Label lblSaldo;

    @FXML
    private RadioButton rbCorrente;


    @FXML
    private RadioButton rbEspecial;

    @FXML
    private RadioButton rbPoupanca;

    @FXML
    private TextField txtConta;

    @FXML
    private TextArea txtDados;

    @FXML
    private TextField txtDepositarSacar;

    @FXML
    private TextField txtLimite;

    @FXML
    private TextField txtPesquisa;

    @FXML
    private TextField txtTitular;

    @FXML
    private TextField txtVencimento;

    @FXML
    protected  void onSelecionarTipo() {
        if (rbCorrente.isSelected()) {
            txtLimite.setDisable(true);
            txtVencimento.setDisable(true);
        } else if (rbEspecial.isSelected()) {
            txtLimite.setDisable(false);
            txtVencimento.setDisable(true);

        } else {
            txtLimite.setDisable(true);
            txtVencimento.setDisable(false);
        }
    }

    @FXML
     protected  void onCadastrarConta(){

        if(rbCorrente.isSelected()){
            Conta conta = new Conta(Integer.parseInt(txtConta.getText()),txtTitular.getText());
            contas.add(conta);
        }else if (rbEspecial.isSelected()){
            Especial contaEspecial = new Especial(Integer.parseInt(txtConta.getText()),txtTitular.getText(), Double.parseDouble(txtLimite.getText()));
            contas.add(contaEspecial);
        }else {
            Poupanca contaPoupanca = new Poupanca(Integer.parseInt(txtConta.getText()),txtTitular.getText(),Integer.parseInt(txtVencimento.getText()));
            contas.add(contaPoupanca);
        }
        txtDados.setText(contas.toString());
    }

}