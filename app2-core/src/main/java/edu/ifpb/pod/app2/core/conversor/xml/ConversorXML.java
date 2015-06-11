package edu.ifpb.pod.app2.core.conversor.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author DouglasGabriel
 */
public class ConversorXML {
    
    public static byte[] objetoParaXml (Class clazz, Object obj) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller marshaller = context.createMarshaller();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        marshaller.marshal(obj, output);
        return output.toByteArray();
    }
    
    public static Object xmlParaObjeto (Class clazz, byte[] b) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object obj = unmarshaller.unmarshal(new ByteArrayInputStream(b));
        return obj;
    }
        
}
