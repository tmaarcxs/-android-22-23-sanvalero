package com.svalero.vinted.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.vinted.Model.Categoria;
import com.svalero.vinted.R;

import java.util.List;

public class CategoriasAdapter extends RecyclerView.Adapter<CategoriasAdapter.ViewHolder> {
    private List<Categoria> categorias;
    private CategoriasAdapter.OnItemClickListener listener;

    public CategoriasAdapter(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        holder.textNombre.setText(categoria.getNombre());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(categoria);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Categoria categoria);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textNombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNombre = itemView.findViewById(R.id.text_categoria_nombre);
        }
    }
}
