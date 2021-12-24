package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface IUserDAO extends JpaRepository<User, BigInteger> {
    User findByName(String name);
}
