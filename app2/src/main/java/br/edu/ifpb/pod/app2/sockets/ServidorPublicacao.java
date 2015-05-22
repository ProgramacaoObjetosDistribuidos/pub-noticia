package br.edu.ifpb.pod.app2.sockets;

import br.edu.ifpb.pod.pubnoticia.entidades.Noticia;
import br.edu.ifpb.pod.pubnoticia.entidades.UsuarioPublicador;
import br.edu.ifpb.pod.pubnoticia.conversor.ConversorXML;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
        private UsuarioPublicador usuario;

        public Publicador(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = socket.getInputStream();
                out = new PrintWriter(socket.getOutputStream(), true);
                while (true) {
                    try {
                        out.println("SUBNOTICIA");
                        ByteArrayOutputStream temp = new ByteArrayOutputStream();
                        byte[] b = new byte[1];
                        while ((in.read(b)) != -1) {
                            temp.write(b);
                        }
                        noticia = (Noticia) ConversorXML.xmlParaObjeto(Noticia.class, temp.toByteArray());
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        out.println("ERRO");
                    }
                }
                out.println("SUCESSO");                

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}