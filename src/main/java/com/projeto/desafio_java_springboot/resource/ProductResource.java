package com.projeto.desafio_java_springboot.resource;

import com.projeto.desafio_java_springboot.dto.ProductInsertDTO;
import com.projeto.desafio_java_springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity insert(@RequestBody ProductInsertDTO productInsertDTO) {
        return productService.insert(productInsertDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity update(@RequestBody ProductInsertDTO productInsertDTO, @PathVariable String id) {
        return productService.update(productInsertDTO, id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity read(@PathVariable String id) {
        return productService.read(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity readAll() {
        return productService.readAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        return productService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity readSearch(@RequestParam(required = false) Double min_price,
                                     @RequestParam(required = false) Double max_price,
                                     @RequestParam(required = false) String q) {
        return productService.readSearch(min_price, max_price, q);
    }
}