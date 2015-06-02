package br.edu.ifpb.pod.app2.persistencia;

/**
 *
 * @author DouglasGabriel
 */
public interface DAO<T> {
    
    public boolean salvar(T obj);
    
    public boolean atualizar(T obj);
    
    public boolean excluir(T obj);
    
    public T buscar(Object chave, Class<T> entidade);
    
}
