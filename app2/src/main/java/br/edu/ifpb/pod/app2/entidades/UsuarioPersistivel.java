package br.edu.ifpb.pod.app2.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

/**
 *
 * @author DouglasGabriel
 */
@Entity
@NamedQueries({@NamedQuery(name = "usuario.todos",query = "SELECT u FROM UsuarioPersistivel u")})
public class UsuarioPersistivel implements Serializable {

    @Id
    private String email;
    @Transient
    private String idSessao;
    private String nome;
//    @Basic(fetch = FetchType.LAZY)
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<NoticiaPersistivel> novasNoticias;

    public UsuarioPersistivel() {
//        this.novasNoticias=new ArrayList<>();
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
        
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(String idSessao) {
        this.idSessao = idSessao;
    }

    public List<NoticiaPersistivel> getNovasNoticias() {
        return novasNoticias;
    }

    public void setNovasNoticias(List<NoticiaPersistivel> novasNoticias) {
        this.novasNoticias = novasNoticias;
    }
        
    public void addNovaNoticia (NoticiaPersistivel noticia){
        novasNoticias.add(noticia);
    }
    
    public void removeNoticia (NoticiaPersistivel noticia){
        novasNoticias.remove(noticia);
    }
    
}
