package Cap5.Questao01.app;

import Cap5.Questao01.model.Empresa;

public class TestaEmpresa {

    public static void main(String[] args) {
        Empresa petrobraz = new Empresa("156458");
        petrobraz.empregados = new model.Funcionario[2];

        model.Funcionario f1 = new model.Funcionario();
        f1.cpf = "496545";
        f1.nome = "jesus adad";

        petrobraz.adiciona(f1);
        petrobraz.getEmpregados();

        model.Funcionario f2 = new model.Funcionario();
        if(petrobraz.comtem(f2)){
            System.out.println("tem sim chefe");
        }else
            System.out.println("tem nada");
    }
}
