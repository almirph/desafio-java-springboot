package com.projeto.desafio_java_springboot.repository;

import com.projeto.desafio_java_springboot.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

    @Query("SELECT p FROM Produto p WHERE p.price>=:min_price AND p.price<=:max_price AND (p.name LIKE :q OR p.description LIKE :q)")
    List<Produto> findAllByPriceNameDescription(@Param("min_price") Double min_price, @Param("max_price") Double max_price, @Param("q") String q);
}
