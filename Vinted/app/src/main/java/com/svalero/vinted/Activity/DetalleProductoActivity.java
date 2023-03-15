package com.svalero.vinted.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.svalero.vinted.Model.Producto;
import com.svalero.vinted.R;

import java.util.ArrayList;

public class DetalleProductoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        ArrayList<Producto> producto = getIntent().getParcelableArrayListExtra("producto");
        TextView textViewNombre = findViewById(R.id.tv_nombre_producto);
        TextView textViewPrecio = findViewById(R.id.tv_precio_producto);
        TextView textViewDescripcion = findViewById(R.id.tv_descripcion_producto);
        ImageView imageViewProducto = findViewById(R.id.iv_producto);

        textViewNombre.setText(producto.get(0).getNombre());
        textViewPrecio.setText(String.valueOf(producto.get(0).getPrecio()));
        textViewDescripcion.setText(producto.get(0).getDescripcion());
        Picasso.get().load(producto.get(0).getImagen()).into(imageViewProducto);
    }
}