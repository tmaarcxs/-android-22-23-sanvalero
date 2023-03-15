package com.svalero.vinted.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.svalero.vinted.Controller;
import com.svalero.vinted.R;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button btnRegister = findViewById(R.id.btnRegister);
        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        TextView email = findViewById(R.id.email);

        //onlick listener
        btnRegister.setOnClickListener(v -> {
            Controller api = new Controller();
            try {
                String response = api.callAPIPostRegister("/usuarios/insertar", username.getText().toString(), email.getText().toString(), password.getText().toString());
                if (response.equals("1")){
                    Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Error al registrar", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}