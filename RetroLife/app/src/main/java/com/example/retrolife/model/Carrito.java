package com.example.retrolife.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class Carrito {


    @SerializedName("id")
    private String id;
    @SerializedName("nombre")
    private String nombre;

    @SerializedName("precio")
    private BigDecimal precio;

    public Carrito(String id, String nombre, BigDecimal precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
    }

    public Carrito() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
