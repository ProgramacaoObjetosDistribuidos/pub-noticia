package br.edu.ifpb.pod.app2.persistencia.listener;

import edu.ifpb.pod.app2.core.entidades.NoticiaPersistivel;
import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;
import java.util.Map;

/**
 *
 * @author DouglasGabriel
 */
public interface PersisteNoticiaListener {

    void avisar(NoticiaPersistivel noticia, Map<String, UsuarioPersistivel> mapaUsuarios);
}
