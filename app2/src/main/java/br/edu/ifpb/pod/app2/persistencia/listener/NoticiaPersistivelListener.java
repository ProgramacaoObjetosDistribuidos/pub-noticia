package br.edu.ifpb.pod.app2.persistencia.listener;

import br.edu.ifpb.pod.app2.dao.UsuarioPersistivelDAO;
import br.edu.ifpb.pod.app2.dao.interfaces.UsuarioPersistivelDAOIF;
import br.edu.ifpb.pod.app2.entidades.NoticiaPersistivel;
import br.edu.ifpb.pod.app2.entidades.UsuarioPersistivel;
import java.util.List;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class NoticiaPersistivelListener implements PersisteNoticiaListener {

    private final UsuarioPersistivelDAOIF usuarioPersistivelDAO = new UsuarioPersistivelDAO();

    public NoticiaPersistivelListener() {
    }

    @Override
    public void avisar(NoticiaPersistivel noticia) {
        Thread thread = new Thread(){
            @Override
            public void run() {              
                List<UsuarioPersistivel> usuarios = usuarioPersistivelDAO.consultaLista("usuario.todos", null);
                for (UsuarioPersistivel u : usuarios) {
                    UsuarioPersistivel usuario=usuarioPersistivelDAO.buscar(u.getEmail(), UsuarioPersistivel.class);
                    usuario.addNovaNoticia(noticia);
                    usuarioPersistivelDAO.atualizar(usuario);
                }
            }
        };
        thread.start();
    }

}
