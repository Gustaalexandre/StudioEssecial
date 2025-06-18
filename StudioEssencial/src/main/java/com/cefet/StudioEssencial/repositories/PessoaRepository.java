package com.cefet.StudioEssencial.repositories;

import com.cefet.StudioEssencial.entities.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {   
}