package edu.ifpb.pod.app2b.socket.main;

import java.io.IOException;
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
        out.println("douglas.gabriel.18");
    }
    
}
