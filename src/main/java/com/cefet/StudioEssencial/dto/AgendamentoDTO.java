package com.cefet.StudioEssencial.dto;

import java.time.LocalDate;

import com.cefet.StudioEssencial.entities.Agendamento;
import com.cefet.StudioEssencial.entities.Pessoa;

public class AgendamentoDTO {
    private Long id;
    private Pessoa cliente;
    private Pessoa funcionario;
    private Long procedimentoId;
    private LocalDate data;
    private String situacao;
    private int numeroParcelas;
    private double valorTotal;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.funcionario = agendamento.getFuncionario();
        this.procedimentoId = agendamento.getProcedimento().getId();
        this.cliente = agendamento.getCliente();
        this.data = agendamento.getData();
        this.situacao = agendamento.getSituacao();
        this.numeroParcelas = agendamento.getNumeroParcelas();
        this.valorTotal = agendamento.getValorTotal();
    }

    public Long getId() {
        return id;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public Pessoa getFuncionario() {
        return funcionario;
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