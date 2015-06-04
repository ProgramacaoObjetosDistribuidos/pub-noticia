
package edu.ifpb.pod.xml.object.converter.converter;

import edu.ifpb.pod.xml.object.converter.entidades.Person;
import java.io.ByteArrayInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class XmlToPerson {

    public static Person convert(byte[] b){
        try {
            JAXBContext context=JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller=context.createUnmarshaller();
            Person person=(Person) unmarshaller.unmarshal(new ByteArrayInputStream(b));
            return person;
        } catch (JAXBException ex) {
            Logger.getLogger(XmlToPerson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
