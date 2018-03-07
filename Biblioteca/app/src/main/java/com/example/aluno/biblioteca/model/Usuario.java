package com.example.aluno.biblioteca.model;


import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

/**
 * Created by aluno on 26/02/18.
 */

@Entity
public class Usuario {

    @Id
    private long id;

    private String nome;
    private String email;
    private String senha;
    public ToMany<Livro> livros;
    public Usuario() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void addLivro(Livro livro) {
        this.livros.add(livro);
    }

    public Livro buscaLivro(long id){
        return livros.getById(id);
    }

    public void changeLivro(Livro livro, long id){
        livros.getById(id).setNome(livro.getNome());
        livros.getById(id).setNumPag(livro.getNumPag());
        livros.getById(id).setAutor(livro.getAutor());
        livros.getById(id).setDataLancamento(livro.getDataLancamento());
    }

    public void removeLivro(Livro livro){
        livros.remove(livro);
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ToMany<Livro> livros) {
        this.livros = livros;
    }
}
