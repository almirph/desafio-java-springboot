package com.projeto.desafio_java_springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {
    private Integer status_code;
    private String message;
}
