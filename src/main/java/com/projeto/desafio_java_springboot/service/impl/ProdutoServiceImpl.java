package com.projeto.desafio_java_springboot.service.impl;

import com.projeto.desafio_java_springboot.domain.ErrorMessage;
import com.projeto.desafio_java_springboot.domain.Produto;
import com.projeto.desafio_java_springboot.dto.ProdutoInsertDTO;
import com.projeto.desafio_java_springboot.repository.ProdutoRepository;
import com.projeto.desafio_java_springboot.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseEntity insert(ProdutoInsertDTO produtoInsertDTO) {
        if (produtoInsertDTO.validate() != null)
            return new ResponseEntity<>(new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                    produtoInsertDTO.validate()), HttpStatus.BAD_REQUEST);
        Produto produto = modelMapper.map(produtoInsertDTO, Produto.class);
        Produto produtoInserido = produtoRepository.save(produto);
        return new ResponseEntity<>(produtoInserido, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity update(ProdutoInsertDTO produtoInsertDTO, String id) {
        if (produtoInsertDTO.validate() != null)
            return new ResponseEntity<>(new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                    produtoInsertDTO.validate()), HttpStatus.BAD_REQUEST);

        Optional<Produto> productById = produtoRepository.findById(id);

        if (productById.isPresent()) {
            Produto newProduct = modelMapper.map(produtoInsertDTO, Produto.class);
            newProduct.setId(id);
            produtoRepository.save(newProduct);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND.value(),
                    "O produto " + id + " não foi encontrado."), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity read(String id) {
        Optional<Produto> productById = produtoRepository.findById(id);
        if (productById.isPresent()) {
            return new ResponseEntity<>(productById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND.value(),
                    "O produto " + id + " não foi encontrado."), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity readAll() {
        return new ResponseEntity<>(produtoRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(String id) {
        Optional<Produto> productById = produtoRepository.findById(id);
        if (productById.isPresent()) {
            produtoRepository.delete(productById.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND.value(),
                    "O produto " + id + " não foi encontrado."), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity readSearch(Double min_price, Double max_price, String q) {
        List<Produto> products = produtoRepository.findAllByPriceNameDescription(min_price, max_price, q);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
