package org.example.projectavaliacao;

public class Poupanca extends Conta {
    private Integer aniversario;

    public Poupanca(Integer numero, String titular, Integer aniversario) {
        super(numero, titular);
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return  "numero= " + this.getNumero() +
                ", titular= " + this.getTitular() +
                ", vencimento= " + aniversario +
                ", saldo= " + this.getSaldo() + System.lineSeparator();
    }
}
