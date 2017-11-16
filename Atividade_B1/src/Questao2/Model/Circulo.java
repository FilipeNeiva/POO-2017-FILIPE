package Questao2.Model;
import static java.lang.Math.*;

public class Circulo {
    private float raio;
    private float x;
    private float y;




    public Circulo(float raio) {
        this.raio = raio;

        if (raio <= 0){
            this.raio = 1;
        }

        this.x = 0;
        this.y = 0;


    }

    public float getRaio() {
        return raio;
    }

    public float getDiametro(){
        return raio*2;
    }

    public float getCircunferencia(){
        return (float) (raio*(2*3.14));
    }

    public float getArea() {
        return (float)((raio * raio) * 3.14);
    }

    public void moverCirculo(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void aumentarCirculo(){
        this.raio += 1;
    }

    public void diminuirCirculo(){
        this.raio -= 1;
    }
/*
    public boolean dentroDoCirculo(Ponto p1){
        float dis = Math.sqtr(((p1.x - this.x)* (p1.x - this.x)) + ((p1.y - this.y) * (p1.y - this.y)));
        if (dis > this.raio){
            return false;
        }else{
            return true;
        }
    }
*/
}



