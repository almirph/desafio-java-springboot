package com.projeto.desafio_java_springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInsertDTO {

    private String name;
    private String description;
    private Double price;

    public String validate() {
        if(name == null || description == null || price == null)
            return "Os campos nome, description ou price não podem ser nulos";
        else if (price < 0)
            return "O campo price deve ser positivo";
        return null;
    }

}
