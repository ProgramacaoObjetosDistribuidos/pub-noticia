package br.edu.ifpb.pod.app2.persistencia.listener;

import br.edu.ifpb.pod.app2.entidades.NoticiaPersistivel;

/**
 *
 * @author DouglasGabriel
 */
public interface PersisteNoticiaListener {

    void avisar(NoticiaPersistivel noticia);
}
