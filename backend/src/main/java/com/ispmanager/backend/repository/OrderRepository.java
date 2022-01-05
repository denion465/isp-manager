package com.ispmanager.backend.repository;

import com.ispmanager.backend.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {}
