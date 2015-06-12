/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.pod.app2b.socket.main;

import edu.ifpb.pod.app2.core.entidades.UsuarioPersistivel;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author emanuel
 */
public class RepositorioUsuario {
    private Map<String,UsuarioPersistivel> usuarios=new HashMap<>();
    private static RepositorioUsuario repositorio=new RepositorioUsuario();
    
    public static RepositorioUsuario getInstance(){
        return repositorio;
    }
    
    private RepositorioUsuario(){
        
    }

    public Map<String, UsuarioPersistivel> getUsuario() {
        return usuarios;
    }

    public void setUsuario(Map<String, UsuarioPersistivel> usuario) {
        this.usuarios = usuario;
    }
    
    public void addUsuario(String chave,UsuarioPersistivel usuarioPersistivel){
        usuarios.put(chave, usuarioPersistivel);
    }
    
    public void removeUsuario(String chave){
        usuarios.remove(chave);
    }
    
    
}
