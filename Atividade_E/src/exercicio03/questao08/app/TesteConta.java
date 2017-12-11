package exercicio03.questao08.app;

import exercicio03.questao08.model.Conta;

public class TesteConta {
    public static void main(String[] args) {
        Conta conta = new Conta(1, 100);

        conta.depositar(10);
        conta.sacar(20);

        Conta conta1 = new Conta(2, 500);

        conta1.transferir(conta, 200);

        System.out.println(conta.getSaldo());
        System.out.println(conta1.getSaldo());
    }
}
