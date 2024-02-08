package com.dam.pruebaspring.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tarjeta") // en name viene el nombre de la tabla en la bbdd
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Tarjeta {
    @Column(name = "Id_tarjeta")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Numero_tarjeta")
    private String numero;
    @Column(name = "Fecha_caducidad")
    private String fechaCaducidad;
    @Column(name = "CVV_tarjeta")
    private String cvvTarjeta;
    @Column(name = "Id_cliente_tarjeta")
    private String idClienteTarjeta;
}
