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

    List<NoticiaPersistivel> list = new ArrayList<>();
    
    public Noticias(){
        
    }
    
    public Noticias (List<NoticiaPersistivel> list){
        this.list = list;
    }
    
    public void addNoticia (NoticiaPersistivel noticia){
        list.add(noticia);
    }
    
    public void removeNoticia (NoticiaPersistivel noticia){
        list.remove(noticia);
    }

    public List<NoticiaPersistivel> getList() {
        return list;
    }

    public void setList(List<NoticiaPersistivel> list) {
        this.list = list;
    }        
}
