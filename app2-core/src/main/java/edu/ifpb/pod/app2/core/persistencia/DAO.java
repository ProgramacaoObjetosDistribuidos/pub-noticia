/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.pod.app2.core.persistencia;

import java.util.List;
import java.util.Map;

/**
 *
 * @author job
 * @param <T>
 */
public interface DAO<T> {
    
    public boolean salvar(T obj);
    
    public boolean atualizar(T obj);
    
    public boolean resgatar(T obj);
    
    public boolean excluir(T obj);
    
    public T buscar(Object chave, Class<T> entidade);
    
    public List<T> consultaLista(String nomeConsulta,Map<String,Object> parametros);
    
    public T consultaSimples(String nomeConsulta,Map<String,Object> parametros);
    
    
}
