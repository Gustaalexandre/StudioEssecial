package com.cefet.StudioEssencial.dto;

import com.cefet.StudioEssencial.entities.NivelAcesso;
import com.cefet.StudioEssencial.entities.Usuario;

public class UsuarioDTO {
    private Long id;
    private String login;
    private NivelAcesso nivelAcesso;
    private Long pessoaId;

    public UsuarioDTO(){
    }

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.login = usuario.getLogin();
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
}