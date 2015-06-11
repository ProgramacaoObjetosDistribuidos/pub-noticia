/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.pod.app2b.socket.main;

import edu.ifpb.pod.app2.core.conversor.xml.ConversorXML;
import edu.ifpb.pod.app2.core.entidades.NoticiaPersistivel;
import edu.ifpb.pod.app2.core.entidades.Noticias;
import edu.ifpb.pod.app2b.socket.ServerSocketNoticia;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author emanuel
 */
public class Main {
    public static void main(String[] args) {
        try {
            //        ServerSocketNoticia serverNoticia=new ServerSocketNoticia();
//        serverNoticia.inicialize();
            NoticiaPersistivel noticia=new NoticiaPersistivel();
            noticia.setConteudo("dagckasdas");
            noticia.setAutores("asad");
            noticia.setId(12);
            noticia.setImagem(null);
            noticia.setNotificada(true);
            noticia.setPublicada(true);
            noticia.setResumo("sdas");
            NoticiaPersistivel noticia1=new NoticiaPersistivel();
            noticia1.setConteudo("dagckasdas");
            noticia1.setAutores("asad");
            noticia1.setId(12);
            noticia1.setImagem(null);
            noticia1.setNotificada(true);
            noticia1.setPublicada(true);
            noticia1.setResumo("sdas");
            Noticias noticias=new Noticias();
            noticias.addNoticia(noticia);
            noticias.addNoticia(noticia1);
            byte[] b=ConversorXML.objetoParaXml(Noticias.class, noticias);
            System.out.println(new String(b));
        } catch (JAXBException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
