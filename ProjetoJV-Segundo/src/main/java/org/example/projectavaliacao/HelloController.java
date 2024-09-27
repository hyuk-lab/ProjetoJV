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
    private TextField txtValor;

    @FXML
    private TextField txtLimite;

    @FXML
    private TextField txtPesquisa;

    @FXML
    private TextField txtTitular;

    @FXML
    private TextField txtVencimento;

    private Conta contaAT;

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

        atualizarAD();
        limparCD();
    }


    @FXML
    protected void onDepositar() {
        if (contaAT != null) {
            double valorDeposito = Double.parseDouble(txtValor.getText());
            contaAT.depositar(valorDeposito);
            atualizarAD();
            lblSaldo.setText(String.valueOf(contaAT.getSaldo()));
            limparCamposOperacao();
        } else {
            alert("Selecione uma conta!");
        }
    }


    @FXML
    protected void onSacar() {
        if (contaAT != null) {
            double valorSaque = Double.parseDouble(txtValor.getText());
            if (contaAT.sacar(valorSaque)) {
                atualizarAD();
                lblSaldo.setText(String.valueOf(contaAT.getSaldo()));
                limparCamposOperacao();
            } else {
                alert("Saldo insuficiente!");
            }
        } else {
            alert("Selecione uma conta!");
        }
    }


    @FXML
    protected void onPesquisar() {
        int numeroConta = Integer.parseInt(txtPesquisa.getText());
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                contaAT = conta;
                lblSaldo.setText(String.valueOf(conta.getSaldo()));
                txtDados.setText(conta.toString());
                return;
            }
        }
        alert("Conta não registrada!");
    }


    private void atualizarAD() {
        StringBuilder dados = new StringBuilder();
        for (Conta conta : contas) {
            dados.append(conta.toString()).append("\n");
        }
        txtDados.setText(dados.toString());
    }


    private void limparCD() {
        txtConta.setText("");
        txtTitular.setText("");
        txtLimite.setText("");
        txtVencimento.setText("");
        rbEspecial.setSelected(false);
        rbCorrente.setSelected(false);
        rbPoupanca.setSelected(false);
        lblSaldo.setText("Saldo: 0.00");
        txtConta.requestFocus();
    }


    private void limparCamposOperacao() {
        txtValor.setText("");
        txtValor.requestFocus();
    }


    private void alert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



}



