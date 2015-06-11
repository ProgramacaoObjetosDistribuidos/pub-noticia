package br.edu.ifpb.pod.app2.sockets;

import edu.ifpb.pod.app2.core.persistencia.UsuarioPersistivelDAO;
import edu.ifpb.pod.app2.core.persistencia.DAO;
import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Map;

/**
 *
 * @author Emanuel Batista da Silva Filho
 * @author DouglasGabriel
 */
public class ServidorLogin {

    private static final int PORT = 12342;    
    private Map<String, UsuarioPersistivel> usuarios;
    private DAO<UsuarioPersistivel> daoUsuario = new UsuarioPersistivelDAO();

    public ServidorLogin(Map<String, UsuarioPersistivel> usuarios) {
        this.usuarios = usuarios;
    }

    public void inicialize() throws Exception {
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                new Comunicador(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

    private class Comunicador extends Thread {

        private Socket socket;
        private PrintWriter out;
        private InputStream in;
        private String mensagem;

        public Comunicador(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);                
                in = socket.getInputStream();
                mensagem = respostaCliente();
                if (mensagem.startsWith("TOKEN:")) {
                    String userEmail = recuperarEmail(mensagem.substring(6));
                    UsuarioPersistivel user
                            = daoUsuario.buscar(
                                    userEmail, UsuarioPersistivel.class
                            );
                    if (user != null) {
                        usuarios.put(userEmail, user);
                        out.println(System.currentTimeMillis()+userEmail);
                    }else{
                        //criar um objeto response 
                        out.println("ERRO:Usuario nao cadastrado");
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException ex) {
                }
            }
        }

        private String respostaCliente() throws IOException {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] b = new byte[1];
            while (in.read(b) != -1) {
                outputStream.write(b);
            }
            return new String(outputStream.toByteArray());
        }

        private String recuperarEmail(String token) throws MalformedURLException, IOException {
            URL url = new URL(
                    "https://graph.facebook.com/me?access_token=" + token
            );
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            InputStream input = url.openStream();
            byte[] b = new byte[1];
            while ((input.read(b)) != 1) {
                output.write(b);
            }
            //TODO verificar encoding para não quebrar e-mail
            String[] retorno = new String(output.toByteArray()).split(",");            
            for (String prop: retorno){
                if (prop.startsWith("\"email\":")){
                    prop.replace("\"", "");
                    return prop.substring(6);
                }                    
            }
            return null;
        }

    }
}
