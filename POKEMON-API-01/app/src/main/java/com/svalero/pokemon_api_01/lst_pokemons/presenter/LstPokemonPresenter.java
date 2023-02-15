package com.svalero.pokemon_api_01.lst_pokemons.presenter;

import com.svalero.pokemon_api_01.entities.Pokemon;
import com.svalero.pokemon_api_01.lst_pokemons.LstPokemonContract;
import com.svalero.pokemon_api_01.lst_pokemons.model.LstPokemonModel;

import java.util.ArrayList;

public class LstPokemonPresenter implements LstPokemonContract.Presenter {

    private LstPokemonContract.View view;
    private LstPokemonModel model;

    public LstPokemonPresenter(LstPokemonContract.View view) {
        this.view = view;
        model = new LstPokemonModel();
    }

    @Override
    public void lstpokemon(Pokemon pokemon) {
        LstPokemonModel.lstPokemonWS(null, new LstPokemonContract.Model.OnLstPokemonListener() {
            @Override
            public void onSuccess(ArrayList<Pokemon> lstPokemon) {
                view.successLstpokemon(lstPokemon);
            }else{
                view.failureLstPokemon("Error");
            }

            @Override
            public void onFailure(String error) {
                view.failureLstPokemon(error);
            }
        });
    }
}
