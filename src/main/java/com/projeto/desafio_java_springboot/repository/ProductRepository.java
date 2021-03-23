package com.projeto.desafio_java_springboot.repository;

import com.projeto.desafio_java_springboot.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p FROM Product p WHERE (:min_price is null OR p.price>=:min_price) AND (:max_price is null OR p.price<=:max_price) AND (:q is null OR p.name LIKE %:q% OR p.description LIKE %:q%)")
    List<Product> findAllByPriceNameDescription(@Param("min_price") Double min_price, @Param("max_price") Double max_price, @Param("q") String q);
}
