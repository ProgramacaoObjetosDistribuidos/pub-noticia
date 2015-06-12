/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.pod.app2b.socket;

import edu.ifpb.pod.app2.core.configuracao.Configuracoes;
import edu.ifpb.pod.app2.core.conversor.xml.ConversorXML;
import edu.ifpb.pod.app2.core.entidades.Noticia;
import edu.ifpb.pod.app2.core.listener.NoticiaPersistivelListener;
import edu.ifpb.pod.app2.core.listener.NovaNoticiaListener;
import edu.ifpb.pod.app2.core.persistencia.NoticiaPersistiveDAOlIF;
import edu.ifpb.pod.app2.core.persistencia.NoticiaPersistivelDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author emanuel
 */
public class ServerSocketNoticia {

    private final int PORT = Configuracoes.PORTA_APP2B_NOTIFICACAO_NOVA_NOTICIA;
    private NovaNoticiaListener listener;
    
    public ServerSocketNoticia (NovaNoticiaListener listener){
        this.listener = listener;
    }
    
    public void inicialize(){
        try{
            ServerSocket server = new ServerSocket(PORT);
            try{
                while(true){
                    new PublicadorNoticia(server.accept()).start();
                }
            }finally{
                server.close();
            }
            
        }   catch (IOException ex) {
            Logger.getLogger(ServerSocketNoticia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private class PublicadorNoticia extends Thread{

       private Socket socket;
       private BufferedReader in;
       private PrintWriter out;    

        public PublicadorNoticia(Socket socket) {
            this.socket = socket;
        }
            
        @Override
        public void run() {
           Noticia noticiaPersistivel=null;
           try {
               in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
               out=new PrintWriter(socket.getOutputStream());
               out.println("GETNEWS");
               noticiaPersistivel=(Noticia)ConversorXML.xmlParaObjeto(Noticia.class, in.readLine().getBytes());
               out.println("SUCESS");
               
           } catch (IOException | JAXBException ex) {
               out.println("ERRO");
           }finally{
               try {
                   socket.close();
               } catch (IOException ex) {
                   Logger.getLogger(ServerSocketNoticia.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           if(noticiaPersistivel!=null){
               NoticiaPersistiveDAOlIF noticiaDAO=new NoticiaPersistivelDAO("edu.ifpb.pod_app2b");
               NoticiaPersistivelListener noticiaPersistivelListener=new NoticiaPersistivelListener();
               System.out.println(noticiaPersistivel.getConteudo());
               listener.avisar(noticiaPersistivel);
//               noticiaDAO.salvar(noticiaPersistivel);
//               //Falta o Map de usuarios
//               noticiaPersistivelListener.avisar(noticiaPersistivel, null);
               
           }
           
        }
        
    } 
}
