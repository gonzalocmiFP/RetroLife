package com.example.retrolife.model;

import com.google.gson.annotations.SerializedName;

public class Cliente {
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("contrasena")
    private String contrasena;
    @SerializedName("email")
    private String email;
    @SerializedName("telefono")
    private String telefono;

    public Cliente(String nombre, String contrasena, String email, String telefono) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.telefono = telefono;
    }

    public Cliente() {
    }
}


