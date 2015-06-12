package edu.ifpb.pod.app2b.socket.main;

import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;
import edu.ifpb.pod.app2b.socket.ServidorLogin;
import java.util.HashMap;

/**
 *
 * @author DouglasGabriel
 */
public class TesteLogin {
    
    public static void main(String[] args) throws Exception {
        ServidorLogin servidor = new ServidorLogin(new HashMap<String, UsuarioPersistivel>());
        servidor.inicialize();
    }
}
