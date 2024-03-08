package com.example.retrolife.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class Carrito {


    @SerializedName("id")
    private String idUnico;
    @SerializedName("idClienteCarrito")
    private String id;
    @SerializedName("nombre")
    private String nombre;

    @SerializedName("precio")
    private BigDecimal precio;
    @SerializedName("cantidad")
    private Integer cantidad;

    public Carrito(String id, String nombre, BigDecimal precio, Integer cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
        this.cantidad = cantidad;
    }

    public Carrito() {
    }


    public String getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(String idUnico) {
        this.idUnico = idUnico;
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

    public Integer getcantidad() {
        return cantidad;
    }

    public void setcantidad(Integer cantidad) {
        this.cantidad += cantidad;
    }

}
