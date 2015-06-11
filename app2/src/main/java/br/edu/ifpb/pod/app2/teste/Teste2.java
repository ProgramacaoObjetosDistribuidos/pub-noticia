
package br.edu.ifpb.pod.app2.teste;

import edu.ifpb.pod.app2.core.persistencia.UsuarioPersistivelDAO;
import edu.ifpb.pod.app2.core.persistencia.UsuarioPersistivelDAOIF;
import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class Teste2 {

    protected void teste() {
        UsuarioPersistivelDAOIF usuarioPersistivelDAOIF=new UsuarioPersistivelDAO();
        UsuarioPersistivel u=usuarioPersistivelDAOIF.buscar("douglas@mail.com", UsuarioPersistivel.class);
        u.getNovasNoticias().forEach(x->System.out.println(x));
    }

    
}
