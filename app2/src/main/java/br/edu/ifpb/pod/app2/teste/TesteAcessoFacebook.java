package br.edu.ifpb.pod.app2.teste;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 *
 * @author DouglasGabriel
 */
public class TesteAcessoFacebook {

    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("https://graph.facebook.com/me?access_token=CAAK7CyXZCAhgBAOje85g5m5yefhlAfss00ZBQUPAWarYZA6kAvenyEZCFnQZAWSY6NgE2xdOtkHYVAum8ZCnH9vQ1UbHqG3Mc1aXlDlUwguwsJ49EvJLfWIXVl3FuV07baWZAsjqMDQltVXbh00dAUvt2jAd96OBtGSs5tyegqNik10LGZBYFZBbo0ZCvurP7shsgGungbRayPPSDZA5uDAqLDW");
        System.out.println(readUrl(url));
    }
    
    private static String readUrl (URL url) throws IOException{
        ByteArrayOutputStream output = new ByteArrayOutputStream();        
        InputStream input = url.openStream();        
        byte[] b = new byte[1];
        while ((input.read(b)) != -1){
            output.write(b);
        }
        return new String(output.toByteArray(), Charset.forName("utf-8"));
    }
}
