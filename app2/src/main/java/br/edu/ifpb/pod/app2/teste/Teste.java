package br.edu.ifpb.pod.app2.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.edu.ifpb.pod.app2.entidades.UsuarioPersistivel;

/**
 *
 * @author DouglasGabriel
 */
public class Teste {

    public static void main(String[] args) {        
        UsuarioPersistivel usuario = new UsuarioPersistivel();
        usuario.setNome("Douglas");
        persist(usuario);
    }

    public static void persist(Object object) {        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.edu.ifpb.pod_pubnoticia-app2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
