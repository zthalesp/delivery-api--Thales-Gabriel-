package com.deliverytech.delivery_api.repository;

import com.deliverytech.delivery_api.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    
    List<Produto> findByrelatorios(String avaliacao);

    
    boolean existsByativo(String ativo);

    
    List<Produto> findByCategoria(String categoria);

    
}