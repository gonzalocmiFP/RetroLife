package com.dam.pruebaspring.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "producto") // en name viene el nombre de la tabla en la bbdd
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Producto {
    @Column(name = "Id_producto")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nombre_producto")
    private String nombre;
    @Column(name = "Descripcion_producto")
    private String descripcion;
    @Column(name = "Precio_producto")
    private BigDecimal precio;
}
