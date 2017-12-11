package exercicio02.questao11.model;

public class DecimalNumber {
    public double num;

    public int getInteiro(){
        return (int) num;
    }

    public double getAlgumaCoisa(){
        return num - (int) num;
    }
}
