package br.edu.ifpb.pod.app2.loader;

import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;
import edu.ifpb.pod.app2b.socket.ServidorLogin;
import br.edu.ifpb.pod.app2.sockets.ServidorNotificacao;
import edu.ifpb.pod.app2a.sockets.ServidorPublicacao;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DouglasGabriel
 */
public class Loader {

    public static void main(String[] args) throws Exception {
        Map<String, UsuarioPersistivel> usuarios = new HashMap<>();
        ServidorPublicacao servidorPublicacao = new ServidorPublicacao(usuarios);
        ServidorNotificacao servidorNotificacao = new ServidorNotificacao(usuarios);
        ServidorLogin servidorLogin = new ServidorLogin(usuarios);
        servidorLogin.inicialize();
    }
}
