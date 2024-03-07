package com.example.retrolife;

import static com.example.retrolife.Login.idCliente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrolife.adapters.CarritoAdapter;
import com.example.retrolife.constants.Constants;
import com.example.retrolife.interfaz.CRUDInterface;
import com.example.retrolife.model.Carrito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarritoCompra extends AppCompatActivity {

    private List<Carrito> carritos;
    private CRUDInterface crudInterface;
    private RecyclerView recyclerView;
    public static CarritoAdapter carritoAdapter;

    public static List<Carrito> carritosFiltrados = new ArrayList<>();
    public static BigDecimal precioTotal = BigDecimal.valueOf(0);
    public static TextView precioCarrito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_compra);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.principal));
        recyclerView = findViewById(R.id.recyclerViewCarrito);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar precioCarrito


        getAllCarritos();

        Button menuCarro = findViewById(R.id.menuCarro);
        menuCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (precioTotal.compareTo(BigDecimal.ZERO) != 0) {
                    Intent intent = new Intent(CarritoCompra.this, DireccionEnvio.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Añade algo al carrito", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getAllCarritos() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        crudInterface = retrofit.create(CRUDInterface.class);
        Call<List<Carrito>> call = crudInterface.getAllCarritos();
        call.enqueue(new Callback<List<Carrito>>() {
            @Override
            public void onResponse(@NonNull Call<List<Carrito>> call, @NonNull Response<List<Carrito>> response) {
                if (response.isSuccessful()) {
                    carritos = response.body();
                    carritosFiltrados.clear();
                    precioTotal = BigDecimal.valueOf(0);

                    for (Carrito carrito : carritos) {
                        boolean encontrado = false;
                        for (Carrito carritoFiltrado : carritosFiltrados) {
                            if (carrito.getNombre().equals(carritoFiltrado.getNombre())) {
                                // Producto encontrado, actualiza la cantidad y el precio
                                carritoFiltrado.setcantidad(+1);
                                carritoFiltrado.setPrecio(carritoFiltrado.getPrecio().add(carrito.getPrecio()));
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado && carrito.getId().toString().equals(idCliente.toString())) {
                            carritosFiltrados.add(carrito);
                        }
                    }


                    // Calcular el precio total
                    precioTotal = BigDecimal.valueOf(0);
                    for (Carrito carrito : carritosFiltrados) {
                        precioTotal = precioTotal.add(carrito.getPrecio());
                    }



                    // Configurar el adaptador del RecyclerView
                    carritoAdapter = new CarritoAdapter(carritosFiltrados, CarritoCompra.this);
                    recyclerView.setAdapter(carritoAdapter);
                } else {
                    Log.e("Response error: ", response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Carrito>> call, @NonNull Throwable t) {
                Log.e("Throw error: ", t.getMessage());
            }
        });
    }
}
