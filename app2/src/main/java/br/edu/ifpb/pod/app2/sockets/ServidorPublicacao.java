package br.edu.ifpb.pod.app2.sockets;

import br.edu.ifpb.pod.app2.dao.DAO;
import br.edu.ifpb.pod.app2.entidades.NoticiaPersistivel;
import br.edu.ifpb.pod.app2.sistema.ConverteNoticias;
import br.edu.ifpb.pod.pubnoticia.conversor.ConversorXML;
import edu.ifpb.pod.pubnoticia.core.entidades.Noticia;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.xml.bind.JAXBException;

/**
 *
 * @author DouglasGabriel
 */
public class ServidorPublicacao {

    private static final int PORT = 123456;

    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                new Publicador(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

    private static class Publicador extends Thread {

        private Socket socket;
        private InputStream in;
        private PrintWriter out;
        private Noticia noticia;
        private DAO<NoticiaPersistivel> daoNoticia;

        public Publicador(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = socket.getInputStream();
                out = new PrintWriter(socket.getOutputStream(), true);
                try {
                    out.println("GETNEWS");
                    ByteArrayOutputStream temp = new ByteArrayOutputStream();
                    byte[] b = new byte[1];
                    while ((in.read(b)) != -1) {
                        temp.write(b);
                    }
                    noticia = (Noticia) ConversorXML.xmlParaObjeto(Noticia.class, temp.toByteArray());
                } catch (IOException | JAXBException e) {
                    out.println("ERROR");
                    e.printStackTrace();
                    new Exception(e);
                }
                out.println("SUCCESS");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
            NoticiaPersistivel noticiaPersistivel = ConverteNoticias.converterNoticiaEmNoticiaPersistivel(noticia);
            daoNoticia.salvar(noticiaPersistivel);
            //TODO chamar método da API de Ari para mandar notícia para o site
        }
    }
}
