package exercicio02.questao10.app;

import exercicio02.questao10.model.Soma;

public class TesteSoma {
    public static void main(String[] args) {
        Soma soma = new Soma();

        soma.num1 = 3;
        soma.num2 = 4;

        System.out.println(soma.calcularSoma());

    }
}
