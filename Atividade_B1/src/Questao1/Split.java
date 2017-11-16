package Questao1;
import javax.swing.*;
import java.*;

public class Split {
    private boolean power;
    private float temperatura;
    private int velocidade;
    private String modo;

    public void menu(){
        String x = JOptionPane.showInputDialog(" Split\nLigado: "+ power+"\nTemperatura: "+ temperatura + "\nVelocidade: "+ velocidade+"\nModo: "+modo + "\n1 - Liga/Desliga\n2 - Temperatura\n3 - Velocidade ventilador\n5 - modo");
        if(x == 1){
            setPower();
        }

    }



    public Split() {

        this.power = false;
        this.modo = "Frio";

    }

    public void setPower() {
        if (power == false){
         this.power = true;
        }
        else{
            this.power = false;
        }
    }

    public void setTemperatura(float temperatura) {
        if (power == false) {
            JOptionPane.showMessageDialog(null," Não pode executar pois está desligado");
        }
        else{
            this.temperatura = temperatura;

        }
    }

    public void setVelocidade(int velocidade) {
        if (power == false) {
            JOptionPane.showMessageDialog(null, " Não pode executar pois está desligado");
        }
        else{
        this.velocidade = velocidade;
        }
    }



    public void setModo() {
        if (this.modo == "ventilado"){
            this.modo = "Frio";
        }
        else{
            this.modo = "Ventilado";

        }
    }
}
