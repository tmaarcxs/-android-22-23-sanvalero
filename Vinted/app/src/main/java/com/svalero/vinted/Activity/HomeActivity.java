package com.svalero.vinted.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.vinted.Adapter.ProductoAdapter;
import com.svalero.vinted.Controller;
import com.svalero.vinted.Model.Producto;
import com.svalero.vinted.Model.Usuario;
import com.svalero.vinted.R;

import java.io.IOException;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements ProductoAdapter.OnItemClickListenerProducto {
    //onCreate method is called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //guardar el usuario en una variable
        ArrayList<Usuario> usuario = getIntent().getParcelableArrayListExtra("usuario");
        Button btnFiltros = findViewById(R.id.btnFiltro);

        //dar la bienvenida al usuario en el home printeando su nombre
        TextView textViewBienvenida = findViewById(R.id.bienvenidoUsuario);
        textViewBienvenida.setText("Hola " + usuario.get(0).getNombre());

        //Recycler View todos los productos

        RecyclerView recyclerView = findViewById(R.id.recyclerViewProductos);
        Controller api = new Controller();
        try {
            String response = api.callAPI("/productos/");
            if (!response.equals("[]")) {
                ArrayList<Producto> listaProductos = Producto.toArrayList(response);
                ProductoAdapter adapter = new ProductoAdapter(listaProductos);
                adapter.setOnItemClickListener(HomeActivity.this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));

                //onclick busqueda
                EditText campoBusqueda = findViewById(R.id.campo_busqueda);
                // Agrega un Listener al campo de búsqueda
                campoBusqueda.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Crea una nueva lista para los productos filtrados
                        ArrayList<Producto> productosFiltrados = new ArrayList<>();

                        // Recorre la lista original de productos
                        for (Producto producto : listaProductos) {
                            // Verifica si el nombre del producto contiene el texto de búsqueda
                            if (producto.getNombre().toLowerCase().contains(s.toString().toLowerCase())) {
                                // Si el producto cumple con el criterio de búsqueda, agrégalo a la nueva lista
                                productosFiltrados.add(producto);
                            }
                        }

                        // Crea un nuevo adaptador para el RecyclerView, utilizando la nueva lista de productos filtrados
                        ProductoAdapter adaptador = new ProductoAdapter(productosFiltrados);

                        // Establece el nuevo adaptador en el RecyclerView
                        recyclerView.setAdapter(adaptador);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });

            }
        } catch (IOException e) {
            e.printStackTrace();
        }





        //onclick pag filtros
        btnFiltros.setOnClickListener(v -> {
            Intent paginaFiltros = new Intent(this, FiltrosActivity.class);
            startActivity(paginaFiltros);
        });

        Button btnAddProduct = findViewById(R.id.btnAddProduct);

        btnAddProduct.setOnClickListener(v -> {
            Intent paginaAddProduct = new Intent(this, AddProductActivity.class);
            paginaAddProduct.putParcelableArrayListExtra("usuario", usuario);
            startActivity(paginaAddProduct);
        });

        //onclick listener perfil
        Button btnPerfil = findViewById(R.id.btn_perfil);
        btnPerfil.setOnClickListener(v -> {
            Intent paginaPerfil = new Intent(this, ProfileActivity.class);
            paginaPerfil.putParcelableArrayListExtra("usuario", usuario);
            startActivity(paginaPerfil);
        });
    }
    public void onItemClick(Producto producto) {
        Intent intent = new Intent(this, DetalleProductoActivity.class);
        ArrayList<Producto> productoArrayList = new ArrayList<>();
        productoArrayList.add(producto);
        intent.putParcelableArrayListExtra("producto", productoArrayList);
        startActivity(intent);
    }
}
