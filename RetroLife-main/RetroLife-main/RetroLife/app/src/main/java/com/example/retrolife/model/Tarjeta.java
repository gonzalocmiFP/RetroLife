package com.example.retrolife.model;

import com.google.gson.annotations.SerializedName;

public class Tarjeta {
    @SerializedName("id")
    private int id;

    @SerializedName("numero")
    private String numero;

    @SerializedName("fechaCaducidad")
    private String fechaCaducidad;

    @SerializedName("cvvTarjeta")
    private String cvvTarjeta;

    @SerializedName("idClienteTarjeta")
    private String idClienteTarjeta;

    public Tarjeta(String numero, String fechaCaducidad, String cvvTarjeta, String idClienteTarjeta) {
        this.numero = numero;
        this.fechaCaducidad = fechaCaducidad;
        this.cvvTarjeta = cvvTarjeta;
        this.idClienteTarjeta = idClienteTarjeta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getCvvTarjeta() {
        return cvvTarjeta;
    }

    public void setCvvTarjeta(String cvvTarjeta) {
        this.cvvTarjeta = cvvTarjeta;
    }

    public String getIdClienteTarjeta() {
        return idClienteTarjeta;
    }

    public void setIdClienteTarjeta(String idClienteTarjeta) {
        this.idClienteTarjeta = idClienteTarjeta;
    }
}
