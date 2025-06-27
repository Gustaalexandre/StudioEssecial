package com.cefet.StudioEssencial.repositories;

import com.cefet.StudioEssencial.entities.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}