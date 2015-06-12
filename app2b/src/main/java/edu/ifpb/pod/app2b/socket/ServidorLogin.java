package edu.ifpb.pod.app2b.socket;

import edu.ifpb.pod.app2.core.conversor.xml.ConversorXML;
import edu.ifpb.pod.app2.core.persistencia.UsuarioPersistivelDAO;
import edu.ifpb.pod.app2.core.persistencia.DAO;
import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;
import edu.ifpb.pod.app2b.pojos.LoginResponse;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Map;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Emanuel Batista da Silva Filho
 * @author DouglasGabriel
 */
public class ServidorLogin {

    private static final int PORT = 1234;
    private Map<String, UsuarioPersistivel> usuarios;
    private DAO<UsuarioPersistivel> daoUsuario = new UsuarioPersistivelDAO("edu.ifpb.pod_app2b");

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
        private BufferedReader in;
        private String mensagem;

        public Comunicador(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            LoginResponse response = new LoginResponse();
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
                mensagem = in.readLine();
                if (mensagem.startsWith("TOKEN:")) {
                    response = gerarResposta(mensagem.substring(6));
                    UsuarioPersistivel user
                            = daoUsuario.buscar(
                                    response.getEmail(), UsuarioPersistivel.class
                            );
                    if (user != null) {
                        usuarios.put(response.getSession(), user);
                        response.setSession(System.currentTimeMillis() + response.getEmail());
                        out.println(response.getSession());
                    } else {
                        response.setError("Usuario nao cadastrado");
                    }
                } else {
                    response.setError("Erro de protocolo");
                }
            } catch (IOException ex) {
                response.setError("Erro ao processar token");
                ex.printStackTrace();
            } finally {
                try {
                    byte[] b = ConversorXML.objetoParaXml(LoginResponse.class, response);
                    out.println(new String(b, "utf-8"));
                    socket.close();
                } catch (Exception ex) {
                }
            }            
        }       

        private LoginResponse gerarResposta(String token) throws MalformedURLException, IOException {
            String host = "https://graph.facebook.com/me?access_token=" + token;
            System.out.println(host);
            URL url = new URL(host);
            BufferedReader input =  new BufferedReader(new InputStreamReader(url.openStream()));
            String[] retorno = input.readLine().split(",");
            LoginResponse response = new LoginResponse();
            for (String prop : retorno) {
                if (prop.startsWith("\"email\":")) {
                    String email = prop.replace("\"", "").substring(6).replace("\\u0040", "@");
                    response.setEmail(email);
                } else if (prop.startsWith("\"name\":")) {
                    String name = prop.replace("\"", "").substring(5);
                    response.setName(name);
                }
            }            
            return response;
        }

    }
}
