package com.cefet.StudioEssencial.dto;

import com.cefet.StudioEssencial.entities.Pessoa;

public class PessoaDTO {
    private Long id;
    private String nome;
    private char sexo;
    private String endereco;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.sexo = pessoa.getSexo();
        this.endereco = pessoa.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public String getEndereco() {
        return endereco;
    }
}