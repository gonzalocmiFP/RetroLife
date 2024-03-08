package com.example.retrolife;

import static com.example.retrolife.Login.idCliente;
import static com.example.retrolife.constants.Constants.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.retrolife.interfaz.CRUDInterface;
import com.example.retrolife.model.Cliente;
import com.example.retrolife.model.Direccion;
import com.example.retrolife.model.Tarjeta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DireccionEnvio extends AppCompatActivity {

    public static boolean tarjetaInsert = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direccion_envio);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.principal));

        Button paypal = findViewById(R.id.paypal);
        Button tarjeta = findViewById(R.id.tarjeta);

        Button insertarDireccion = findViewById(R.id.insertarDireccion);

        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paypalDialog();
            }
        });


        tarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarjetaDialog();
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CRUDInterface crudInterface = retrofit.create(CRUDInterface.class);

        insertarDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigoPostal = ((EditText) findViewById(R.id.codigoPostal)).getText().toString();
                String municipio = ((EditText) findViewById(R.id.municipio)).getText().toString();
                String nombreVia = ((EditText) findViewById(R.id.nombre)).getText().toString();
                int id_cliente_direccion = idCliente;

                Direccion direccion = new Direccion(codigoPostal, municipio, nombreVia, id_cliente_direccion);

                if(tarjetaInsert == true){

                Call<Direccion> call = crudInterface.insertDireccionData(direccion);

                call.enqueue(new Callback<Direccion>() {
                    @Override
                    public void onResponse(Call<Direccion> call, Response<Direccion> response) {
                        if(!codigoPostal.isEmpty() && !municipio.isEmpty() && !nombreVia.isEmpty()){
                            if(response.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Gracias por su compra", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(DireccionEnvio.this, Menu.class);
                                startActivity(intent);

                            }else{
                                Toast.makeText(getApplicationContext(), "Error al insertar direccion", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(getApplicationContext(), "Campos vacíos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Direccion> call, Throwable t) {

                    }
                });
                }else{
                    Toast.makeText(getApplicationContext(), "Seleccione un metodo de pago", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void paypalDialog() {
        // Crear los EditText para cada campo necesario
        final EditText editText1 = new EditText(this);
        final EditText editText2 = new EditText(this);
        final EditText editText3 = new EditText(this);

        editText1.setHint("Numero de la tarjeta...");
        editText2.setHint("MM/AA");
        editText3.setHint("CVV");

        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(ContextCompat.getColor(this, R.color.principal));
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.addView(editText1);
        layout.addView(editText2);
        layout.addView(editText3);



        new AlertDialog.Builder(this, R.style.CustomAlertDialogStyle)
                .setIcon(R.drawable.paypal)
                .setTitle("PayPal")
                .setView(layout)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String numeroTarjeta = editText1.getText().toString();
                        String fechaExpiracion = editText2.getText().toString();
                        String cvv = editText3.getText().toString();
                        String idClienteTarjeta = String.valueOf(idCliente);
                        Log.e("numero: " , numeroTarjeta);

                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        CRUDInterface crudInterface = retrofit.create(CRUDInterface.class);
                        Tarjeta tarjeta = new Tarjeta(numeroTarjeta, fechaExpiracion, cvv, idClienteTarjeta);
                        if(tarjetaInsert == false) {


                            Call<Tarjeta> call = crudInterface.insertTarjetaData(tarjeta);

                            call.enqueue(new Callback<Tarjeta>() {
                                @Override
                                public void onResponse(Call<Tarjeta> call, Response<Tarjeta> response) {

                                    if (!numeroTarjeta.isEmpty() && !fechaExpiracion.isEmpty() && !cvv.isEmpty()) {
                                        if (response.isSuccessful()) {
                                            tarjetaInsert = true;
                                            Log.e("Bien: ", "Tarjeta insertada");
                                            Toast.makeText(getApplicationContext(), "Tarjeta insertada", Toast.LENGTH_SHORT).show();

                                        } else {
                                            Log.e("Error: ", "Error al insertar tarjeta");
                                            Log.d("Error: ", response.message());
                                        }

                                    } else {
                                        Toast.makeText(getApplicationContext(), "Campos vacíos", Toast.LENGTH_SHORT).show();
                                    }

                                }

                                @Override
                                public void onFailure(Call<Tarjeta> call, Throwable t) {

                                }
                            });
                        }else{
                            Toast.makeText(getApplicationContext(), "Ya hay un metodo de pago seleccionado", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Mensaje", "Cancelado");
                    }
                })
                .show();
    }


    private void tarjetaDialog() {
        // Crear los EditText para cada campo necesario
        final EditText editText1 = new EditText(this);
        final EditText editText2 = new EditText(this);
        final EditText editText3 = new EditText(this);

        editText1.setHint("Numero de la tarjeta...");
        editText2.setHint("MM/AA");
        editText3.setHint("CVV");

        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(ContextCompat.getColor(this, R.color.principal));
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.addView(editText1);
        layout.addView(editText2);
        layout.addView(editText3);



        new AlertDialog.Builder(this, R.style.CustomAlertDialogStyle)
                .setIcon(R.drawable.tarjeta)
                .setTitle("Tarjeta")
                .setView(layout)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String numeroTarjeta = editText1.getText().toString();
                        String fechaExpiracion = editText2.getText().toString();
                        String cvv = editText3.getText().toString();
                        String idClienteTarjeta = String.valueOf(idCliente);


                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        CRUDInterface crudInterface = retrofit.create(CRUDInterface.class);
                        Tarjeta tarjeta = new Tarjeta(numeroTarjeta, fechaExpiracion, cvv, idClienteTarjeta);
                        if(tarjetaInsert == false) {


                            Call<Tarjeta> call = crudInterface.insertTarjetaData(tarjeta);

                            call.enqueue(new Callback<Tarjeta>() {
                                @Override
                                public void onResponse(Call<Tarjeta> call, Response<Tarjeta> response) {

                                    if (!numeroTarjeta.isEmpty() && !fechaExpiracion.isEmpty() && !cvv.isEmpty()) {
                                        if (response.isSuccessful()) {
                                            tarjetaInsert = true;
                                            Log.e("Bien: ", "Tarjeta insertada");
                                            Toast.makeText(getApplicationContext(), "Tarjeta insertada", Toast.LENGTH_SHORT).show();

                                        } else {
                                            Log.e("Error: ", "Error al insertar tarjeta");
                                            Log.d("Error: ", response.message());
                                        }

                                    } else {
                                        Toast.makeText(getApplicationContext(), "Campos vacíos", Toast.LENGTH_SHORT).show();
                                    }

                                }

                                @Override
                                public void onFailure(Call<Tarjeta> call, Throwable t) {

                                }
                            });
                        }else{
                            Toast.makeText(getApplicationContext(), "Ya hay un metodo de pago seleccionado", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Mensaje", "Cancelado");
                    }
                })
                .show();
    }
}