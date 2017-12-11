package exercicio01.questao07.model;

public class Retangulo {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getPerimetro(){
        return (this.base * 2) + (this.altura * 2);
    }
}
