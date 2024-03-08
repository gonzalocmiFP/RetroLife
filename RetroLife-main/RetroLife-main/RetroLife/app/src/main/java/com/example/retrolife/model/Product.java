package com.example.retrolife.model;

import androidx.annotation.NonNull;

import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;

    private String url;

    public Product(Integer id, String nombre, String descripcion, BigDecimal precio, String url) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @NonNull
    @Override
    public String toString() {
        return "Id: " + getId() + ", Nombre: " + getNombre() + ", Descripcion: " + getDescripcion() + ", Precio: " + getPrecio() + ", Url" + getUrl();
    }
}
