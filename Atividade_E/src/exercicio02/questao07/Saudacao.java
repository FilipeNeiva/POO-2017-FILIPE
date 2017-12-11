package exercicio02.questao07;

public class Saudacao {
    public String texto;
    public String destinatario;

    public String obterSaldacao(){
        return this.texto + ", " + this.destinatario;
    }
}
