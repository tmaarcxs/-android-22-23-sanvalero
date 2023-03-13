package com.svalero.vinted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class FiltrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtros);

        Button btnFiltros = findViewById(R.id.btnFiltro);

        //onclikc listener
        btnFiltros.setOnClickListener(v -> {
            Intent paginaFiltros = new Intent(this, HomeActivity.class);
            startActivity(paginaFiltros);
        });

    }
}