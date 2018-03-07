package com.example.aluno.biblioteca.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by aluno on 26/02/18.
 */
@Entity
public class Livro {

    @Id
    private long id;
    private String nome;
    private int numPag;
    private String dataLancamento;
    private String autor;
    private String situacao;

    public Livro() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }


    public String getNome() {
        return nome;
    }

    public int getNumPag() {
        return numPag;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public String getAutor() {
        return autor;
    }


    public String getSituacao() {
        return situacao;
    }
}
