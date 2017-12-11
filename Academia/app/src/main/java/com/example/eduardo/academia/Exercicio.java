package com.example.eduardo.academia;

/**
 * Created by Eduardo on 06/12/2017.
 */

public class Exercicio {

    private Long id;
    private String nome;
    private String url;
    private Long treinoId;

    public Exercicio(Long id, String nome, String url, Long treinoId) {
        this.id = id;
        this.nome = nome;
        this.url = url;
        this.treinoId = treinoId;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getTreinoId() {
        return treinoId;
    }

    public void setTreinoId(Long treinoId) {
        this.treinoId = treinoId;
    }

    public String getNome() {
        return nome;
    }



    public Exercicio() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
