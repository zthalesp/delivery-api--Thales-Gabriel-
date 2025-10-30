package com.deliverytech.delivery_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero_pedido;

    private String data_pedido;

    private String status;

    private String valor_total;

    private String observacoes;

    private String cliente_id;

    private String restaurante_id;

    private String itens;


    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;


}