package com.svalero.vinted.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Usuario implements Parcelable {
    @SerializedName("id")
    private int id;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("email")
    private String email;

    @SerializedName("contrasena")
    private String contrasena;

    @SerializedName("fecha_registro")
    private String fecha_registro;

    @SerializedName("ventas")
    private int ventas;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String email, String contrasena, String fecha_registro, int ventas) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.fecha_registro = fecha_registro;
        this.ventas = ventas;
    }

    protected Usuario(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        email = in.readString();
        contrasena = in.readString();
        fecha_registro = in.readString();
        ventas = in.readInt();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public static String toArrayJson(ArrayList<Usuario> usuarios) {


        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String answer = gson.toJson(usuarios);

        return answer;

    }

    public static ArrayList<Usuario> toArrayList(String json) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        Usuario[] usuarios = gson.fromJson(json, Usuario[].class);

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            listaUsuarios.add(usuario);
        }

        return listaUsuarios;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeString(email);
        dest.writeString(contrasena);
        dest.writeString(fecha_registro);
        dest.writeInt(ventas);
    }
}
