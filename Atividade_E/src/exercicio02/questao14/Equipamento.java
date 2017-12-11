package exercicio02.questao14;

public class Equipamento {
    private boolean ligado = false;

    public void liga(){
        if(this.ligado == false)
            this.ligado = true;
    }

    public void desliga(){
        if(this.ligado == true)
            this.ligado = false;
    }

    public void inverte(){
        if(this.ligado == true)
            this.ligado = false;
        else
            this.ligado = true;
    }

    public boolean estaLigado(){
        return this.ligado;
    }


}
