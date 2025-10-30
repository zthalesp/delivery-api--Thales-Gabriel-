package com.deliverytech.delivery_api.repository;



import com.deliverytech.delivery_api.model.Restaurante;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    
    List<Restaurante> findByrestalrante(String nome);

    
    boolean existsByProduto(String ativo);

    
    List<Restaurante> findByCategoria(String categoria);

    
}