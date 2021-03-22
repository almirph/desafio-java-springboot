package com.projeto.desafio_java_springboot.repository;

import com.projeto.desafio_java_springboot.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}