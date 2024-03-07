package com.example.retrolife;

import static com.example.retrolife.Perfil.nombreFinal;
import static com.example.retrolife.constants.Constants.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrolife.R.color;
import com.example.retrolife.interfaz.CRUDInterface;
import com.example.retrolife.model.Cliente;
import com.example.retrolife.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Login extends AppCompatActivity {


    private List<Cliente> clientes;

    public static Integer idCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, color.principal));
        CheckBox acepto = findViewById(R.id.terminosLegales);

        Button registro = findViewById(R.id.cambioRegistro);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registro.class);
                startActivity(intent);
            }
        });



        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = ((EditText) findViewById(R.id.username)).getText().toString();
                String contrasena = ((EditText) findViewById(R.id.password)).getText().toString();
                nombreFinal = nombre;

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                CRUDInterface crudInterface = retrofit.create(CRUDInterface.class);
                Call<List<Cliente>> call = crudInterface.getAllClientes();
                call.enqueue(new Callback<List<Cliente>>() {
                    @Override
                    public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                        if(acepto.isChecked()){
                        if (!nombre.isEmpty() && !contrasena.isEmpty()) {
                            if (response.isSuccessful()) {
                                List<Cliente> clientes = response.body();
                                boolean credencialesValidas = false;
                                for (Cliente cliente : clientes) {
                                    if (cliente.getNombre().equals(nombre) && cliente.getContrasena().equals(contrasena)) {
                                        idCliente = cliente.getId();
                                        credencialesValidas = true;
                                        break;
                                    }
                                }
                                if (credencialesValidas) {
                                    Intent intent = new Intent(Login.this, Menu.class);
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Error en la solicitud", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Campos vacios", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                            Toast.makeText(getApplicationContext(), "Acepta los términos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Cliente>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Credenciales mal introducidas", Toast.LENGTH_SHORT).show();

                    }
                });



            }
        });

    }
}