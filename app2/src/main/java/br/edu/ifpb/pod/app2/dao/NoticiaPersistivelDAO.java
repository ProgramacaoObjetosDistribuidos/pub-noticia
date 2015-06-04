package br.edu.ifpb.pod.app2.dao;

import br.edu.ifpb.pod.app2.dao.interfaces.NoticiaPersistiveDAOlIF;
import br.edu.ifpb.pod.app2.dao.interfaces.UsuarioPersistivelDAOIF;
import br.edu.ifpb.pod.app2.entidades.NoticiaPersistivel;
import br.edu.ifpb.pod.app2.entidades.UsuarioPersistivel;
import java.util.List;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class NoticiaPersistivelDAO extends DAOJPA<NoticiaPersistivel> implements NoticiaPersistiveDAOlIF {

    @Override
    public boolean salvar(NoticiaPersistivel noticia) {
        super.salvar(noticia);
        Runnable runnable = () -> {
            UsuarioPersistivelDAOIF usuarioPersistivelDAO = new UsuarioPersistivelDAO();
            List<UsuarioPersistivel> usuarios = usuarioPersistivelDAO.consultaLista("usuario.todos", null);
            for (UsuarioPersistivel usuario : usuarios) {
                usuario.addNovaNoticia(noticia);
                usuarioPersistivelDAO.atualizar(usuario);
            }
        };
       return true;
    }
}
