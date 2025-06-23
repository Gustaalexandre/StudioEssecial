package com.cefet.StudioEssencial.dto;

import com.cefet.StudioEssencial.entities.Telefone;

public class TelefoneDTO {
    private Long id;
    private Long pessoaId;
    private String telefone;

    public TelefoneDTO() {
    }

    public TelefoneDTO(Telefone telefone) {
        this.id = telefone.getId();
        this.pessoaId = telefone.getPessoa().getId();
        this.telefone = telefone.getTelefone();
    }

    public Long getId() {
        return id;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public String getTelefone() {
        return telefone;
    }
}