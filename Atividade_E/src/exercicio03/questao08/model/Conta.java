package exercicio03.questao08.model;

public class Conta {
    private int numConta;
    private double saldo;

    public Conta(int numConta, double saldo) {
        this.numConta = numConta;
        this.saldo = saldo;
    }

    public boolean sacar(double valor){
        if(this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        else
            return false;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public boolean transferir(Conta c, double valor){
        if(this.saldo >= valor) {
            this.sacar(valor);
            c.depositar(valor);
            return true;
        }
        else
            return false;
    }

    public double getSaldo() {
        return saldo;
    }
}
