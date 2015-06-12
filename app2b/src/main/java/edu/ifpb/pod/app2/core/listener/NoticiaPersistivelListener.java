package edu.ifpb.pod.app2.core.listener;

import edu.ifpb.pod.app2.core.persistencia.UsuarioPersistivelDAO;
import edu.ifpb.pod.app2.core.persistencia.UsuarioPersistivelDAOIF;
import edu.ifpb.pod.app2.core.entidades.Noticia;
import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class NoticiaPersistivelListener implements PersisteNoticiaListener {

    private final UsuarioPersistivelDAOIF usuarioPersistivelDAO = new UsuarioPersistivelDAO("edu.ifpb.pod_app2b");

    public NoticiaPersistivelListener() {
    }

    @Override
    public void avisar(Noticia noticia, Map<String, UsuarioPersistivel> mapaUsuarios) {
        Thread thread = new Thread(){
            @Override
            public void run() {              
                List<UsuarioPersistivel> usuarios = usuarioPersistivelDAO.consultaLista("usuario.todos", null);
                for (UsuarioPersistivel u : usuarios) {                    
                    UsuarioPersistivel usuario=usuarioPersistivelDAO.buscar(u.getEmail(), UsuarioPersistivel.class);
                    usuario.addNovaNoticia(noticia);
                    usuarioPersistivelDAO.atualizar(usuario);
                }
                for (String key: mapaUsuarios.keySet()){
                    UsuarioPersistivel usuarioPersistivel = mapaUsuarios.get(key);
                    usuarioPersistivelDAO.atualizar(usuarioPersistivel);
                }
            }                        
        };
        thread.start();
    }

}
