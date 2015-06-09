
package br.edu.ifpb.pod.app2.teste;

import br.edu.ifpb.pod.app2.dao.UsuarioPersistivelDAO;
import br.edu.ifpb.pod.app2.dao.interfaces.UsuarioPersistivelDAOIF;
import br.edu.ifpb.pod.app2.entidades.UsuarioPersistivel;

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
