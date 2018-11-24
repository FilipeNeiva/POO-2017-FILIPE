package model;

import java.util.List;

/**
 * Created by aluno on 13/03/18.
 */
public class Noticia {

    private String titulo;
    private String corpo;
    private Jornalista autor;
    private Area area;
    private String nivel;
    private List<Noticia> associadas;
    private String estado;

    public Noticia(String titulo, String corpo, Area area, Jornalista jornalista) {
        this.titulo = titulo;
        this.corpo = corpo;
        this.area = area;
        this.autor = jornalista;
        this.estado = "criada";
    }

    public void addAssociados(Noticia noticia){
        this.associadas.add(noticia);
    }

    public void setAssociadas(List<Noticia> associadas) {
        this.associadas = associadas;
    }

    protected void publicarNot(Editor editor){

        if (editor.getArea().equals(this.area)) this.estado = "publicada";

    }

    protected void desativarNot(Editor editor){
        if (editor.getArea().equals(this.area)) this.estado = "desativada";
    }
    protected void setNivel(String nivel, EditorChefe editorChefe){
        if (nivel.equals("principal") || nivel.equals("destaque")) this.nivel = nivel;
    }

}
