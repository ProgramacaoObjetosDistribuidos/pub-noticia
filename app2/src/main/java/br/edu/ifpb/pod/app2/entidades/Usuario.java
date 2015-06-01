package br.edu.ifpb.pod.app2.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author DouglasGabriel
 */
@Entity
public class Usuario {
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
