package com.cefet.StudioEssencial.dto;

import com.cefet.StudioEssencial.entities.NivelAcesso;
import com.cefet.StudioEssencial.entities.Usuario;

public class UsuarioCreateDTO {
    private Long id;
    private String login;
    private String senha;
    private NivelAcesso nivelAcesso;
    private Long pessoaId;

    public UsuarioCreateDTO(){

    }

    public UsuarioCreateDTO(Usuario usuario){
        this.id = usuario.getId();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.nivelAcesso = usuario.getNivelAcesso();
        this.pessoaId = usuario.getPessoa().getId();
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public String getSenha() {
        return senha;
    }

    
}