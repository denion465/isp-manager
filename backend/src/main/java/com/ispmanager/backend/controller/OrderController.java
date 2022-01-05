package com.ispmanager.backend.controller;

import java.util.List;

import com.ispmanager.backend.exception.EntidadeNaoEncontradaException;
import com.ispmanager.backend.model.Order;
import com.ispmanager.backend.repository.OrderRepository;
import com.ispmanager.backend.service.OrderService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderRepository orderRepository;
  private final OrderService orderService;

  @GetMapping
  public List<Order> listAllOrders() {
    return orderRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<?> createOrder(@RequestBody Order order) {
    try {
      order = orderService.saveOrder(order);

      return ResponseEntity.status(HttpStatus.CREATED).body(order);

    } catch (EntidadeNaoEncontradaException e) {

      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
