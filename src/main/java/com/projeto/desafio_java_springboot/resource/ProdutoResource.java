package com.projeto.desafio_java_springboot.resource;

import com.projeto.desafio_java_springboot.dto.ProdutoInsertDTO;
import com.projeto.desafio_java_springboot.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/products")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity insert(@Valid @RequestBody ProdutoInsertDTO produtoInsertDTO) {
        return produtoService.insert(produtoInsertDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity update(@Valid @RequestBody ProdutoInsertDTO produtoInsertDTO, @PathVariable String id) {
        return produtoService.update(produtoInsertDTO, id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity read(@PathVariable String id) {
        return produtoService.read(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity readAll() {
        return produtoService.readAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        return produtoService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity readSearch(@RequestParam Double min_price, @RequestParam Double max_price, @RequestParam String q) {
        return produtoService.readSearch(min_price, max_price, q);
    }
}