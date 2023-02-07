package com.svalero.mvp_simpson_01.entities;

import androidx.core.app.ServiceCompat;

import com.google.gson.annotations.SerializedName;

public class Simpson {
    //"quote": "Gah, stupid sexy Flanders!",
    //"character": "Homer Simpson",
    //"image": "https://cdn.glitch.com/3c3ffadc-3406-4440-bb95-d40ec8fcde72%2FHomerSimpson.png?1497567511939",
    //"characterDirection": "Right"

    @SerializedName("quote")
    private String quote;

    @SerializedName("character")
    private String character;

    @SerializedName("image")
    private String image;

    @SerializedName("characterDirection")
    private String characterDirection;

    @Override
    public String toString() {
        return "Simpson{" +
                "quote='" + quote + '\'' +
                ", character='" + character + '\'' +
                ", image='" + image + '\'' +
                ", characterDirection='" + characterDirection + '\'' +
                '}';
    }
}
