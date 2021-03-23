package com.projeto.desafio_java_springboot.service;

import com.projeto.desafio_java_springboot.dto.ProductInsertDTO;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity insert(ProductInsertDTO productInsertDTO);

    ResponseEntity update(ProductInsertDTO productInsertDTO, String id);

    ResponseEntity read(String id);

    ResponseEntity readAll();

    ResponseEntity delete(String id);

    ResponseEntity readSearch(Double min_price, Double max_price, String q);
}
