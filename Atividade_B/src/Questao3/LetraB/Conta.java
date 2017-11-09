package Questao3.LetraB;

public class Conta {
    private int numero;
    private double valor;
    private Titular titular;

    public Conta(int numero, Titular titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public void sacar(int valor){
        this.valor = this.valor - valor;
    }

    public void depositar(int valor){
        this.valor = this.valor + valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public double getValor() {
        return valor;
    }

    public Titular getTitular() {
        return titular;
    }
}
