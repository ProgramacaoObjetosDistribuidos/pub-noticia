package br.edu.ifpb.pod.middleware.publica.noticia;

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
    
    /**
     * 
     * @param noticiaXml
<<<<<<< HEAD
<<<<<<< HEAD
     * @return em caso de sucesso, retorna a diretiva "SUCESSO", caso o servidor consiga  
=======
     * @return em caso de sucesso retorna a diretiva "SUCESSO", caso o servidor não reconheça
     * o formato do XML, retornará a diretiva "ERRO" e caso haja problema na conexão, retornará
     * null.
>>>>>>> f288d3066b8ef395ecf5abe2f97288aea11d58a6
=======
     * @return em caso de sucesso retorna a diretiva "SUCESSO", caso o servidor não reconheça
     * o formato do XML, retornará a diretiva "ERRO" e caso haja problema na conexão, retornará
     * null.
>>>>>>> f288d3066b8ef395ecf5abe2f97288aea11d58a6
     * @throws IOException
     */
    public static String publicar(String noticiaXml) throws IOException{
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
