package com.svalero.vinted.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.svalero.vinted.Adapter.ProductoAdapter;
import com.svalero.vinted.Model.Producto;
import com.svalero.vinted.R;

import java.util.ArrayList;
import java.util.List;

public class ResultadoFiltroActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductoAdapter adapter;
    private ArrayList<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_filtro);

//        // Obtenemos el ID de la categoría del Intent
//        int categoriaId = getIntent().getIntExtra("categoria_id", -1);
//
//        // Filtramos los productos por categoría
//        productos = filtrarProductosPorCategoria(categoriaId);
//
//        // Configuramos el RecyclerView
//        recyclerView = findViewById(R.id.recycler_resultado_filtro);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new ProductoAdapter(productos, this::onProductoClicked);
//        recyclerView.setAdapter(adapter);
//    }
//
//    private ArrayList<Producto> filtrarProductosPorCategoria(int categoriaId) {
//        ArrayList<Producto> productosFiltrados = new ArrayList<>();
//        for (Producto producto : productos) {
//            if (producto.getId() == categoriaId) {
//                productosFiltrados.add(producto);
//            }
//        }
//        return productosFiltrados;
//    }
//
//    public void onProductoClicked(Producto producto) {
//        Intent intent = new Intent(this, DetalleProductoActivity.class);
//        intent.putExtra("producto", producto);
//        startActivity(intent);
    }
}
