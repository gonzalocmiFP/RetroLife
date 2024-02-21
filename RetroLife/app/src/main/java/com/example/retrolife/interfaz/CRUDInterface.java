package com.example.retrolife.interfaz;

import com.example.retrolife.model.Carrito;
import com.example.retrolife.model.Cliente;
import com.example.retrolife.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CRUDInterface {
    @GET ("producto/all")
    Call<List<Product>> getAll();

    @POST("cliente/save")
    Call<Cliente> insertData(@Body Cliente cliente);

    @GET("cliente/all")
    Call<List<Cliente>> getAllClientes();

    @POST("carrito/save")
    Call<Carrito> inserCarritoData(@Body Carrito carrito);
}
