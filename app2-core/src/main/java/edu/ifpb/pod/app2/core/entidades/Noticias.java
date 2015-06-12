package edu.ifpb.pod.app2.core.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import edu.ifpb.pod.app2.core.entidades.Noticia;

/**
 *
 * @author DouglasGabriel
 */
@XmlRootElement
public class Noticias {

    List<Noticia> noticia = new ArrayList<>();
    
    public Noticias(){
        
    }
    
    public Noticias (List<Noticia> list){
        this.noticia = list;
    }
    
    public void addNoticia (Noticia noticia){
        this.noticia.add(noticia);
    }
    
    public void removeNoticia (Noticia noticia){
        this.noticia.remove(noticia);
    }

    public List<Noticia> getNoticia() {
        return noticia;
    }

    public void setNoticia(List<Noticia> noticia) {
        this.noticia = noticia;
    }        
}
