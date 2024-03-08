package com.example.retrolife.model;

import com.google.gson.annotations.SerializedName;

public class Cliente {

    @SerializedName("id")
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}


