package com.dam.pruebaspring.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Pedido {
    @Column(name = "Id_pedido")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Fecha_entrega")
    private String fechaEntrega;
    @Column(name = "Precio_total")
    private String precioTotal;
    @Column(name = "Id_cliente_pedido")
    private Integer idClientePedido;
    @Column(name = "Id_tarjeta_pedido")
    private Integer idTarjetaPedido;
    @Column(name = "Id_direccion_pedido")
    private Integer idDireccionPedido;
}