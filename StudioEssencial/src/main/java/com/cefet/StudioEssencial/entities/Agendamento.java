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
@Table(name = "tbAgendamento")

public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "pessoaId")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "procedimentoId")
    private Procedimento procedimento;

    @Column(nullable = false)
    private String nmProduto;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private String situacao;

    @Column(nullable = false)
    private int numeroParcelas;

    @Column(nullable = false)
    private double valorTotal;

    public Agendamento() {
    }

    public Agendamento(long id, Pessoa pessoa, Procedimento procedimento, String nmProduto, int quantidade,
            String situacao) {
        this.id = id;
        this.pessoa = pessoa;
        this.procedimento = procedimento;
        this.nmProduto = nmProduto;
        this.quantidade = quantidade;
        this.situacao = situacao;
    }

    public long getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Procedimento getProcedimento() {
        return procedimento;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public void setNmProduto(String nmProduto) {
        this.nmProduto = nmProduto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
        result = prime * result + ((procedimento == null) ? 0 : procedimento.hashCode());
        result = prime * result + ((nmProduto == null) ? 0 : nmProduto.hashCode());
        result = prime * result + quantidade;
        result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
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
        Agendamento other = (Agendamento) obj;
        if (id != other.id)
            return false;
        if (pessoa == null) {
            if (other.pessoa != null)
                return false;
        } else if (!pessoa.equals(other.pessoa))
            return false;
        if (procedimento == null) {
            if (other.procedimento != null)
                return false;
        } else if (!procedimento.equals(other.procedimento))
            return false;
        if (nmProduto == null) {
            if (other.nmProduto != null)
                return false;
        } else if (!nmProduto.equals(other.nmProduto))
            return false;
        if (quantidade != other.quantidade)
            return false;
        if (situacao == null) {
            if (other.situacao != null)
                return false;
        } else if (!situacao.equals(other.situacao))
            return false;
        return true;
    }
}