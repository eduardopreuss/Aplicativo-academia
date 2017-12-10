package ifrs.pw2.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Exercicio implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private String url;
    private String treinoId;

    public Exercicio(){}

    public Exercicio(Long id, String nome, String url, String treinoId) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   @Override
    public String toString() {
        return "{\"id\":\"" + id + "\", \"nome\":\"" + nome+"\", \"url\":\""+url+"\", \"treinoId\":\""+treinoId+"\"}";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTreinoId() {
        return treinoId;
    }

    public void setTreinoId(String treinoId) {
        this.treinoId = treinoId;
    }


}
