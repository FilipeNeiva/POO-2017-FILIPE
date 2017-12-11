package exercicio01.questao09.model;

public class SituacaoFinanceira {
    private double valorCredito;
    private double valorDebito;

    public SituacaoFinanceira(double valorCredito, double valorDebito) {
        this.valorCredito = valorCredito;
        this.valorDebito = valorDebito;
    }

    public double saldo(){
        return valorCredito - valorDebito;
    }
}
