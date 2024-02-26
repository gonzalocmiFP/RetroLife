package com.example.retrolife.adapters;

import static com.example.retrolife.CarritoCompra.carritoAdapter;
import static com.example.retrolife.CarritoCompra.carritosFiltrados;
import static com.example.retrolife.CarritoCompra.precioCarrito;
import static com.example.retrolife.CarritoCompra.precioTotal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.retrolife.R;
import com.example.retrolife.constants.Constants;
import com.example.retrolife.interfaz.CRUDInterface;
import com.example.retrolife.model.Carrito;


import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarritoAdapter extends RecyclerView.Adapter<CarritoAdapter.CarritoViewHolder> implements View.OnClickListener{
    private List<Carrito> carritos;

    private CRUDInterface crudInterface;
    private Context context;

    public CarritoAdapter(List<Carrito> carritos, Context context) {
        this.carritos = carritos;
        this.context = context;
    }

    @NonNull
    @Override
    public CarritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_carrito_list, parent, false);
        return new CarritoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoViewHolder holder, int position) {
        Carrito carrito = carritos.get(position);
        holder.bind(carrito);
        holder.eliminarCarrito.setTag(position);
        holder.eliminarCarrito.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        int position = (int) view.getTag();

        Carrito carritoAEliminar = carritosFiltrados.get(position);

        Integer idCarritoAEliminar = Integer.valueOf(carritoAEliminar.getIdUnico());

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        crudInterface = retrofit.create(CRUDInterface.class);
        Call<Boolean> call = crudInterface.deleteCarrito(idCarritoAEliminar);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful()) {
                    Boolean result = response.body();
                    Log.e("Bien:", "Carrito eliminado");
                    Toast.makeText(context, "Producto eliminado", Toast.LENGTH_SHORT).show();

                    carritosFiltrados.remove(position);

                    carritoAdapter.notifyItemRemoved(position);
                    carritoAdapter.notifyDataSetChanged();

                    precioTotal = precioTotal.subtract(carritoAEliminar.getPrecio());

                    precioCarrito.setText(precioTotal + "€");


                }else{
                    Log.e("Mal: ", "Mal");

                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return carritos.size();
    }


    public class CarritoViewHolder extends RecyclerView.ViewHolder {
        TextView nombreCarrito;
        TextView precioCarrito;

        Button eliminarCarrito;


        public CarritoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreCarrito = itemView.findViewById(R.id.nombreCarrito);
            precioCarrito = itemView.findViewById(R.id.precioCarrito);
            eliminarCarrito = itemView.findViewById(R.id.eliminarCarrito);
        }

        public void bind(Carrito carrito) {

            nombreCarrito.setText(carrito.getNombre());
            precioCarrito.setText(carrito.getPrecio().toString() + " €");
        }
    }
}
