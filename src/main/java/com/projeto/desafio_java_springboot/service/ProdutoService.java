package com.projeto.desafio_java_springboot.service;

import com.projeto.desafio_java_springboot.dto.ProdutoInsertDTO;
import org.springframework.http.ResponseEntity;

public interface ProdutoService {
    ResponseEntity insert(ProdutoInsertDTO produtoInsertDTO);

    ResponseEntity update(ProdutoInsertDTO produtoInsertDTO, String id);

    ResponseEntity read(String id);

    ResponseEntity readAll();

    ResponseEntity delete(String id);

    ResponseEntity readSearch(Double min_price, Double max_price, String q);
}
