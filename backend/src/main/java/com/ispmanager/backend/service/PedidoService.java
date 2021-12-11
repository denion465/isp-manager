package com.ispmanager.backend.service;

import com.ispmanager.backend.exception.EntidadeNaoEncontradaException;
import com.ispmanager.backend.model.Pedido;
import com.ispmanager.backend.model.Usuario;
import com.ispmanager.backend.repository.PedidoRepository;
import com.ispmanager.backend.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {
  private final PedidoRepository pedidoRepository;
  private final UsuarioRepository usuarioRepository;

  public Pedido salvar(Pedido pedido) {
    Integer usuarioId = pedido.getUsuario().getId();

    Usuario usuario = usuarioRepository.findById(usuarioId)
      .orElseThrow(() -> new EntidadeNaoEncontradaException(
        String.format("Não existe cadastro de usuario com id %d", usuarioId)
      ));

      pedido.setUsuario(usuario);

      return pedidoRepository.save(pedido);
  }
}
