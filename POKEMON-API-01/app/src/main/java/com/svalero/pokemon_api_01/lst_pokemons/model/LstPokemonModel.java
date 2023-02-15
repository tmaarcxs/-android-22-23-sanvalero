package com.svalero.pokemon_api_01.lst_pokemons.model;

import com.svalero.pokemon_api_01.entities.Pokemon;
import com.svalero.pokemon_api_01.entities.PokemonRespuesta;
import com.svalero.pokemon_api_01.lst_pokemons.LstPokemonContract;
import com.svalero.pokemon_api_01.utils.ApiClient;
import com.svalero.pokemon_api_01.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstPokemonModel implements LstPokemonContract.Model {
    @Override
    public void lstPokemonWS(Pokemon pokemon, OnLstPokemonListener onLstPokemonListener) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<PokemonRespuesta> call = apiService.getPokemons(10, 10);
        call.enqueue(new Callback<PokemonRespuesta>() {
                         @Override
                         public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                             PokemonRespuesta pokemonRespuesta = response.body();
                             ArrayList<Pokemon> lstPokemon = pokemonRespuesta.getResults();
                                onLstPokemonListener.onSuccess(lstPokemon);
                         }

                         @Override
                         public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                             onLstPokemonListener.onFailure(t.getMessage());
                         }
                     }
        );
    }
}
