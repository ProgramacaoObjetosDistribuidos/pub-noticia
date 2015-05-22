
package edu.ifpb.pod.xml.object.converter.converter;

import edu.ifpb.pod.xml.object.converter.entidades.Person;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class PersonPrint {
   
    public void print(Person person){
        try {
            JAXBContext ctx=JAXBContext.newInstance(Person.class);
            Marshaller marshaller=ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
            marshaller.marshal(person, outputStream);
            outputStream.writeTo(System.out);
            outputStream.close();
        } catch (JAXBException | IOException ex) {
            Logger.getLogger(PersonPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
}
