package com.telecom.backend.service;

import com.telecom.backend.exception.EntidadeNaoEncontradaException;
import com.telecom.backend.model.Pedido;
import com.telecom.backend.model.Usuario;
import com.telecom.backend.repository.PedidoRepository;
import com.telecom.backend.repository.UsuarioRepository;

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
