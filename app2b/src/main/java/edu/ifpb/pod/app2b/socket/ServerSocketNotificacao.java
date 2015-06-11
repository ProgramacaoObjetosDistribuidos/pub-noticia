/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.pod.app2b.socket;

import edu.ifpb.pod.app2.core.configuracao.Configuracoes;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 *
 * @author emanuel
 */
public class ServerSocketNotificacao {
    private final int PORT = 100;
    
    public void inicialize() throws IOException{
        ServerSocketChannel channel=ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(PORT));
        while(true){
            
        }
    }
    
    private class SendNotification extends Thread{
        private SocketChannel socketChannel;

        public SendNotification(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }
        
        

        @Override
        public void run() {
            
        }
        
    }
}
