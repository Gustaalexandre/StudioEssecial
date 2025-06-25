package com.cefet.StudioEssencial.dto;

import java.time.LocalDate;

import com.cefet.StudioEssencial.entities.Agendamento;

public class AgendamentoDTO {

    private Long id;
    private LocalDate data;
    private String situacao;
    private long pessoaId;
    private long procedimentoId;

    public AgendamentoDTO() {

    }

    public AgendamentoDTO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.data = agendamento.getData();
        this.situacao = agendamento.getSituacao();
        this.pessoaId = agendamento.getPessoa().getId();
        this.procedimentoId = agendamento.getProcedimento().getId();
    }
}
