package Questao3.LetraC;

public class Apartamento {
    private int id;
    private double aluguel;
    private int numQuartos;
    private Proprietario proprietario;

    public Apartamento(int id) {
        this.id = id;
    }

    public void aumento(double valor){
        aluguel += valor;
    }

    public void desconto(double valor){
        aluguel -= valor;
    }

    public void setAluguel(double aluguel) {
        this.aluguel = aluguel;
    }

    public void setNumQuartos(int numQuartos) {
        this.numQuartos = numQuartos;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public int getId() {
        return id;
    }

    public double getAluguel() {
        return aluguel;
    }

    public int getNumQuartos() {
        return numQuartos;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }
}
