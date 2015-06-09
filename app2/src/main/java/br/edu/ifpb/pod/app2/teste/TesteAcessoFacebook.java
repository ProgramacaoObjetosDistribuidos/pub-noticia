package br.edu.ifpb.pod.app2.teste;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author DouglasGabriel
 */
public class TesteAcessoFacebook {

    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("https://graph.facebook.com/me?access_token=CAAK7CyXZCAhgBAJhoiHKdoqTNGULH4mZAhefAgzxswkjPvWTMXZCnvHkzW0OZAbsvZAW7xHmbhbguKjeaqpZAzZB5In0UkDw1tmP720lAFk81tgng0ygZAfcDZBFxkEjuxl1OwlHs9b2tcqCnjZBLTmDK6ZAgZCZCI0oECyqSvpmaIyEB2ae6NAlJlSH0KVIRwYkbvzf6laDw5XlTS8gPtNePHQXT");
        System.out.println(readUrl(url));
    }
    
    private static String readUrl (URL url) throws IOException{
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        InputStream input = url.openStream();
        byte[] b = new byte[1];
        while ((input.read(b)) != -1){
            output.write(b);
        }
        return new String (output.toByteArray());
    }
}
