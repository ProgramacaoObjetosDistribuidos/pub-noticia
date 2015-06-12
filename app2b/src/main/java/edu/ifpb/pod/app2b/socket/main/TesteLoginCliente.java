package edu.ifpb.pod.app2b.socket.main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author DouglasGabriel
 */
public class TesteLoginCliente {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("TOKEN:CAAK7CyXZCAhgBALjLWKS1ifV5NX3vTFZCh3byZAUMmdXcIVZC7IlkVvRaZA8PNwGm6LWZBmQO1TZCePMppiQOeUtWAxghkBevZC4oo9R7PCSxZCgr15za6kmo9MumI3eQ2dnQqxYcKXZAv9rSyNtbdKYB1YjkTwQbwmksZAmoFxdlMsQpZA6Y51SPQSMIljjVnEas631BZCy2r9iQm9PtJeabDFYl");        
        System.out.println(respostaCliente(socket));
    }

    private static String respostaCliente(Socket socket) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream in = socket.getInputStream();
        byte[] b = new byte[1];
        while (in.read(b) != -1) {
            outputStream.write(b);
        }
        return new String(outputStream.toByteArray());
    }

}
