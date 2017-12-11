package exercicio03.questao07.model;

public class Jogador {
    private int forca;
    private int nivel;
    private int pontos;

    public Jogador(int forca, int nivel, int pontos) {
        this.forca = forca;
        this.nivel = nivel;
        this.pontos = pontos;
    }

    public void valorAtaque(){
        this.pontos += this.forca * this.nivel;
    }

    public void atacar(Jogador j){
        j.pontos -= this.pontos;

    }

    public int getPontos() {
        return pontos;
    }
}
