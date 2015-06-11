/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.pod.app2a.sockets.main;

import edu.ifpb.pod.app2a.sockets.NotificadorNovaNoticia;
import edu.ifpb.pod.app2a.sockets.ServidorPublicacao;

/**
 *
 * @author emanuel
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ServidorPublicacao servidorPublicacao=new ServidorPublicacao();
        servidorPublicacao.addNovaNoticiaListener(new NotificadorNovaNoticia());
        servidorPublicacao.inicialize();
    }
}
