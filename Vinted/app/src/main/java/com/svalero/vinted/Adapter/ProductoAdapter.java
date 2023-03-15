package com.svalero.vinted.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.svalero.vinted.Model.Producto;
import com.svalero.vinted.R;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

    private ArrayList<Producto> listaProductos;
    private OnItemClickListenerProducto listener;

    // Constructor y otros métodos del adaptador

    public void setOnItemClickListener(OnItemClickListenerProducto listener) {
        this.listener = listener;
    }

    public ProductoAdapter(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = listaProductos.get(position);

        // Cargar la imagen con Picasso
        Picasso.get().load(producto.getImagen()).into(holder.imageViewProducto);

        holder.textViewNombreProducto.setText(producto.getNombre());
        holder.textViewPrecioProducto.setText(producto.getPrecio()+"€");

    holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(producto);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewProducto;
        private TextView textViewNombreProducto;
        private TextView textViewPrecioProducto;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewProducto = itemView.findViewById(R.id.imageView_producto);
            textViewNombreProducto = itemView.findViewById(R.id.textView_nombre_producto);
            textViewPrecioProducto = itemView.findViewById(R.id.textView_precio_producto);
        }
    }
    public interface OnItemClickListenerProducto {
        void onItemClick(Producto producto);
    }
}

