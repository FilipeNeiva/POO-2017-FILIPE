package exercicio01.questao06.app;

import exercicio01.questao06.model.Jogador;

import java.util.Scanner;

public class HellowVolei {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Jogador[] time = new Jogador[6];

        for(int i = 0; i < 5; i++){
            System.out.print("Entre com o nome do jogador: ");
            String nome = entrada.nextLine();
            System.out.print("Entre com a altura do jogador: ");
            double altura = entrada.nextDouble();
            time[i] = new Jogador(nome, altura);
        }

        System.out.print("Entre com o nome do libero: ");
        String nome = entrada.nextLine();
        System.out.print("Entre com a altura do libero: ");
        double altura = entrada.nextDouble();
        time[5] = new Jogador(nome, altura);
        time[5].setLibero();
    }
}
