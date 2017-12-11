package exercicio02.questao08;

import exercicio02.questao07.Saudacao;

public class TestaSaudacao {
    public static void main(String[] args) {
        Saudacao saudacao = new Saudacao();

        saudacao.texto = "Bom dia";
        saudacao.destinatario = "Rogerio";

        System.out.println(saudacao.obterSaldacao());

    }
}
