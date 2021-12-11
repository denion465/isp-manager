package com.ispmanager.backend.controller;

import java.util.List;

import com.ispmanager.backend.exception.EntidadeNaoEncontradaException;
import com.ispmanager.backend.model.Pedido;
import com.ispmanager.backend.repository.PedidoRepository;
import com.ispmanager.backend.service.PedidoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController @RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

  private final PedidoRepository pedidoRepository;
  private final PedidoService pedidoService;

  @GetMapping
  public List<Pedido> listar() {
    return pedidoRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<?> adicionar(@RequestBody Pedido pedido) {
    try {
      pedido = pedidoService.salvar(pedido);

      return ResponseEntity.status(HttpStatus.CREATED).body(pedido);

    } catch (EntidadeNaoEncontradaException e) {

      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
