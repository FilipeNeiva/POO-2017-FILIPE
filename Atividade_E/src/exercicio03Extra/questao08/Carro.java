package exercicio03Extra.questao08;

public class Carro {
    String placa;
    long chassi;
    String modelo;
    String ano;

    public Carro(String placa, long chassi, String modelo, String ano) {
        this.placa = placa;
        this.chassi = chassi;
        this.modelo = modelo;
        this.ano = ano;
    }

    boolean clonado(Carro c) {
        if(this.placa == c.placa && this.chassi == c.chassi)
            return true;
        else
            return false;
    }
}