package exercicio01.questao08.model;

public class Circulo {
    private double raio;

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getArea(){
        return (raio * raio) * 3.14;
    }

    public double getPerimetro(){
        return raio * 3.14 * 2;
    }
}
