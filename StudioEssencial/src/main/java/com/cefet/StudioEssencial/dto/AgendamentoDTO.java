package com.cefet.StudioEssencial.dto;

import java.time.LocalDate;

import com.cefet.StudioEssencial.entities.Agendamento;

public class AgendamentoDTO {
    private Long id;
    private Long pessoaId;
    private Long procedimentoId;
    private String nmProduto;
    private int quantidade;
    private LocalDate data;
    private String situacao;
    private int numeroParcelas;
    private double valorTotal;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.pessoaId = agendamento.getPessoa().getId();
        this.procedimentoId = agendamento.getProcedimento().getId();
        this.nmProduto = agendamento.getNmProduto();
        this.quantidade = agendamento.getQuantidade();
        this.data = agendamento.getData();
        this.situacao = agendamento.getSituacao();
        this.numeroParcelas = agendamento.getNumeroParcelas();
        this.valorTotal = agendamento.getValorTotal();
    }

    public Long getId() {
        return id;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public Long getProcedimentoId() {
        return procedimentoId;
    }

    public String getNmProduto() {
        return nmProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public String getSituacao() {
        return situacao;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}