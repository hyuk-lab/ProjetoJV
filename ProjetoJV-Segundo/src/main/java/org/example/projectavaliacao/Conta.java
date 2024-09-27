package org.example.projectavaliacao;

public class Conta {
    private Integer numero;

    private String titular;

    private Double saldo;

    public Conta(Integer numero,String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void depositar(Double valor){
     this.saldo = this.saldo + valor;

    }

    public  Boolean sacar(Double valor){
        if( valor <= this.saldo){
        this.saldo = this.saldo - valor;
        return true;
        } else {
            return false;
        }

}



    public Double getSaldo(){
        return saldo;
}

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return
                "numero=" + this.getNumero() +
                ", titular='" + this.getTitular() + '\'' +
                ", saldo=" + this.getSaldo() + System.lineSeparator();
    }
}
