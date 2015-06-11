/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.pod.app2b.socket;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emanuel
 */
public class ServerSocketNotificacao {

    private final int PORT = 100;

    public void inicialize() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(PORT));
        while (true) {
            new SendNotification(channel.accept()).start();
        }
    }

    private class SendNotification extends Thread {

        private Socket socket;
        private SocketChannel channel;
        private BufferedReader in;
        private PrintWriter out;

        public SendNotification(SocketChannel socketChannel) {
            this.socket = socketChannel.socket();
            this.channel = socketChannel;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream());
                UsuarioPersistivelDAOIF usuarioDAOIF = new UsuarioPersistivelDAO();
                RepositorioUsuario repositorioUsuario = RepositorioUsuario.getInstance();
                String mensagem=in.readLine();
                if(mensagem.toUpperCase().startsWith("HASNOTIFICATION")){
                    String id=mensagem.substring(17);
                    
                }
                        
            } catch (IOException ex) {
                Logger.getLogger(ServerSocketNotificacao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
