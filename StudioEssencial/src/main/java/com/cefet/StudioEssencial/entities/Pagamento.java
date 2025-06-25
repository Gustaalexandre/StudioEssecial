package com.cefet.StudioEssencial.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tbPagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDate dataPagamento;

    @Column(nullable = false)
    private LocalDate dataVencimento;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private String formaPagamengo;

    @Column(nullable = false)
    private int numeroParcela;

    @ManyToOne
    @JoinColumn(name = "agendamentoId")
    private Agendamento agendamento;

    public Pagamento() {
    }

    public Pagamento(long id, LocalDate dataPagamento, LocalDate dataVencimento, double valor, String formaPagamengo,
            int numeroParcela, Agendamento agendamento) {
        this.id = id;
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.formaPagamengo = formaPagamengo;
        this.numeroParcela = numeroParcela;
        this.agendamento = agendamento;
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

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setFormaPagamengo(String formaPagamengo) {
        this.formaPagamengo = formaPagamengo;
    }

    public void setNumeroParcela(int numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((dataPagamento == null) ? 0 : dataPagamento.hashCode());
        result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
        long temp;
        temp = Double.doubleToLongBits(valor);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((formaPagamengo == null) ? 0 : formaPagamengo.hashCode());
        result = prime * result + numeroParcela;
        result = prime * result + ((agendamento == null) ? 0 : agendamento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pagamento other = (Pagamento) obj;
        if (id != other.id)
            return false;
        if (dataPagamento == null) {
            if (other.dataPagamento != null)
                return false;
        } else if (!dataPagamento.equals(other.dataPagamento))
            return false;
        if (dataVencimento == null) {
            if (other.dataVencimento != null)
                return false;
        } else if (!dataVencimento.equals(other.dataVencimento))
            return false;
        if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
            return false;
        if (formaPagamengo == null) {
            if (other.formaPagamengo != null)
                return false;
        } else if (!formaPagamengo.equals(other.formaPagamengo))
            return false;
        if (numeroParcela != other.numeroParcela)
            return false;
        if (agendamento == null) {
            if (other.agendamento != null)
                return false;
        } else if (!agendamento.equals(other.agendamento))
            return false;
        return true;
    }
}