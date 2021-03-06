package edu.ifpb.pod.app2.core.persistencia;

import edu.ifpb.pod.app2.core.persistencia.DAO;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author job
 * @param <T>
 */
class DAOJPA<T> implements DAO<T> {

    protected EntityManager entityManager;

    public DAOJPA() {
        this("br.edu.ifpb.pod_pubnoticia-app2");
    }

    public DAOJPA(String unidadePersistencia) {
        entityManager = Persistence.createEntityManagerFactory(unidadePersistencia).createEntityManager();

    }

    @Override
    public boolean salvar(T obj) {
        EntityTransaction transacao = entityManager.getTransaction();

        try {
            transacao.begin();
            entityManager.persist(obj);
            transacao.commit();
            return true;
        } catch (Exception ex) {
            if (transacao.isActive()) {
                transacao.rollback();
            }
            return false;
        }

    }

    @Override
    public boolean atualizar(T obj) {
        EntityTransaction transacao = entityManager.getTransaction();

        try {
            transacao.begin();
            entityManager.merge(obj);
            transacao.commit();
            return true;
        } catch (Exception ex) {
            if (transacao.isActive()) {
                transacao.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean excluir(T obj) {
        EntityTransaction transacao = entityManager.getTransaction();

        try {
            transacao.begin();
            entityManager.remove(obj);
            transacao.commit();
            return true;
        } catch (Exception ex) {
            if (transacao.isActive()) {
                transacao.rollback();
            }
            return false;
        }
    }

    @Override
    public T buscar(Object chave, Class<T> entidade) {
        return entityManager.find(entidade, chave);
    }

    @Override
    public List<T> consultaLista(String nomeConsulta, Map<String, Object> parametros) {
        Query query = entityManager.createNamedQuery(nomeConsulta);
        if (parametros != null && !parametros.isEmpty()) {
            for (String parametro : parametros.keySet()) {
                query.setParameter(parametro, parametros.get(parametro));
            }
        }
        return query.getResultList();
    }

    @Override
    public T consultaSimples(String nomeConsulta, Map<String, Object> parametros) {
        Query query = entityManager.createNamedQuery(nomeConsulta);
        if (parametros != null && !parametros.isEmpty()) {
            for (String parametro : parametros.keySet()) {
                query.setParameter(parametro, parametros.get(parametro));
            }
        }
        return (T) query.getSingleResult();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public boolean resgatar(T obj) {
        EntityTransaction transacao = entityManager.getTransaction();

        try {
            transacao.begin();
            entityManager.refresh(obj);
            transacao.commit();
            return true;
        } catch (Exception ex) {
            if (transacao.isActive()) {
                transacao.rollback();
            }
            return false;
        }
    }

}
