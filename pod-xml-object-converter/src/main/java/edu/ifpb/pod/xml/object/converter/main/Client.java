
package edu.ifpb.pod.xml.object.converter.main;

import edu.ifpb.pod.xml.object.converter.converter.PersonToXml;
import edu.ifpb.pod.xml.object.converter.entidades.Person;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("localhost",10999);
            
            Person person=new Person();
            person.setEmail("emanuelbatista2011@gmail.com");
            
            byte[] b=PersonToXml.convert(person);
            
            OutputStream outputStream=socket.getOutputStream();
            outputStream.write(b);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
