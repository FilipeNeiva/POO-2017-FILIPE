package model;

/**
 * Created by aluno on 13/03/18.
 */
public class EditorChefe extends Editor {

    public EditorChefe(String nome, String email, String senha, Area area) {
        super(nome, email, senha, area);
    }

    public void alterNivel(Noticia noticia, String nivel){
        noticia.setNivel(nivel);
    }
}
