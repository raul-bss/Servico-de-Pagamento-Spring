package com.example.WebService.Spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WebService.Spring.Entites.User;

public interface UserRepository extends JpaRepository<User, Long> {}
