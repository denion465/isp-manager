package com.ispmanager.backend.service;

import com.ispmanager.backend.exception.EntidadeNaoEncontradaException;
import com.ispmanager.backend.model.Order;
import com.ispmanager.backend.model.UserEntity;
import com.ispmanager.backend.repository.OrderRepository;
import com.ispmanager.backend.repository.UserRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderRepository orderRepository;
  private final UserRepository userRepository;

  public Order saveOrder(Order order) {
    int userId = order.getUser().getId();

    UserEntity user = userRepository.findById(userId)
      .orElseThrow(() -> new EntidadeNaoEncontradaException(
        String.format("Não existe cadastro de usuario com id %d", userId)
      ));

      order.setUser(user);

      return orderRepository.save(order);
  }
}
