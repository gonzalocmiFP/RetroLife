package com.example.retrolife.interfaz;

import com.example.retrolife.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CRUDInterface {
    @GET ("product/all")
    Call<List<Product>> getAll();
}
