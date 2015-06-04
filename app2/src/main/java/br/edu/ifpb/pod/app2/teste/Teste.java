package br.edu.ifpb.pod.app2.teste;

import br.edu.ifpb.pod.app2.dao.DAO;
import br.edu.ifpb.pod.app2.dao.DAOJPA;
import br.edu.ifpb.pod.app2.entidades.NoticiaPersistivel;
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
        DAO<UsuarioPersistivel> dao=new DAOJPA<>();
        DAO<NoticiaPersistivel> dao1=new DAOJPA<>();
        UsuarioPersistivel usuario = new UsuarioPersistivel();
        usuario.setNome("Douglas");
        usuario.setEmail("douglas@mail.com");
        dao.salvar(usuario);
        NoticiaPersistivel noticiaPersistivel=new NoticiaPersistivel();
        noticiaPersistivel.setConteudo("LOrem llslsls");
        noticiaPersistivel.setResumo("Oiiiiiiiii");
        dao1.salvar(noticiaPersistivel);
        
    }

  
}
