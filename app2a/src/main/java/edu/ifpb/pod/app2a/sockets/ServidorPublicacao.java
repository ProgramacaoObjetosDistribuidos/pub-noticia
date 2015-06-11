package edu.ifpb.pod.app2a.sockets;

import edu.ifpb.pod.app2.core.configuracao.Configuracoes;
import edu.ifpb.pod.app2.core.persistencia.NoticiaPersistivelDAO;
import edu.ifpb.pod.app2.core.persistencia.NoticiaPersistiveDAOlIF;
import edu.ifpb.pod.app2.core.conversor.xml.ConversorXML;
import edu.ifpb.pod.app2.core.entidades.NoticiaPersistivel;
import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;
import edu.ifpb.pod.app2a.listeners.NovaNoticiaListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author DouglasGabriel
 */
public class ServidorPublicacao {

    private final int PORT = Configuracoes.PORTA_APP2A_PUBLICADOR_NOTICIA;
    private Queue<NovaNoticiaListener> novaNoticiaListeners = new LinkedList<>();

    
    public void addNovaNoticiaListener(NovaNoticiaListener listener){
        novaNoticiaListeners.add(listener);        
    }        

    public void inicialize() throws Exception {
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                new Publicador(listener.accept(), novaNoticiaListeners).start();
            }
        } finally {
            listener.close();
        }
    }

    private class Publicador extends Thread {

        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private NoticiaPersistivel noticia;
        private NoticiaPersistiveDAOlIF daoNoticia;
        private Queue<NovaNoticiaListener> novaNoticiaListeners;

        public Publicador(Socket socket, Queue<NovaNoticiaListener> novaNoticiaListeners) {
            this.novaNoticiaListeners = novaNoticiaListeners;
            this.socket = socket;
            this.daoNoticia = new NoticiaPersistivelDAO("edu.ifpb.pod_app2a");
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("GETNEWS");
                noticia = (NoticiaPersistivel)ConversorXML.xmlParaObjeto(NoticiaPersistivel.class, in.readLine().getBytes());
                out.println("SUCCESS");
            } catch (Exception e) {
                out.println("ERROR");
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
            daoNoticia.salvar(noticia);
            for(NovaNoticiaListener listener: novaNoticiaListeners){
                listener.avisar(noticia);
            }
            //TODO chamar método da API de Ari para mandar notícia para o site
        }
    }
}
