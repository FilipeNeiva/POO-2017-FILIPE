package ifpi.edu.br.gerenciadorterefas.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

/**
 * Created by aluno on 14/03/18.
 */
@Entity
public class Usuario {
    @Id
    private long id;
    private String nome;
    private String senha;
    private ToMany<Tarefa> tarefas;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void addTarefa(Tarefa tarefa){
        this.tarefas.add(tarefa);
    }

    public void desativa(Long id){
        tarefas.removeById(id);
    }

    public ToMany<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setId(long id) {
        this.id = id;
    }
}
