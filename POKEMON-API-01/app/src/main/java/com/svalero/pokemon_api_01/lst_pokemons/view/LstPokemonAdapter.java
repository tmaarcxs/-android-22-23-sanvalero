package com.svalero.pokemon_api_01.lst_pokemons.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.svalero.pokemon_api_01.R;
import com.svalero.pokemon_api_01.entities.Pokemon;

import java.util.ArrayList;

public class LstPokemonAdapter {
    public ViewHolder(View itemView) {
        super(itemView);

        fotoImageView = itemView.findViewById(R.id.fotoImageView);
        nombreTextView = itemView.findViewById(R.id.nombreTextView);
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> lstPokemon) {
    }

    //view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView fotoImageView;
        private TextView nombreTextView;
    }
}
