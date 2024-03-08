package com.example.retrolife.model;

import com.google.gson.annotations.SerializedName;

public class Direccion {

    @SerializedName("id")
    private int id;

    @SerializedName("codigoPostal")
    private String codigoPostal;

    @SerializedName("municipio")
    private String muncipio;

    @SerializedName("nombreVia")
    private String nombreVia;

    @SerializedName("idClienteDireccion")
    private int idClienteDireccion;


    public Direccion(String codigoPostal, String muncipio, String nombreVia, int idClienteDireccion) {
        this.codigoPostal = codigoPostal;
        this.muncipio = muncipio;
        this.nombreVia = nombreVia;
        this.idClienteDireccion = idClienteDireccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getMuncipio() {
        return muncipio;
    }

    public void setMuncipio(String muncipio) {
        this.muncipio = muncipio;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public int getIdClienteDireccion() {
        return idClienteDireccion;
    }

    public void setIdClienteDireccion(int idClienteDireccion) {
        this.idClienteDireccion = idClienteDireccion;
    }
}
