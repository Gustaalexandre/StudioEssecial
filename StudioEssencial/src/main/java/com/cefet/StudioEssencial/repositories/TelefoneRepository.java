package com.cefet.StudioEssencial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.StudioEssencial.entities.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}