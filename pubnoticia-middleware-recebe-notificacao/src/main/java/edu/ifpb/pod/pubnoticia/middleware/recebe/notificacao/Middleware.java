/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.pod.pubnoticia.middleware.recebe.notificacao;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public interface Middleware {
    
    public String login(String token);
    
    public boolean hasNoticication(String idSession);
    

}
    
    