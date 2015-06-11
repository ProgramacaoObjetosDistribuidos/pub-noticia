package edu.ifpb.pod.app2.core.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import edu.ifpb.pod.app2.core.entidades.NoticiaPersistivel;

/**
 *
 * @author DouglasGabriel
 */
@XmlRootElement
public class Noticias {

    List<NoticiaPersistivel> noticia = new ArrayList<>();
    
    public Noticias(){
        
    }
    
    public Noticias (List<NoticiaPersistivel> list){
        this.noticia = list;
    }
    
    public void addNoticia (NoticiaPersistivel noticia){
        this.noticia.add(noticia);
    }
    
    public void removeNoticia (NoticiaPersistivel noticia){
        this.noticia.remove(noticia);
    }

    public List<NoticiaPersistivel> getNoticia() {
        return noticia;
    }

    public void setNoticia(List<NoticiaPersistivel> noticia) {
        this.noticia = noticia;
    }        
}
