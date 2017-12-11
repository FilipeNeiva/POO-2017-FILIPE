package exercicio02.questao15;

import exercicio02.questao14.Equipamento;

public class TestaEquipamento {
    public static void main(String[] args) {
        Equipamento equipamento01 = new Equipamento();
        Equipamento equipamento02 = new Equipamento();

        equipamento01.liga();

        equipamento01.inverte();
        equipamento02.inverte();

        if(equipamento01.estaLigado())
            System.out.println("Equipamento 1: Ligado");
        else
            System.out.println("Equipamento 1: Desligado");

        if(equipamento02.estaLigado())
            System.out.println("Equipamento 2: Ligado");
        else
            System.out.println("Equipamento 2: Desligado");
    }
}
