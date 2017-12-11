package exercicio02.questao12.model;

public class Desconto {
    public double valor;
    public double desconto;

    public double calcula(){
        return valor - (valor * (desconto/100));
    }
}
