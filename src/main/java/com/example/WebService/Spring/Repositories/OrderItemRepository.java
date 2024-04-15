package com.example.WebService.Spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WebService.Spring.Entites.OrderItem;
import com.example.WebService.Spring.Entites.PK.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
