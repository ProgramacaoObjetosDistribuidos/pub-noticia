package br.edu.ifpb.pod.app2.persistencia.listener;

import br.edu.ifpb.pod.app2.dao.DAO;
import br.edu.ifpb.pod.app2.dao.DAOJPA;
import br.edu.ifpb.pod.app2.entidades.NoticiaPersistivel;
import br.edu.ifpb.pod.app2.entidades.UsuarioPersistivel;
import java.util.List;
import javax.persistence.PostPersist;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class NoticiaPersistivelListener implements PersisteNoticiaListener{

    private final DAO<UsuarioPersistivel> daoUsuario = new DAOJPA<>();
    private final DAO<NoticiaPersistivel> daoNoticia = new DAOJPA<>();

    public NoticiaPersistivelListener() {
//        this.dao = ;
    }

    public void posAddNoticia(NoticiaPersistivel noticia) {
        List<UsuarioPersistivel> usuarioPersistiveis = daoUsuario.consultaLista("usuario.todos", null);

        for (UsuarioPersistivel usuarioPersistivel : usuarioPersistiveis) {
            UsuarioPersistivel usuario=daoUsuario.buscar(usuarioPersistivel.getEmail(), UsuarioPersistivel.class);
            usuario.addNovaNoticia(noticia);
            daoUsuario.atualizar(usuario);
        }

    }

    @Override
    public void avisar(NoticiaPersistivel noticia) {
        List<UsuarioPersistivel> usuarioPersistiveis = daoUsuario.consultaLista("usuario.todos", null);

        for (UsuarioPersistivel usuarioPersistivel : usuarioPersistiveis) {
            UsuarioPersistivel usuario=daoUsuario.buscar(usuarioPersistivel.getEmail(), UsuarioPersistivel.class);
            usuario.addNovaNoticia(noticia);
            daoUsuario.atualizar(usuario);
        }
    }

}
