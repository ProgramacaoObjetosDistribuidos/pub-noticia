
package br.edu.ifpb.pod.app2.persistencia.listener;

import br.edu.ifpb.pod.app2.dao.DAO;
import br.edu.ifpb.pod.app2.dao.DAOJPA;
import br.edu.ifpb.pod.app2.entidades.UsuarioPersistivel;

import java.util.List;
import javax.persistence.PostPersist;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class NoticiaPersistivelListener {

    private final DAO<UsuarioPersistivel> dao;

    public NoticiaPersistivelListener() {
        this.dao=new DAOJPA<>();
    }
    
    
    @PostPersist
    public void posAddNoticia(NoticiaPersistivelListener noticia){
        List<UsuarioPersistivel> usuarioPersistiveis=dao.consultaLista("usuario.todos", null);
        
        
    }
}
