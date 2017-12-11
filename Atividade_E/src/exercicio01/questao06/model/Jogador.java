package exercicio01.questao06.model;

public class Jogador {
    private String nome;
    private double altura;
    private String tipo;

    public Jogador(String nome, double altura) {
        this.nome = nome;
        this.altura = altura;
        this.tipo = "Normal";
    }

    public void setLibero(){
        this.tipo = "Libero";
    }

}
