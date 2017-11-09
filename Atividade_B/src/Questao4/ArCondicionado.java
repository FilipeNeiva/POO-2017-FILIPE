package Questao4;

public class ArCondicionado {
    private String estado;
    private int temperatura;
    private int velocidadeVentilador;
    private String modo;

    public ArCondicionado() {
        estado = "Desligado";
        modo = "Frio";
    }

    public void setLigaDesliga() {
        if(this.estado == "Ligado"){
            this.estado = "Desligado";
        }else{
            this.estado = "Ligado";
        }
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public void setVelocidadeVentilador(int velocidadeVentilador) {
        this.velocidadeVentilador = velocidadeVentilador;
    }

    public void setModo() {
        if(this.modo == "Frio"){
            this.modo = "Ventilador";
        }else{
            this.modo = "Frio";
        }
    }

    public String getEstado() {
        return estado;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getVelocidadeVentilador() {
        return velocidadeVentilador;
    }

    public String getModo() {
        return modo;
    }
}
