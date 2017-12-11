package exercicio01.questao08.app;

import exercicio01.questao08.model.Circulo;

public class TestaCirculo {
    public static void main(String[] args) {

        Circulo circulo = new Circulo();
        circulo.setRaio(4);

        System.out.println("Area: " + circulo.getArea());

        System.out.println("Perimetro: " + circulo.getPerimetro());

    }
}
