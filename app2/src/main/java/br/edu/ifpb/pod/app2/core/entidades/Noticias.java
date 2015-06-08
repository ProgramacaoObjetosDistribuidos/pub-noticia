package br.edu.ifpb.pod.app2.core.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DouglasGabriel
 */
public class Noticias {

    List<Noticia> list = new ArrayList<>();
    
    public void addNoticia (Noticia noticia){
        list.add(noticia);
    }
    
    public void removeNoticia (Noticia noticia){
        list.remove(noticia);
    }

    public List<Noticia> getList() {
        return list;
    }

    public void setList(List<Noticia> list) {
        this.list = list;
    }        
}
