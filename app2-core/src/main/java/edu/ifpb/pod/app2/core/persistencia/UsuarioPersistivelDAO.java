
package edu.ifpb.pod.app2.core.persistencia;

import edu.ifpb.pod.app2.core.persistencia.UsuarioPersistivelDAOIF;
import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class UsuarioPersistivelDAO extends DAOJPA<UsuarioPersistivel> implements UsuarioPersistivelDAOIF{

    public UsuarioPersistivelDAO(){
        this("edu.ifpb.pod_app2b");
    }
    public UsuarioPersistivelDAO (String unidadePersistencia){
        super(unidadePersistencia);
    }
    
    
}
