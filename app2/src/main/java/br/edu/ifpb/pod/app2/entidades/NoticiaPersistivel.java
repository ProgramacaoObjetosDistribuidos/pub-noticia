package br.edu.ifpb.pod.app2.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author DouglasGabriel
 * 
 * Entidade que representa a Notícia e permite a persistencia da mesma no banco
 * de dados. Difere da outra entidade Notícia, pelo fato de possuir anotações JPA
 */
@Entity
public class NoticiaPersistivel implements Serializable {

    @GeneratedValue
    @Id
    private long id;
    private String autores, resumo;
    @Lob
    private String conteudo;
    @Lob
    private byte[] imagem;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
  
}
