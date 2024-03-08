package com.example.retrolife;

import static com.example.retrolife.Perfil.nombreFinal;
import static com.example.retrolife.constants.Constants.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrolife.interfaz.CRUDInterface;
import com.example.retrolife.model.Cliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registro extends AppCompatActivity {

    public static String nombreRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.principal));

        Button menu = findViewById(R.id.pasarMenu);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CRUDInterface crudInterface = retrofit.create(CRUDInterface.class);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = ((EditText) findViewById(R.id.usernameR)).getText().toString();
                String contrasena = ((EditText) findViewById(R.id.passwordR)).getText().toString();
                String email = ((EditText) findViewById(R.id.mailR)).getText().toString();
                String telefono = ((EditText) findViewById(R.id.telefonoR)).getText().toString();

                nombreFinal = nombre;
                Cliente cliente = new Cliente(nombre, contrasena, email, telefono);

                Call<Cliente> call = crudInterface.insertData(cliente);

                call.enqueue(new Callback<Cliente>() {
                    @Override
                    public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                        if(!nombre.isEmpty() && !contrasena.isEmpty() && !email.isEmpty() && !telefono.isEmpty()){
                        if (response.isSuccessful()) {
                            Log.e("Bien: ", "Cliente insertado");
                            Toast.makeText(getApplicationContext(), "Registrado correctamente", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Registro.this, Login.class);
                            startActivity(intent);
                        } else {
                            Log.e("Error: ", "Error al insertar cliente");
                            Log.d("Error: ", response.message());
                        }
                        }else{
                            Toast.makeText(getApplicationContext(), "Campos vacíos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Cliente> call, Throwable t) {
                        Log.e("Response error: ", t.getMessage());
                    }
                });

            }
        });
    }
}