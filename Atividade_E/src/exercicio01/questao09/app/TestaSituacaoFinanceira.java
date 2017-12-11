package exercicio01.questao09.app;

import exercicio01.questao09.model.SituacaoFinanceira;

public class TestaSituacaoFinanceira {
    public static void main(String[] args) {
        SituacaoFinanceira situacao = new SituacaoFinanceira(80, 30);

        System.out.println("Saldo: " + situacao.saldo());
    }

}
