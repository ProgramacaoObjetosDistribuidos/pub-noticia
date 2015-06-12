package edu.ifpb.pod.app2a.sockets;

import edu.ifpb.pod.app2.core.configuracao.Configuracoes;
import edu.ifpb.pod.app2.core.conversor.xml.ConversorXML;
import edu.ifpb.pod.app2.core.entidades.Noticia;
import edu.ifpb.pod.app2.core.persistencia.NoticiaPersistiveDAOlIF;
import edu.ifpb.pod.app2.core.persistencia.NoticiaPersistivelDAO;
import edu.ifpb.pod.app2a.listeners.NovaNoticiaListener;
import java.io.ByteArrayOutputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author DouglasGabriel
 */
public class NotificadorNovaNoticia implements NovaNoticiaListener {

    private List<Noticia> noticiasANotificar;
    private NoticiaPersistiveDAOlIF daoNoticia = new NoticiaPersistivelDAO("edu.ifpb.pod_app2a");

    public NotificadorNovaNoticia() {
        noticiasANotificar = daoNoticia.getNoticiasNaoNotificadas();
        for (Noticia noticia : noticiasANotificar) {
            avisar(noticia);
            noticia.setNotificada(true);
            daoNoticia.atualizar(noticia);
            noticiasANotificar.remove(noticia);
        }
    }

    @Override
    public void avisar(Noticia noticia) {
        try {
            byte[] noticiaXML = ConversorXML.objetoParaXml(Noticia.class, noticia);
            Socket socket = new Socket(Configuracoes.IP_APP2B, Configuracoes.PORTA_APP2B_NOTIFICACAO_NOVA_NOTICIA);
            socket.getOutputStream().write(noticiaXML);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            output.writeTo(System.out);
            output.close();
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
