package com.cefet.StudioEssencial.dto;

import java.time.LocalDate;

import com.cefet.StudioEssencial.entities.Agendamento;

public class AgendamentoDTO {

    private Long id;
    private LocalDate data;
    private String situacao;
    private long pessoaId;
    private long procedimentoId;
    private int numeroParcelas;
    private double valorTotal;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.data = agendamento.getData();
        this.situacao = agendamento.getSituacao();
        this.pessoaId = agendamento.getPessoa().getId();
        this.procedimentoId = agendamento.getProcedimento().getId();
        this.numeroParcelas = agendamento.getNumeroParcelas();
        this.valorTotal = agendamento.getValorTotal();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public String getSituacao() {
        return situacao;
    }

    public long getPessoaId() {
        return pessoaId;
    }

    public long getProcedimentoId() {
        return procedimentoId;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}