/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.pod.app2b.socket.main;

import edu.ifpb.pod.app2b.socket.ServerSocketNoticia;
import edu.ifpb.pod.app2b.socket.ServerSocketNotificacao;
import java.io.IOException;

/**
 *
 * @author emanuel
 */
public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocketNotificacao serverSocketNotificacao = new ServerSocketNotificacao();
        new ServerSocketNoticia(serverSocketNotificacao).inicialize();
        serverSocketNotificacao.inicialize();
    }
}
