package br.edu.ifpb.pod.app2.teste;

import br.edu.ifpb.pod.app2.dao.interfaces.DAO;
import br.edu.ifpb.pod.app2.dao.NoticiaPersistivelDAO;
import br.edu.ifpb.pod.app2.dao.UsuarioPersistivelDAO;
import br.edu.ifpb.pod.app2.dao.interfaces.NoticiaPersistiveDAOlIF;
import br.edu.ifpb.pod.app2.dao.interfaces.UsuarioPersistivelDAOIF;
import br.edu.ifpb.pod.app2.entidades.NoticiaPersistivel;
import br.edu.ifpb.pod.app2.entidades.UsuarioPersistivel;
import java.util.List;
import br.edu.ifpb.pod.app2.persistencia.listener.NoticiaPersistivelListener;
import br.edu.ifpb.pod.app2.persistencia.listener.PersisteNoticiaListener;


/**
 *
 * @author DouglasGabriel
 */
public class Teste {

    public static void main(String[] args) { 
        PersisteNoticiaListener listener = new NoticiaPersistivelListener();
        UsuarioPersistivelDAOIF dao=new UsuarioPersistivelDAO();
        NoticiaPersistiveDAOlIF dao1=new NoticiaPersistivelDAO();
        UsuarioPersistivel usuario = new UsuarioPersistivel();
        usuario.setNome("Douglas");
        usuario.setEmail("douglas@mail.com");
        dao.salvar(usuario);
        NoticiaPersistivel noticiaPersistivel=new NoticiaPersistivel();
        noticiaPersistivel.setConteudo("LOrem llslsls");
        noticiaPersistivel.setResumo("Oiiiiiiiii");
        dao1.salvar(noticiaPersistivel);
        Teste2 teste2=new Teste2();
        teste2.teste();
        

    }
}
