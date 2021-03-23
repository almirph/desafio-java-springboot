package com.projeto.desafio_java_springboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    private Double price;
}
