package br.edu.ifpb.pod.app2.sockets;

import br.edu.ifpb.pod.app2.dao.UsuarioPersistivelDAO;
import br.edu.ifpb.pod.app2.dao.interfaces.UsuarioPersistivelDAOIF;
import br.edu.ifpb.pod.app2.entidades.UsuarioPersistivel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class ServidorNotificacao {

    private static final int PORT = 2010;
    private Map<String, UsuarioPersistivel> usuarios;

    public ServidorNotificacao(Map<String, UsuarioPersistivel> usuarios) {
        this.usuarios = usuarios;
    }

    public void inicialize() throws Exception {
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                new ServidorNotificacao.Comunicador(listener.accept()).start();
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
                if (mensagem.startsWith("HASNOTIFICATION")) {
                    if (usuarios.get(id) != null) {
                        UsuarioPersistivel usuario = usuarios.get(id);
                        usuario = usuarioDAO.buscar(usuario.getEmail(), UsuarioPersistivel.class);
                        if (usuario.getNovasNoticias() != null) {
                            out.println("TRUE");
                        }
                    }else{
                        out.println("USERERRO");
                    }
                } else {
                    out.println("MENSAGEERRO");
                }

            } catch (IOException ex) {
                out.println("ERRO");
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
