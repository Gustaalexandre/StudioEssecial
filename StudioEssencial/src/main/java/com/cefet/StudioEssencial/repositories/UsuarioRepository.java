package com.cefet.StudioEssencial.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.StudioEssencial.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
    boolean existsByLogin(String login);
}