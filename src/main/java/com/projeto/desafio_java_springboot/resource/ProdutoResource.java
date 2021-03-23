package com.projeto.desafio_java_springboot.resource;

import com.projeto.desafio_java_springboot.dto.ProdutoInsertDTO;
import com.projeto.desafio_java_springboot.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/products")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity insert(@RequestBody ProdutoInsertDTO produtoInsertDTO) {
        return produtoService.insert(produtoInsertDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity update(@RequestBody ProdutoInsertDTO produtoInsertDTO, @PathVariable String id) {
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
    public ResponseEntity readSearch(@RequestParam(required = false) Double min_price,
                                     @RequestParam(required = false) Double max_price,
                                     @RequestParam(required = false) String q) {
        return produtoService.readSearch(min_price, max_price, q);
    }
}