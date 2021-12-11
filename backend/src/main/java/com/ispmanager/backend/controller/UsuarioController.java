package com.ispmanager.backend.controller;

import java.util.List;

import com.ispmanager.backend.model.Usuario;
import com.ispmanager.backend.repository.UsuarioRepository;
import com.ispmanager.backend.service.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController @RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

  private final UsuarioRepository usuarioRepository;
  private final UsuarioService usuarioService;

  @GetMapping
  public List<Usuario> listar() {
    return usuarioRepository.findAll();
  }

  @PostMapping
  public Usuario cadastrar(@RequestBody Usuario usuario) {
    return usuarioService.salvar(usuario);
  }
}
