package com.svalero.pokemon_api_01.lst_pokemons;

import com.svalero.pokemon_api_01.entities.Pokemon;

import java.util.ArrayList;

public interface LstPokemonContract {
    interface View {
        void successLstpokemon(ArrayList<Pokemon> lstPokemon);

        void failureLstPokemon(String error);
    }

    interface Presenter {
        //caso de uso
        void lstpokemon(Pokemon pokemon);
    }

    interface Model {
        void lstPokemonWS(Pokemon pokemon, OnLstPokemonListener onLstPokemonListener);

        interface OnLstPokemonListener {
            void onSuccess(ArrayList<Pokemon> lstPokemon);

            void onFailure(String error);
        }
    }
}
