package com.example.skill5;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersonajes extends RecyclerView.Adapter<AdaptadorPersonajes.ViewHolderPersonajes> {

    ArrayList<PersonajeVo> listaPersonajes;

    public AdaptadorPersonajes(ArrayList<PersonajeVo> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @Override
    public ViewHolderPersonajes onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iem_list_personajes, null, false);
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolderPersonajes holder, int i) {
            holder.nombre.setText(listaPersonajes.get(i).getNombre());
            holder.descripcion.setText(listaPersonajes.get(i).getDescripcion());
            holder.foto.setImageResource(listaPersonajes.get(i).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public class ViewHolderPersonajes extends RecyclerView.ViewHolder{

        TextView nombre, descripcion;
        ImageView foto;

        public ViewHolderPersonajes(@NonNull @androidx.annotation.NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.idNombre);
            descripcion = (TextView) itemView.findViewById(R.id.idInfo);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}

