package model;

/**
 * Created by aluno on 13/03/18.
 */
public class Jornalista extends Pessoa{

    public Jornalista(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Noticia criarNoticia(String titulo, String corpo, Area area){

        Noticia nova = new Noticia(titulo,corpo,area, this);

        return nova;

    }
}
