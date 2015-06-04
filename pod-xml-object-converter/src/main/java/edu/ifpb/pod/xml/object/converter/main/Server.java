
package edu.ifpb.pod.xml.object.converter.main;

import edu.ifpb.pod.xml.object.converter.converter.PersonPrint;
import edu.ifpb.pod.xml.object.converter.converter.XmlToPerson;
import edu.ifpb.pod.xml.object.converter.entidades.Person;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(10999);
            Socket socket=serverSocket.accept();
            InputStream inputStream=socket.getInputStream();
            ByteArrayOutputStream temp=new ByteArrayOutputStream();
            
            byte[] b=new byte[1];
            
            while(inputStream.read(b)!=-1){
                temp.write(b);
            }
            
            
            Person user=XmlToPerson.convert(temp.toByteArray());
            
            System.out.println("Formato xml");
            new PersonPrint().print(user);
            
            System.out.println();
            
            System.out.println("Formato dados");
            System.out.println("Email do usuario: "+user.getEmail());
            
            serverSocket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
