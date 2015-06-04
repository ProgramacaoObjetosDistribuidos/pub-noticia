
package edu.ifpb.pod.xml.object.converter.converter;

import edu.ifpb.pod.xml.object.converter.entidades.Person;
import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class PersonToXml {

    public static byte[] convert(Person person){
        try {
            JAXBContext ctx=JAXBContext.newInstance(Person.class);
            Marshaller masMarshaller=ctx.createMarshaller();
            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
            masMarshaller.marshal(person, outputStream);
            return outputStream.toByteArray();
        } catch (JAXBException ex) {
            Logger.getLogger(PersonToXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
