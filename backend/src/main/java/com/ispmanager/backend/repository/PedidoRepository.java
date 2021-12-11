package com.ispmanager.backend.repository;

import com.ispmanager.backend.model.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {}
