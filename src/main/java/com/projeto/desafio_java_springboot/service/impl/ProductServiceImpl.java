package com.projeto.desafio_java_springboot.service.impl;

import com.projeto.desafio_java_springboot.domain.ErrorMessage;
import com.projeto.desafio_java_springboot.domain.Product;
import com.projeto.desafio_java_springboot.dto.ProductInsertDTO;
import com.projeto.desafio_java_springboot.repository.ProductRepository;
import com.projeto.desafio_java_springboot.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseEntity insert(ProductInsertDTO productInsertDTO) {
        if (productInsertDTO.validate() != null)
            return new ResponseEntity<>(new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                    productInsertDTO.validate()), HttpStatus.BAD_REQUEST);

        Product product = modelMapper.map(productInsertDTO, Product.class);
        Product productInserted = productRepository.save(product);
        return new ResponseEntity<>(productInserted, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity update(ProductInsertDTO productInsertDTO, String id) {
        if (productInsertDTO.validate() != null)
            return new ResponseEntity<>(new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                    productInsertDTO.validate()), HttpStatus.BAD_REQUEST);

        Optional<Product> productById = productRepository.findById(id);

        if (productById.isPresent()) {
            Product newProduct = modelMapper.map(productInsertDTO, Product.class);
            newProduct.setId(id);
            productRepository.save(newProduct);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND.value(),
                    "O produto " + id + " não foi encontrado."), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity read(String id) {
        Optional<Product> productById = productRepository.findById(id);

        if (productById.isPresent()) {
            return new ResponseEntity<>(productById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND.value(),
                    "O produto " + id + " não foi encontrado."), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity readAll() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(String id) {
        Optional<Product> productById = productRepository.findById(id);

        if (productById.isPresent()) {
            productRepository.delete(productById.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND.value(),
                    "O produto " + id + " não foi encontrado."), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity readSearch(Double min_price, Double max_price, String q) {
        List<Product> products = productRepository.findAllByPriceNameDescription(min_price, max_price, q);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
