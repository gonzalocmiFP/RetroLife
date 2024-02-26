package com.dam.pruebaspring.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "direccion")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Direccion {
    @Column(name = "Id_direccion")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Codigo_postal")
    private String codigoPostal;
    @Column(name = "Municipio")
    private String municipio;
    @Column(name = "Nombre_via")
    private String nombreVia;
    @Column(name = "Id_cliente_direccion")
    private Integer idClienteDireccion;
}
