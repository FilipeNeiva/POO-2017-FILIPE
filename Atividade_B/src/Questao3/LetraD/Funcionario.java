package Questao3.LetraD;

public class Funcionario {
    private String nome;
    private int idade;
    private Cargo cargo;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public void aumento(double valorAmento){
        this.cargo.salario += valorAmento;
    }

    public double ganhoAnual(){
        return cargo.salario*12;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
