package org.example.projectavaliacao;

public class Poupanca extends Conta {
    private Integer aniversario;

    public Poupanca(Integer numero, String titular, Integer aniversario) {
        super(numero, titular);
        this.aniversario = aniversario;
    }
}
