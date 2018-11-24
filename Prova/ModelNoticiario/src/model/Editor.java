package model;

/**
 * Created by aluno on 13/03/18.
 */
public class Editor extends Pessoa{
    
    private Area area;

    public Editor(String nome, String email, String senha, Area area) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.area = area;
    }

    public void publicar(Noticia noticia){
        noticia.publicarNot(this);
    }

    public void desativar(Noticia noticia){
        noticia.desativarNot(this);
    }

    public Area getArea() {
        return area;
    }
}
