package br.edu.ifpb.pod.app2.sockets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class ServidorLogin {

    private static final int PORT = 123456;

    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
               new Comunicador(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }
    
    private static class Comunicador extends Thread{

        private Socket socket;
        private PrintWriter out;
        private InputStream in;
        private String mensagem;
        
        public Comunicador(Socket socket){
            this.socket=socket;
        }
        
        @Override
        public void run() {
            try {
                out=new PrintWriter(socket.getOutputStream(), true);
                out.println("ACCEPTED");
                in=socket.getInputStream();
                mensagem=gerarString();
                //Logica do token
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(ServidorLogin.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    socket.close();
                } catch (IOException ex) {
                }
            }
        }

        private String gerarString() throws IOException {
            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
            byte[] b=new byte[1];
            while(in.read(b)!=-1){
                outputStream.write(b);
            }
            return new String(outputStream.toByteArray());
        }
        
    }
}
