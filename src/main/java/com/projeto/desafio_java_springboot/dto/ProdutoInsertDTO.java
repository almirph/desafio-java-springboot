package com.projeto.desafio_java_springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoInsertDTO {
    private String name;
    private String description;
    private Double price;
}
