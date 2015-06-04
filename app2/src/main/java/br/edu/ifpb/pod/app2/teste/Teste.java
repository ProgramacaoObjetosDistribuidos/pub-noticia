package br.edu.ifpb.pod.app2.teste;

import br.edu.ifpb.pod.app2.dao.DAO;
import br.edu.ifpb.pod.app2.dao.DAOJPA;
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
        System.out.println(noticiaPersistivel.getId());
         List<UsuarioPersistivel> usuarioPersistiveis = dao.consultaLista("usuario.todos", null);

        for (UsuarioPersistivel usuarioPersistivel : usuarioPersistiveis) {
            usuarioPersistivel.addNovaNoticia(noticiaPersistivel);
            dao.atualizar(usuarioPersistivel);
        }
        
        

        listener.avisar(noticiaPersistivel);

    }
}
