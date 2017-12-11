package exercicio03.questao07.app;

import exercicio03.questao07.model.Jogador;

public class TesteJogador {
    public static void main(String[] args) {
        Jogador jogador01 = new Jogador(5, 6, 90);
        Jogador jogador02 = new Jogador(4, 7, 80);

        jogador01.valorAtaque();
        jogador02.valorAtaque();

        jogador01.atacar(jogador02);
        jogador02.atacar(jogador01);

        System.out.println(jogador01.getPontos());
        System.out.println(jogador02.getPontos());
    }
}
