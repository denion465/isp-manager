package com.ispmanager.backend.service;

import com.ispmanager.backend.model.Usuario;
import com.ispmanager.backend.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
  private final UsuarioRepository usuarioRepository;

  UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  public Usuario salvar(Usuario usuario) {
    return usuarioRepository.save(usuario);
  }
}
