package exercicio02.questao11.app;

import exercicio02.questao11.model.DecimalNumber;

public class TesteDecimalNumber {
    public static void main(String[] args) {
        DecimalNumber decimalNumber = new DecimalNumber();

        decimalNumber.num = 14.8;

        System.out.println(decimalNumber.getInteiro());
        System.out.println(decimalNumber.getAlgumaCoisa());

    }
}
