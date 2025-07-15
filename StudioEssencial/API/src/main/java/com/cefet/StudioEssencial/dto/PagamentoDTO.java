package com.cefet.StudioEssencial.dto;

import java.time.LocalDate;

import com.cefet.StudioEssencial.entities.Pagamento;

public class PagamentoDTO {
    private Long id;
    private LocalDate dataPagamento;
    private LocalDate dataVencimento;
    private double valor;
    private String formaPagamento;
    private int numeroParcela;
    private Long agendamentoId;

    public PagamentoDTO() {
    }

    public PagamentoDTO(Pagamento pagamento) {
        this.id = pagamento.getId();
        this.dataPagamento = pagamento.getDataPagamento();
        this.dataVencimento = pagamento.getDataVencimento();
        this.valor = pagamento.getValor();
        this.formaPagamento = pagamento.getFormaPagamento();
        this.numeroParcela = pagamento.getNumeroParcela();
        this.agendamentoId = pagamento.getAgendamento().getId();
    }

    public long getId() {
        return id;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    public long getAgendamentoId() {
        return agendamentoId;
    }
}