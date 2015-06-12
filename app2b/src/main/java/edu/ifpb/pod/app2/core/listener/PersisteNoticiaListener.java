package edu.ifpb.pod.app2.core.listener;

import edu.ifpb.pod.app2.core.entidades.Noticia;
import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;
import java.util.Map;

/**
 *
 * @author DouglasGabriel
 */
public interface PersisteNoticiaListener {

    void avisar(Noticia noticia);
}
