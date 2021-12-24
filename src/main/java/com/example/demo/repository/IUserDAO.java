package com.example.demo.repository;

import com.example.demo.entity.CarType;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.Optional;

public interface IUserDAO extends JpaRepository<User, BigInteger> {
    Optional<User> findByName(String name);
    @Query("select u from User as u left join Car as c where c.carType = :t")
    Optional<User> findByCars_Type(CarType t);
}
