package com.cefet.StudioEssencial.repositories;

import com.cefet.StudioEssencial.entities.Agendamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}