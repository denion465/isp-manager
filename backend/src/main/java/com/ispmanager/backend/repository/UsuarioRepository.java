package com.ispmanager.backend.repository;

import com.ispmanager.backend.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {}
