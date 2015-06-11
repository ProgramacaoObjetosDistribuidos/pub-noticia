package br.edu.ifpb.pod.app2.teste;

import edu.ifpb.pod.app2.core.persistencia.DAO;
import edu.ifpb.pod.app2.core.persistencia.NoticiaPersistivelDAO;
import edu.ifpb.pod.app2.core.persistencia.UsuarioPersistivelDAO;
import edu.ifpb.pod.app2.core.persistencia.NoticiaPersistiveDAOlIF;
import edu.ifpb.pod.app2.core.persistencia.UsuarioPersistivelDAOIF;
import edu.ifpb.pod.app2.core.entidades.NoticiaPersistivel;
import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;
import java.util.List;
import br.edu.ifpb.pod.app2.persistencia.listener.NoticiaPersistivelListener;
import br.edu.ifpb.pod.app2.persistencia.listener.PersisteNoticiaListener;
import edu.ifpb.pod.app2.core.conversor.xml.ConversorXML;
import br.edu.ifpb.pod.app2.core.entidades.NoticiaPersistivel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DouglasGabriel
 */
public class Teste {

    public static void main(String[] args) throws IOException {
//        PersisteNoticiaListener listener = new NoticiaPersistivelListener();
//        UsuarioPersistivelDAOIF dao=new UsuarioPersistivelDAO();
//        NoticiaPersistiveDAOlIF dao1=new NoticiaPersistivelDAO();
//        UsuarioPersistivel usuario = new UsuarioPersistivel();
//        usuario.setNome("Douglas");
//        usuario.setEmail("douglas@mail.com");
//        dao.salvar(usuario);
//        NoticiaPersistivel noticiaPersistivel=new NoticiaPersistivel();
//        noticiaPersistivel.setConteudo("LOrem llslsls");
//        noticiaPersistivel.setResumo("Oiiiiiiiii");
//        dao1.salvar(noticiaPersistivel);
//        Teste2 teste2=new Teste2();
//        teste2.teste();

        NoticiaPersistivel noticia = new NoticiaPersistivel();
        noticia.setConteudo("sdasdas");
        noticia.setAutor("Joao");
        byte[] a=Files.readAllBytes(Paths.get("/home/emanuel/Imagens/logo.png"));
        noticia.setImagem(a);
        
        try {
            String text=new String(ConversorXML.objetoParaXml(NoticiaPersistivel.class, noticia));
            System.out.println(text);
//            text=Base64.getEncoder().encodeToString(text.getBytes());
//            System.out.println(text);
        } catch (JAXBException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
