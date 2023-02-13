package com.svalero.pokemon_api_01.entities;


import com.google.gson.annotations.SerializedName;

public class Pokemon {
    //mapeo de los atributos de la clase Pokemon
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
