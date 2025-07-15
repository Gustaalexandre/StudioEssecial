package com.cefet.StudioEssencial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.StudioEssencial.entities.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {
}