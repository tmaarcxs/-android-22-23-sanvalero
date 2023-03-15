package com.svalero.vinted.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Producto implements Parcelable {
    @SerializedName("id")
    private int id;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("descripcion")
    private String descripcion;

    @SerializedName("id_categoria")
    private int id_categoria;

    @SerializedName("precio")
    private String precio;

    @SerializedName("imagen")
    private String imagen;

    @SerializedName("id_usuario")
    private int id_usuario;

    @SerializedName("estado")
    private boolean estado;

    public Producto() {
    }

    public Producto(int id, String nombre, String descripcion, int id_categoria, String precio, String imagen, int id_usuario, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_categoria = id_categoria;
        this.precio = precio;
        this.imagen = imagen;
        this.id_usuario = id_usuario;
        this.estado = estado;
    }

    protected Producto(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        descripcion = in.readString();
        id_categoria = in.readInt();
        precio = in.readString();
        imagen = in.readString();
        id_usuario = in.readInt();
        estado = in.readByte() != 0;
    }

    public static final Creator<Producto> CREATOR = new Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public static String toArrayJson(ArrayList<Producto> productos) {

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String answer = gson.toJson(productos);

        return answer;

    }

    //to ArrayList from JSON
    public static ArrayList<Producto> toArrayList(String json) {

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        Producto[] productos = gson.fromJson(json, Producto[].class);

        ArrayList<Producto> lista = new ArrayList<Producto>();
        for (Producto producto : productos) {
            lista.add(producto);
        }

        return lista;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeString(descripcion);
        dest.writeInt(id_categoria);
        dest.writeString(precio);
        dest.writeString(imagen);
        dest.writeInt(id_usuario);
        dest.writeByte((byte) (estado ? 1 : 0));
    }
}
