package exercicio02.questao12.app;

import exercicio02.questao12.model.Desconto;

public class TesteDesconto {
    public static void main(String[] args) {
        Desconto desconto = new Desconto();

        desconto.valor = 120;
        desconto.desconto = 10;

        System.out.println(desconto.calcula());

    }
}
