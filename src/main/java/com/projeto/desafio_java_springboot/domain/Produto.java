package com.projeto.desafio_java_springboot.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    private String id;
    private String name;
    private String description;
    private Double price;
}
