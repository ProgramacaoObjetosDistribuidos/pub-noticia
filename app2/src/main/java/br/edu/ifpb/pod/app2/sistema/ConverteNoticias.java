package br.edu.ifpb.pod.app2.sistema;

import edu.ifpb.pod.app2.core.entidades.NoticiaPersistivel;

/**
 *
 * @author DouglasGabriel
 */
public class ConverteNoticias {
 
    public static NoticiaPersistivel converterNoticiaEmNoticiaPersistivel (NoticiaPersistivel noticia){
        NoticiaPersistivel noticiaPersistivel = new NoticiaPersistivel();
        noticiaPersistivel.setAutores(noticia.getAutores());
        noticiaPersistivel.setConteudo(noticia.getConteudo());
        noticiaPersistivel.setImagem(noticia.getImagem());
        noticiaPersistivel.setResumo(noticia.getResumo());
        return noticiaPersistivel;
    }
}
