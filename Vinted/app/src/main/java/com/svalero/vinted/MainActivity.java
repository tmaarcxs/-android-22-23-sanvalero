package com.svalero.vinted;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //funcionalidad boton login
        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.btnLogin);

        loginButton.setOnClickListener(v -> {
            //comprobar que los campos no estan vacios
            if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                //mostrar mensaje de error
            } else {
                //comprobar que los datos son correctos
                //si son correctos -> ir a la pantalla de inicio
                //si no son correctos -> mostrar mensaje de error
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    //ir a la pantalla de inicio
                    Toast.makeText(this, "Login correcto", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    //mostrar mensaje de error
                    Toast.makeText(this, "Login incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}