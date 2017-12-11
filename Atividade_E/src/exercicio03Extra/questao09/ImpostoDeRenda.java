package exercicio03Extra.questao09;

public class ImpostoDeRenda {
    double rendaBruta;

    public ImpostoDeRenda(double rendaBruta) {
        this.rendaBruta = rendaBruta;
    }
    public double calcularImposto(){
        if(rendaBruta <= 1000) {
            return rendaBruta * 0.05;
        }else
            return rendaBruta * 0.1;
    }

    public double calcularRendalquida(){
        return rendaBruta - calcularImposto();
    }
}
