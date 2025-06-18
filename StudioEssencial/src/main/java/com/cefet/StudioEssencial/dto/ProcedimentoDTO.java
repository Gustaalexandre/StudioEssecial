package com.cefet.StudioEssencial.dto;

import com.cefet.StudioEssencial.entities.Procedimento;

public class ProcedimentoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private String duracao;

    public ProcedimentoDTO() {
    }

    public ProcedimentoDTO(Procedimento procedimento) {
        this.id = procedimento.getId();
        this.nome = procedimento.getNome();
        this.descricao = procedimento.getDescricao();
        this.preco = procedimento.getPreco();
        this.duracao = procedimento.getDuracao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public String getDuracao() {
        return duracao;
    }
}