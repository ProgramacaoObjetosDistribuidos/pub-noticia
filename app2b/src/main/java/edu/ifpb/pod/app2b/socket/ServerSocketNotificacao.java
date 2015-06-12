/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.pod.app2b.socket;

import edu.ifpb.pod.app2.core.conversor.xml.ConversorXML;
import edu.ifpb.pod.app2.core.entidades.NoticiaPersistivel;
import edu.ifpb.pod.app2.core.entidades.Noticias;
import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;
import edu.ifpb.pod.app2.core.listener.FimConexaoClienteListener;
import edu.ifpb.pod.app2.core.listener.NovaNoticiaListener;
import edu.ifpb.pod.app2.core.persistencia.UsuarioPersistivelDAO;
import edu.ifpb.pod.app2.core.persistencia.UsuarioPersistivelDAOIF;
import edu.ifpb.pod.app2b.socket.main.RepositorioUsuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emanuel
 * @author DouglasGabriel
 */
public class ServerSocketNotificacao implements NovaNoticiaListener, FimConexaoClienteListener {

    private final int PORT = 1231;
    private List<SendNotification> threads = new LinkedList<>();

    public void inicialize() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress("localhost",PORT));
        while (true) {
            SendNotification sendNotification = new SendNotification(channel.accept(), this);
            threads.add(sendNotification);
            sendNotification.start();
        }
    }

    public void avisar(NoticiaPersistivel noticia) {
        for(SendNotification thread: threads){
            thread.processamento();
        }
    }
    
    public void avisar (Thread thread){
        threads.remove(thread);
    }

    private class SendNotification extends Thread {

        private Socket socket;
        private SocketChannel channel;
        private BufferedReader in;
        private PrintWriter out;
        private String id;
        private FimConexaoClienteListener listener;

        public SendNotification(SocketChannel socketChannel, FimConexaoClienteListener listener) {
            this.socket = socketChannel.socket();
            this.channel = socketChannel;
            this.listener = listener;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
//                UsuarioPersistivelDAOIF usuarioDAOIF = new UsuarioPersistivelDAO();                
                String mensagem = in.readLine();
                if (mensagem.toUpperCase().startsWith("HASNOTIFICATION")) {
                    id = mensagem.substring(17);
                    while (channel.isConnected()) {
                        processamento();
                    }
                }
            } catch (Exception e) {
                out.println("ERRO");
            }finally{
                try {
                    channel.close();
                    listener.avisar(this);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }

        public void processamento(){
            try{
            UsuarioPersistivel usuario = RepositorioUsuario.getInstance().getUsuario(id);
            if (usuario != null) {
                if (usuario.getNovasNoticias() != null && !usuario.getNovasNoticias().isEmpty()) {
                    Noticias noticias = new Noticias(usuario.getNovasNoticias());
                    byte[] noticiaXml = ConversorXML.objetoParaXml(Noticias.class, noticias);
                    out.println(new String(noticiaXml));
                } else {
                    out.println("NOTNOTIFICATION");
                }
            } else {
                out.println("ERRO");
            }
            }catch(Exception e){
                out.println("ERRO");
            }
        }

    }
}
