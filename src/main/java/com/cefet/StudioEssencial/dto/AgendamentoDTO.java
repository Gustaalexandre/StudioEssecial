package com.cefet.StudioEssencial.dto;

import java.time.LocalDate;

import com.cefet.StudioEssencial.entities.Agendamento;

public class AgendamentoDTO {
    private Long id;
    private Long clienteId;
    private Long funcionarioId;
    private Long procedimentoId;
    private LocalDate data;
    private String situacao;
    private int numeroParcelas;
    private double valorTotal;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.funcionarioId = agendamento.getFuncionario().getId();
        this.procedimentoId = agendamento.getProcedimento().getId();
        this.clienteId = agendamento.getCliente().getId();
        this.data = agendamento.getData();
        this.situacao = agendamento.getSituacao();
        this.numeroParcelas = agendamento.getNumeroParcelas();
        this.valorTotal = agendamento.getValorTotal();
    }

    public Long getId() {
        return id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public Long getProcedimentoId() {
        return procedimentoId;
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