package com.projeto.desafio_java_springboot.resource;

import com.projeto.desafio_java_springboot.domain.Produto;
import com.projeto.desafio_java_springboot.dto.ProdutoInsertDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/products")
public class ProdutoResource {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity insert(@Valid @RequestBody ProdutoInsertDTO produtoInsertDTO) {
        return new ResponseEntity<>(new Produto(), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity update(@Valid @RequestBody ProdutoInsertDTO produtoInsertDTO, @PathVariable String id) {
        return new ResponseEntity<>(new Produto(), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity read(@PathVariable String id) {
        return new ResponseEntity<>(new Produto(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity readAll() {
        return new ResponseEntity<>(Arrays.asList(new Produto()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity readSearch(@RequestParam Double min_price, @RequestParam Double max_price, @RequestParam String q) {
        return new ResponseEntity<>(Arrays.asList(new Produto()), HttpStatus.OK);
    }
}