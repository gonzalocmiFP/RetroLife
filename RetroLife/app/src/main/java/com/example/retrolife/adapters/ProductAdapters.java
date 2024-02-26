package com.example.retrolife.adapters;

import static com.example.retrolife.Login.idCliente;
import static com.example.retrolife.constants.Constants.BASE_URL;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrolife.Menu;
import com.example.retrolife.R;
import com.example.retrolife.Registro;
import com.example.retrolife.interfaz.CRUDInterface;
import com.example.retrolife.model.Carrito;
import com.example.retrolife.model.Product;
import com.bumptech.glide.Glide;

import java.math.BigDecimal;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductAdapters extends RecyclerView.Adapter<ProductAdapters.ProductViewHolder> implements View.OnClickListener {
    private List<Product> products;
    private Context context;

    public static int position2;

    public ProductAdapters(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_product_list, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.bind(product);
        holder.anadirCarrito.setTag(position);
        holder.anadirCarrito.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int position = (int) view.getTag();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CRUDInterface crudInterface = retrofit.create(CRUDInterface.class);

        String nombre = products.get(position).getNombre();
        BigDecimal precio = products.get(position).getPrecio();
        String idClienteCarrito = idCliente.toString();

        Carrito carrito = new Carrito(idClienteCarrito, nombre, precio);
        Call<Carrito> call = crudInterface.inserCarritoData(carrito);

        call.enqueue(new Callback<Carrito>() {
            @Override
            public void onResponse(Call<Carrito> call, Response<Carrito> response) {
                if (response.isSuccessful()) {
                    Log.e("Bien: ", "Producto insertado");
                    Toast.makeText(context, "Producto añadido", Toast.LENGTH_SHORT).show();
                    Log.e("Id: ", String.valueOf(idClienteCarrito));

                } else {
                    Log.e("Error: ", "Error al insertar producto");
                    Log.d("Error: ", response.message());
                }
            }

            @Override
            public void onFailure(Call<Carrito> call, Throwable t) {
                Log.e("Response error: ", t.getMessage());
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView priceText;

        Button anadirCarrito;
        ImageView productView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.nameText);
            priceText = itemView.findViewById(R.id.priceText);
            productView = itemView.findViewById(R.id.productView);
            anadirCarrito = itemView.findViewById(R.id.carrito);
        }

        public void bind(Product product) {

            Glide.with(context)
                    .load(product.getUrl())
                    .into(productView);

            nameText.setText(product.getNombre());
            priceText.setText(product.getPrecio().toString() + " €");
        }
    }
}