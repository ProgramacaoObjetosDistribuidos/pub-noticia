package br.edu.ifpb.pod.app2.sockets;

import br.edu.ifpb.pod.app2.dao.NoticiaPersistivelDAO;
import br.edu.ifpb.pod.app2.dao.interfaces.NoticiaPersistiveDAOlIF;
import br.edu.ifpb.pod.app2.entidades.NoticiaPersistivel;
import br.edu.ifpb.pod.app2.sistema.ConverteNoticias;
import br.edu.ifpb.pod.pubnoticia.conversor.ConversorXML;
import edu.ifpb.pod.pubnoticia.core.entidades.Noticia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author DouglasGabriel
 */
public class ServidorPublicacao {

    private static final int PORT = 12345;

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
        private BufferedReader in;
        private PrintWriter out;
        private Noticia noticia;
        private NoticiaPersistiveDAOlIF daoNoticia;

        public Publicador(Socket socket) {
            this.socket = socket;
            this.daoNoticia=new NoticiaPersistivelDAO();
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                try {
                    out.println("GETNEWS");
                    noticia = (Noticia) ConversorXML.xmlParaObjeto(Noticia.class, in.readLine().getBytes());
                } catch (Exception e) {
                    out.println("ERROR");
                    out.flush();
                    e.printStackTrace();
                    throw new Exception(e);
                }
                out.println("SUCCESS");
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
//            System.out.println(noticia.getConteudo());
//            NoticiaPersistivel noticiaPersistivel = ConverteNoticias.converterNoticiaEmNoticiaPersistivel(noticia);
//            System.out.println(noticiaPersistivel.getConteudo());
//            daoNoticia.salvar(noticiaPersistivel);
//            System.out.println(noticiaPersistivel.getConteudo());
            //TODO chamar método da API de Ari para mandar notícia para o site
        }
    }
}
