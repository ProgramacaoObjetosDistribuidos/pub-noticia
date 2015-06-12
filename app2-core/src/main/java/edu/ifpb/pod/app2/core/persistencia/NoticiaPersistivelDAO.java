package edu.ifpb.pod.app2.core.persistencia;

import edu.ifpb.pod.app2.core.entidades.Noticia;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Emanuel Batista da Silva Filho
 * @author DouglasGabriel
 */
public class NoticiaPersistivelDAO extends DAOJPA<Noticia> implements NoticiaPersistiveDAOlIF {

    public NoticiaPersistivelDAO (String unidadePersistencia){
        super(unidadePersistencia);
    }
    
    public NoticiaPersistivelDAO(){
        
    }
    
    @Override
    public boolean salvar(Noticia noticia) {
       super.salvar(noticia);       
       return true;
    }

    @Override
    public List<Noticia> getNoticiasNaoNotificadas() {
        Query query = entityManager.createQuery(
                "SELECT n FROM Noticia n WHERE n.notificada = false"
        );
        return query.getResultList();
    }
}
