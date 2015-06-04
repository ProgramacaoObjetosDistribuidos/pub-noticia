package br.edu.ifpb.pod.app2.dao;

import br.edu.ifpb.pod.app2.dao.interfaces.NoticiaPersistiveDAOlIF;
import br.edu.ifpb.pod.app2.entidades.NoticiaPersistivel;
import br.edu.ifpb.pod.app2.persistencia.listener.NoticiaPersistivelListener;
import br.edu.ifpb.pod.app2.persistencia.listener.PersisteNoticiaListener;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class NoticiaPersistivelDAO extends DAOJPA<NoticiaPersistivel> implements NoticiaPersistiveDAOlIF {

    @Override
    public boolean salvar(NoticiaPersistivel noticia) {
        super.salvar(noticia);
        PersisteNoticiaListener listener=new NoticiaPersistivelListener();
        listener.avisar(noticia);
       return true;
    }
}
