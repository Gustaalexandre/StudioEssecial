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
    @JoinColumn(name = "funcionarioId")
    private Pessoa funcionario;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Pessoa cliente;

    @ManyToOne
    @JoinColumn(name = "procedimentoId")
    private Procedimento procedimento;

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

    public Agendamento(long id, Pessoa cliente, Pessoa funcionario, Procedimento procedimento, String nmProduto,
            int quantidade,
            LocalDate data, String situacao, int numeroParcelas, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.procedimento = procedimento;
        this.data = data;
        this.situacao = situacao;
        this.numeroParcelas = numeroParcelas;
        this.valorTotal = valorTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Pessoa getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Pessoa funcionario) {
        this.funcionario = funcionario;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getSituacao() {
        return situacao;
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
        result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((procedimento == null) ? 0 : procedimento.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
        result = prime * result + numeroParcelas;
        long temp;
        temp = Double.doubleToLongBits(valorTotal);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        if (funcionario == null) {
            if (other.funcionario != null)
                return false;
        } else if (!funcionario.equals(other.funcionario))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (procedimento == null) {
            if (other.procedimento != null)
                return false;
        } else if (!procedimento.equals(other.procedimento))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (situacao == null) {
            if (other.situacao != null)
                return false;
        } else if (!situacao.equals(other.situacao))
            return false;
        if (numeroParcelas != other.numeroParcelas)
            return false;
        if (Double.doubleToLongBits(valorTotal) != Double.doubleToLongBits(other.valorTotal))
            return false;
        return true;
    }

}