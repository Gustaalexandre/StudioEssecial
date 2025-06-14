package com.cefet.StudioEssencial.dto;

import com.cefet.StudioEssencial.entities.Tipo;
import com.cefet.StudioEssencial.entities.Usuario;

public class UsuarioDTO {
    private Long id;
    private String login;
    private Tipo tipo;

    public UsuarioDTO(){

    }

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.login = usuario.getLogin();
        this.tipo = usuario.getTipo();
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public Tipo getTipo() {
        return tipo;
    }   

    

}
