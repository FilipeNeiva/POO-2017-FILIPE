package Questao3.LetraA;

public class Veiculo {
    private String chaci;
    private String cor;
    private String modelo;
    private double preco;
    private Montadora montadora;

    public Veiculo(String chaci) {
        this.chaci = chaci;
    }

    public void desconto(double valorDesconto){
        this.preco = this.preco - valorDesconto;
    }

    public void aumento(double valorAumento){
        this.preco = this.preco + valorAumento;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setMontadora(Montadora montadora) {
        this.montadora = montadora;
    }

    public String getChaci() {
        return chaci;
    }

    public String getCor() {
        return cor;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPreco() {
        return preco;
    }

    public Montadora getMontadora() {
        return montadora;
    }
}
