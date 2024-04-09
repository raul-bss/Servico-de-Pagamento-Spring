package com.example.WebService.Spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import com.example.WebService.Spring.Entites.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
