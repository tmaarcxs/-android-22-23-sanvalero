package com.svalero.vinted.Activity;

import static java.lang.System.console;
import static java.lang.System.out;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.svalero.vinted.Controller;
import com.svalero.vinted.Model.Usuario;
import com.svalero.vinted.R;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //funcionalidad boton login
        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.btnLogin);
        TextView register = findViewById(R.id.singUp);

        //onclick listener
        register.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });

        //CRASHEA SI NO HAY API
            loginButton.setOnClickListener(v -> {
                Controller api = new Controller();
                String response = null;
                try {
                    response = api.callAPI("/usuarios/nombre=" + username.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!response.equals("[]")){
                    ArrayList<Usuario> usuarios = Usuario.toArrayList(response);
                    if (password.getText().toString().equals(usuarios.get(0).getContrasena())) {
                        //ir a la pantalla de inicio
                        Toast.makeText(this, "Login correcto", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, HomeActivity.class);
                        intent.putParcelableArrayListExtra("usuario", usuarios);
                        startActivity(intent);
                    } else {
                        //mostrar mensaje de error
                        Toast.makeText(this, "Login incorrecto", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Login incorrecto", Toast.LENGTH_SHORT).show();
                }
            });
    }
}