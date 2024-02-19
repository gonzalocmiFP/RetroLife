package com.example.retrolife;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrolife.adapters.ProductAdapters;
import com.example.retrolife.constants.Constants;
import com.example.retrolife.interfaz.CRUDInterface;
import com.example.retrolife.model.Product;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Menu extends AppCompatActivity {

    private List<Product> products;
    private CRUDInterface crudInterface;
    private RecyclerView recyclerView;
    private ProductAdapters productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getAllProducts();

        Button perfil = findViewById(R.id.pasarPerfil);
        Button carrito = findViewById(R.id.pasarCarrito);

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Perfil.class);
                startActivity(intent);
            }
        });

        carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, CarritoCompra.class);
                startActivity(intent);
            }
        });
    }

    private void getAllProducts() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        crudInterface = retrofit.create(CRUDInterface.class);
        Call<List<Product>> call = crudInterface.getAll();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    products = response.body();
                    if (products != null) {
                        productAdapter = new ProductAdapters(products, Menu.this);
                        recyclerView.setAdapter(productAdapter);
                    } else {
                        Log.e("Response error: ", "Null products received");
                    }
                } else {
                    Log.e("Response error: ", response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Product>> call, @NonNull Throwable t) {
                Log.e("Throw error: ", t.getMessage());
            }
        });
    }
}