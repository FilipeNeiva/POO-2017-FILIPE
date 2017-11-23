package Cap5.Questao01.model;


import javax.swing.*;

public class Empresa {

    public model.Funcionario[] empregados;
    private String cnpj;
    private int cont = 0;

    public Empresa(String cnpj) {
        this.cnpj = cnpj;
    }

    public void adiciona(model.Funcionario f) {
        if (cont > empregados.length) {
            model.Funcionario[] aux = new model.Funcionario[this.empregados.length*2];
            for(int i = 0; i < this.empregados.length; i++){
                aux[i] = this.empregados[i];
            }
            empregados = aux;
            this.empregados[cont] = f;

        }else {
            this.empregados[cont] = f;
        }
        cont++;
    }

    public void getEmpregados() {
        for(int i = 0; i < cont; i++) {
            System.out.println("Empregado na posição: " + i);
            System.out.println("Cpf: " + this.empregados[i].cpf);
            System.out.println("Nome: " + this.empregados[i].nome);
        }
    }
    public boolean comtem(model.Funcionario f){
        for(int i = 0; i < cont; i++) {
            if (empregados[i] == f) {
                return true;
            }
        }
        return false;
    }
}
