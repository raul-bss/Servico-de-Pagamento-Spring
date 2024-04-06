package com.example.WebService.Spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WebService.Spring.Entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
