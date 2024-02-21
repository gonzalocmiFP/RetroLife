package com.dam.pruebaspring.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "carrito")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Carrito {
    @Column(name = "Id_carrito")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ID_cliente_carrito")
    private Integer idClienteCarrito;
    @Column(name = "Nombre_carrito")
    private String nombre;
    @Column(name = "Precio_carrito")
    private BigDecimal precio;
}
