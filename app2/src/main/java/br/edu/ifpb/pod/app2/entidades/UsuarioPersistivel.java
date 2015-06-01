package br.edu.ifpb.pod.app2.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author DouglasGabriel
 */
@Entity
public class UsuarioPersistivel implements Serializable {
    @GeneratedValue
    @Id
    private String email;
    private String nome;

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
    
}
