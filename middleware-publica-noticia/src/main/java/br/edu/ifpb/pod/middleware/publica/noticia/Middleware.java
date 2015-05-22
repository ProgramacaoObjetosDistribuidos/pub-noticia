package br.edu.ifpb.pod.middleware.publica.noticia;

import br.edu.ifpb.pod.pubnoticia.entidades.Noticia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import javax.xml.bind.JAXBException;

/**
 *
 * @author DouglasGabriel
 */
public class Middleware {

    public static String publicar (Noticia noticia){
        
    }
    /**
     * 
     * @param noticiaXml
     * @return em caso de sucesso, retorna a diretiva "SUCESSO", caso o servidor n consiga  
     * @throws IOException
     * @throws JAXBException 
     */
    public static String publicar(String noticiaXml) throws IOException, JAXBException{
        Socket socket=new Socket("localhost", 12345);
        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String diretiva=in.readLine();
        if(diretiva.equals("SUBNOTICIA")){
            OutputStream out = socket.getOutputStream();
            out.write(noticiaXml.getBytes());
            return in.readLine();
        }
        return null;
    }
}
