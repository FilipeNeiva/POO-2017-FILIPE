package exercicio03.questao09.model;

public class Produto {
    private int codigo;
    public String descricao;
    private double valor;
    private int quantidade;
    private int quantidadeMinima;

    public Produto(int codigo, String descricao, double valor, int quantidade, int quantidadeMinima) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
    }

    public void baixar(int quantidade){
        if(this.quantidade - quantidade >= quantidadeMinima)
            this.quantidade -= quantidade;
    }

    public void repor(int quantidade){
        this.quantidade += quantidade;
    }

    public void reajusta(int taxa){
        this.valor = this.valor * ((taxa/100) + 1);
    }

    public String toString(){
        return "Codigo: " + this.codigo + "; Descrição: " + this.descricao + "; Valor: " + this.valor + "; Quantidade: " + this.quantidade + "; Quantidade minima: " + this.quantidadeMinima;
    }

    public boolean equals(Produto p) {
        if(this.codigo == p.codigo)
            return true;
        else
            return false;
    }

}
