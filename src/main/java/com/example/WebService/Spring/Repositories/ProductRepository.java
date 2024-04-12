package com.example.WebService.Spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WebService.Spring.Entites.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
