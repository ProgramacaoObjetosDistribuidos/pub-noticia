package br.edu.ifpb.pod.app2.sockets;

import edu.ifpb.pod.app2.core.conversor.xml.ConversorXML;
import edu.ifpb.pod.app2.core.entidades.Noticias;
import edu.ifpb.pod.app2.core.persistencia.UsuarioPersistivelDAO;
import edu.ifpb.pod.app2.core.persistencia.UsuarioPersistivelDAOIF;
import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 *
 * @author DouglasGabriel
 */
public class ServidorNoticias{

    private static final int PORT = 12344;
    private Map<String, UsuarioPersistivel> usuarios;

    public ServidorNoticias(Map<String, UsuarioPersistivel> usuarios) {
        this.usuarios = usuarios;
    }

    public void inicialize() throws Exception {
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                new ServidorNoticias.Comunicador(listener.accept()).start();
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
        private UsuarioPersistivelDAOIF usuarioDAO;

        public Comunicador(Socket socket) {
            this.socket = socket;
            this.usuarioDAO = new UsuarioPersistivelDAO();
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("ACCEPTED");
                in = socket.getInputStream();
                mensagem = gerarString();
                String id = mensagem.substring(16);
                if (mensagem.startsWith("GETNEWS")) {
                    UsuarioPersistivel usuario;
                    if ((usuario = usuarios.get(mensagem.split(":")[1])) != null) {                        
                        if (usuario.getNovasNoticias() != null) {
                            Noticias noticias = new Noticias(usuario.getNovasNoticias());
                            out.println(ConversorXML.objetoParaXml(Noticias.class, noticias));
                        }
                    }else{
                        out.println("USERERRO");
                    }
                } else {
                    out.println("MENSAGEERRO");
                }

            } catch (Exception ex) {
                out.println("ERRO");
                ex.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException ex) {
                }
            }
        }

        private String gerarString() throws IOException {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] b = new byte[1];
            while (in.read(b) != -1) {
                outputStream.write(b);
            }
            return new String(outputStream.toByteArray());
        }

    }
}
