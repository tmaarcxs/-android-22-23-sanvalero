package com.svalero.vinted;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    //onCreate method is called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btnFiltros = findViewById(R.id.btnFiltro);

        //onclikc listener
        btnFiltros.setOnClickListener(v -> {
            Intent paginaFiltros = new Intent(this, FiltrosActivity.class);
            startActivity(paginaFiltros);
        });

        Button btnAddProduct = findViewById(R.id.btnAddProduct);

        btnAddProduct.setOnClickListener(v -> {
            Intent paginaAddProduct = new Intent(this, AddProductActivity.class);
            startActivity(paginaAddProduct);
        });
    }
}
