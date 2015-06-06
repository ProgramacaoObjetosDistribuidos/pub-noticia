package br.edu.ifpb.pod.app2.teste;

import br.edu.ifpb.pod.app2.dao.interfaces.DAO;
import br.edu.ifpb.pod.app2.dao.NoticiaPersistivelDAO;
import br.edu.ifpb.pod.app2.dao.UsuarioPersistivelDAO;
import br.edu.ifpb.pod.app2.dao.interfaces.NoticiaPersistiveDAOlIF;
import br.edu.ifpb.pod.app2.dao.interfaces.UsuarioPersistivelDAOIF;
import br.edu.ifpb.pod.app2.entidades.NoticiaPersistivel;
import br.edu.ifpb.pod.app2.entidades.UsuarioPersistivel;
import java.util.List;
import br.edu.ifpb.pod.app2.persistencia.listener.NoticiaPersistivelListener;
import br.edu.ifpb.pod.app2.persistencia.listener.PersisteNoticiaListener;
import br.edu.ifpb.pod.pubnoticia.conversor.ConversorXML;
import edu.ifpb.pod.pubnoticia.core.entidades.Noticia;
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

        Noticia noticia = new Noticia();
        noticia.setConteudo("sdasdas");
        noticia.setAutor("Joao");
        byte[] a=Files.readAllBytes(Paths.get("/home/emanuel/Imagens/logo.png"));
        noticia.setImagem(a);
        
        try {
            String text=new String(ConversorXML.objetoParaXml(Noticia.class, noticia));
            System.out.println(text);
//            text=Base64.getEncoder().encodeToString(text.getBytes());
//            System.out.println(text);
        } catch (JAXBException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
