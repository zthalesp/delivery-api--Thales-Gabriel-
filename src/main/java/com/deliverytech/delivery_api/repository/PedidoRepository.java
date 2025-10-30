package com.deliverytech.delivery_api.repository;

import com.deliverytech.delivery_api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Buscar cliente por email (método derivado)
    Optional<Pedido> findByEmail(String email);

    // Verificar se email já existe
    boolean existsByEmail(String status);

    // Buscar pedidos ativos
    List<Pedido> findByAtivoTrue();

    // Buscar pedido por nome (contendo)
    List<Pedido> findByNomeContainingIgnoreCase(String nome);

    // 🔍 Buscar pedidos com múltiplos filtros dinâmicos
    @Query("""
        SELECT p FROM Pedido p
        WHERE (:numeroPedido IS NULL OR p.numeroPedido = :numeroPedido)
          AND (:dataPedido IS NULL OR p.dataPedido = :dataPedido)
          AND (:status IS NULL OR LOWER(p.status) = LOWER(:status))
          AND (:valorTotal IS NULL OR p.valorTotal = :valorTotal)
          AND (:observacoes IS NULL OR LOWER(p.observacoes) LIKE LOWER(CONCAT('%', :observacoes, '%')))
          AND (:clienteId IS NULL OR p.cliente.id = :clienteId)
          AND (:restauranteId IS NULL OR p.restaurante.id = :restauranteId)
          AND (:itens IS NULL OR SIZE(p.itens) = :itens)
          AND (:nome IS NULL OR LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%')))
          AND (:categoria IS NULL OR LOWER(p.categoria) = LOWER(:categoria))
          AND (:ativo IS NULL OR p.ativo = :ativo)
        ORDER BY p.avaliacao DESC
    """)
    List<Pedido> buscarPedidosAvancado(
        @Param("numeroPedido") Long numeroPedido,
        @Param("dataPedido") LocalDate dataPedido,
        @Param("status") String status,
        @Param("valorTotal") Double valorTotal,
        @Param("observacoes") String observacoes,
        @Param("clienteId") Long clienteId,
        @Param("restauranteId") Long restauranteId,
        @Param("itens") Integer itens,
        @Param("nome") String nome,
        @Param("categoria") String categoria,
        @Param("ativo") Boolean ativo
    );
}
