/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.pod.app2.core.persistencia;

import edu.ifpb.pod.app2.core.entidades.Noticia;
import java.util.List;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public interface NoticiaPersistiveDAOlIF extends DAO<Noticia>{
    
    public List<Noticia> getNoticiasNaoNotificadas ();
    
}
