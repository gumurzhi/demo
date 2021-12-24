package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@Table(name = "users")
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private BigInteger id;
    @Column
    private String name;
    @Column
    private String pass;
    @Column
    private int age;

}
