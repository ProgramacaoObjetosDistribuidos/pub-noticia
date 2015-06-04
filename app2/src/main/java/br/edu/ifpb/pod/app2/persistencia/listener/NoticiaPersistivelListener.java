package br.edu.ifpb.pod.app2.persistencia.listener;

import br.edu.ifpb.pod.app2.dao.DAO;
import br.edu.ifpb.pod.app2.dao.DAOJPA;
import br.edu.ifpb.pod.app2.entidades.NoticiaPersistivel;
import br.edu.ifpb.pod.app2.entidades.UsuarioPersistivel;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PostPersist;
import javax.persistence.Query;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class NoticiaPersistivelListener {

    private final DAOJPA<UsuarioPersistivel> daoUsuario = new DAOJPA<>();

    public NoticiaPersistivelListener() {
    }

    @PostPersist
    public void posAddNoticia(NoticiaPersistivel noticia) {
//        List<UsuarioPersistivel> usuarioPersistiveis = daoUsuario.consultaLista("usuario.todos", null);
//
//        for (UsuarioPersistivel usuarioPersistivel : usuarioPersistiveis) {
//            EntityManager entityManager=daoUsuario.getEntityManager();
//            Query query=entityManager.createNativeQuery("INSERT INTO noticia_usuario(notiviapersistivel_email,novasnoticias_id)"
//                    + "VALUES(:email_usuario , :id_noticia)");
//            query.setParameter("email_usuario", usuarioPersistivel.getEmail());
//            query.setParameter("id_noticia", noticia.getId());
//            query.executeUpdate();
//    }
    }
}
