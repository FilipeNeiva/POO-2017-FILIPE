package exercicio03Extra.questao10;

public class Jogador {
    int vidas;

    public Jogador() {
        this.vidas = 5;
    }

    public boolean isLimitMaxVidas(){
        if(this.vidas == 5)
            return true;
        else
            return false;
    }

    public boolean isLimitMinVidas(){
        if(this.vidas == 0)
            return true;
        else
            return false;
    }

    public void aumentaVidas(){
        if(isLimitMaxVidas())
            this.vidas += 0;
        else
            this.vidas++;
    }

    public void diminueVidas(){
        if(isLimitMinVidas())
            this.vidas -= 0;
        else
            this.vidas--;
    }

    public void doarVida(Jogador j){
        if(this.isLimitMinVidas() || j.isLimitMaxVidas())
            this.vidas += 0;
        else {
            this.diminueVidas();
            j.aumentaVidas();
        }
    }
}
