package edu.ifpb.pod.app2.core.persistencia;

import edu.ifpb.pod.app2.core.entidades.NoticiaPersistivel;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Emanuel Batista da Silva Filho
 * @author DouglasGabriel
 */
public class NoticiaPersistivelDAO extends DAOJPA<NoticiaPersistivel> implements NoticiaPersistiveDAOlIF {

    public NoticiaPersistivelDAO (String unidadePersistencia){
        super(unidadePersistencia);
    }
    
    public NoticiaPersistivelDAO(){
        
    }
    
    @Override
    public boolean salvar(NoticiaPersistivel noticia) {
       super.salvar(noticia);       
       return true;
    }

    @Override
    public List<NoticiaPersistivel> getNoticiasNaoNotificadas() {
        Query query = entityManager.createQuery(
                "SELECT n FROM NoticiaPersistivel n WHERE n.notificada = false"
        );
        return query.getResultList();
    }
}
