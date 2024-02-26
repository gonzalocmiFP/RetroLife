package com.example.retrolife.interfaz;

import com.example.retrolife.model.Carrito;
import com.example.retrolife.model.Cliente;
import com.example.retrolife.model.Direccion;
import com.example.retrolife.model.Product;
import com.example.retrolife.model.Tarjeta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
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

    @GET("carrito/all")
    Call<List<Carrito>> getAllCarritos();

    @POST("carrito/save")
    Call<Carrito> inserCarritoData(@Body Carrito carrito);

    @DELETE("carrito/delete/{id}")
    Call<Boolean> deleteCarrito(@Path("id") Integer id);

    @POST("direccion/save")
    Call<Direccion> insertDireccionData(@Body Direccion direccion);

    @POST("tarjeta/save")
    Call<Tarjeta> insertTarjetaData(@Body Tarjeta tarjeta);

}
