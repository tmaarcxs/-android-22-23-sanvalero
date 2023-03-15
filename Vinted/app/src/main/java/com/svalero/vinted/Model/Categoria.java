package com.svalero.vinted.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.versionedparcelable.VersionedParcel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Categoria implements Parcelable {
    @SerializedName("id")
    private int id;

    @SerializedName("nombre")
    private String nombre;

    public Categoria() {
    }

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    protected Categoria(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<Categoria> CREATOR = new Creator<Categoria>() {
        @Override
        public Categoria createFromParcel(Parcel in) {
            return new Categoria(in);
        }

        @Override
        public Categoria[] newArray(int size) {
            return new Categoria[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static String toArrayJson(ArrayList<Categoria> categorias) {


        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String answer = gson.toJson(categorias);

        return answer;

    }

    public static ArrayList<Categoria> toArrayList(String json) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        Categoria[] categorias = gson.fromJson(json, Categoria[].class);

        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        for (Categoria categoria : categorias) {
            listaCategorias.add(categoria);
        }

        return listaCategorias;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel( Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
    }
}