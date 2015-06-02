package br.edu.ifpb.pod.app2.sistema;

import br.edu.ifpb.pod.app2.entidades.NoticiaPersistivel;
import edu.ifpb.pod.pubnoticia.core.entidades.Noticia;

/**
 *
 * @author DouglasGabriel
 */
public class ConverteNoticias {
 
    public static NoticiaPersistivel converterNoticiaEmNoticiaPersistivel (Noticia noticia){
        NoticiaPersistivel noticiaPersistivel = new NoticiaPersistivel();
        noticiaPersistivel.setAutores(noticia.getAutores());
        noticiaPersistivel.setConteudo(noticia.getConteudo());
        noticiaPersistivel.setImagem(noticia.getImagem());
        noticiaPersistivel.setResumo(noticia.getResumo());
        return noticiaPersistivel;
    }
}
