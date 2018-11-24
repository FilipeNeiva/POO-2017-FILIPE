package ifpi.edu.br.gerenciadorterefas.model;

import java.util.Date;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by aluno on 14/03/18.
 */
@Entity
public class Tarefa {

    @Id
    private long id;
    private String titulo;
    private String descricao;
    private Date dataLimite;
    private String estado;

    public Tarefa(String titulo, String descricao, String estado) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.estado = estado;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }


    public String getEstado() {
        return estado;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }
}
