package com.cefet.StudioEssencial.dto;

import java.time.LocalDate;

import com.cefet.StudioEssencial.entities.Agendamento;
import com.cefet.StudioEssencial.entities.Pagamento;

public class PagamentoDTO {

    private long id;
    private LocalDate dataPagamento;
    private LocalDate dataVencimento;
    private double valor;
    private String formaPagamengo;
    private int numeroParcela;
    private long agendamentoId;

    public PagamentoDTO() {
    }

    public PagamentoDTO(Pagamento pagamento) {
        this.id = pagamento.getId();
        this.dataPagamento = pagamento.getDataPagamento();
        this.dataVencimento = pagamento.getDataVencimento();
        this.valor = pagamento.getValor();
        this.formaPagamengo = pagamento.getFormaPagamengo();
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

    public String getFormaPagamengo() {
        return formaPagamengo;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    public long getAgendamentoId() {
        return agendamentoId;
    }

}
