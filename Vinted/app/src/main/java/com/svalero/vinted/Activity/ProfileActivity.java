package com.svalero.vinted.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.svalero.vinted.Model.Usuario;
import com.svalero.vinted.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ArrayList<Usuario> usuario = getIntent().getParcelableArrayListExtra("usuario");
        TextView textViewNombre = findViewById(R.id.nombre);
        TextView textViewEmail = findViewById(R.id.email);
        TextView textViewFecha = findViewById(R.id.fecha_registro);
        TextView textViewVentas = findViewById(R.id.ventas);

        textViewNombre.setText(usuario.get(0).getNombre());
        textViewEmail.setText(usuario.get(0).getEmail());
        textViewFecha.setText(usuario.get(0).getFecha_registro());
        textViewVentas.setText(String.valueOf(usuario.get(0).getVentas()));
    }
}