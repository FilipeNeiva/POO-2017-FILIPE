package exercicio03.questao09.app;

import exercicio03.questao09.model.Produto;

public class TesteProduto {
    public static void main(String[] args) {
        Produto deterjente = new Produto(1, "Bem loko", 2.5, 4, 2);

        deterjente.baixar(1);
        deterjente.repor(5);
        deterjente.reajusta(20);
        System.out.println(deterjente.toString());

        Produto vassoura = new Produto(1, "Impolgante", 5.0, 8, 2);

        System.out.println(deterjente.equals(vassoura));
    }
}
