package com.example.retrolife.model;

import androidx.annotation.NonNull;

import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;

    public Product(Integer id, String nombre, String descripcion, BigDecimal precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Product() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @NonNull
    @Override
    public String toString() {
        return "Id: " + getId() + ", Nombre: " + getNombre() + ", Descripcion: " + getDescripcion() + ", Precio: " + getPrecio();
    }
}
