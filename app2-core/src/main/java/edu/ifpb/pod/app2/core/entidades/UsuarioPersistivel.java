package edu.ifpb.pod.app2.core.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DouglasGabriel
 */
@Entity
@NamedQueries({@NamedQuery(name = "usuario.todos",query = "SELECT u FROM UsuarioPersistivel u")})
public class UsuarioPersistivel implements Serializable {

    @Id
    private String email;
    private String nome;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Noticia> novasNoticias;

    public UsuarioPersistivel() {
        this.novasNoticias=new ArrayList<>();
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

    public List<Noticia> getNovasNoticias() {
        return novasNoticias;
    }

    public void setNovasNoticias(List<Noticia> novasNoticias) {
        this.novasNoticias = novasNoticias;
    }
        
    public void addNovaNoticia (Noticia noticia){
        if(this.novasNoticias==null){
            this.novasNoticias=new ArrayList<>();
        }
        novasNoticias.add(noticia);
    }
    
    public void removeNoticia (Noticia noticia){
        novasNoticias.remove(noticia);
    }
    
}
