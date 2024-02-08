package com.dam.pruebaspring.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "cliente") // en name viene el nombre de la tabla en la bbdd
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cliente {
    @Column(name = "Id_cliente")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nombre_cliente")
    private String nombre;
    @Column(name = "Contrasena_cliente")
    private String contrasena;
    @Column(name = "Email_cliente")
    private String email;
    @Column(name = "Teléfono_cliente")
    private String telefono;
}
