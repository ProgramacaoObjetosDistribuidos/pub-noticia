/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.pod.app2b.socket.main;

import edu.ifpb.pod.app2b.socket.ServerSocketNoticia;
import edu.ifpb.pod.app2b.socket.ServerSocketNotificacao;
import edu.ifpb.pod.app2b.socket.ServidorLogin;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author emanuel
 */
public class Main {
    public static void main(String[] args) {
        try {
            ServerSocketNotificacao socketNotificacao=new ServerSocketNotificacao();
            ServerSocketNoticia socketNoticia=new ServerSocketNoticia(socketNotificacao);
            ServidorLogin servidorLogin=new ServidorLogin();
            socketNotificacao.inicialize();
            socketNoticia.inicialize();
            servidorLogin.inicialize();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
    }
}
