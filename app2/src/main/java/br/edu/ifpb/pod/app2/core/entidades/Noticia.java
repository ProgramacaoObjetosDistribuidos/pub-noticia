package br.edu.ifpb.pod.app2.core.entidades;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DouglasGabriel
 */
@XmlRootElement
public class Noticia {
    private long id;
    private String autor, resumo, conteudo;
    private byte[] imagem;
    private boolean lida;

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }        

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
