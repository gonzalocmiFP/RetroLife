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
    @Column(name = "Vía")
    private String via;
    @Column(name = "Nombre_vía")
    private String nombreVia;
    @Column(name = "Número")
    private Integer numero;
    @Column(name = "Portal")
    private String portal;
    @Column(name = "Piso")
    private Integer piso;
    @Column(name = "Letra")
    private String letra;
    @Column(name = "Id_cliente_dirección")
    private Integer idClienteDireccion;
}
