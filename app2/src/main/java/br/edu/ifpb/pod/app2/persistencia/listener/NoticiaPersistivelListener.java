package br.edu.ifpb.pod.app2.persistencia.listener;

import br.edu.ifpb.pod.app2.dao.DAOJPA;
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

    private final DAOJPA<UsuarioPersistivel> daoUsuario = new DAOJPA<>();

    public NoticiaPersistivelListener() {
    }

    @Override
    public void avisar(NoticiaPersistivel noticia) {
        Runnable runnable = () -> {
            UsuarioPersistivelDAOIF usuarioPersistivelDAO = new UsuarioPersistivelDAO();
            List<UsuarioPersistivel> usuarios = usuarioPersistivelDAO.consultaLista("usuario.todos", null);
            for (UsuarioPersistivel usuario : usuarios) {
                usuario.addNovaNoticia(noticia);
                usuarioPersistivelDAO.atualizar(usuario);
            }
        };
    }

}
