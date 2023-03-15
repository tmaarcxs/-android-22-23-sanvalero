package com.marcos.VintedAPI.Model.DAO.Review;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Review {

    private int id;
    private String comentario;
    private int calificacion;
    private int id_usuario;
    private int id_producto;
    private String fecha_creacion;

    public Review() {
    }

    public Review(int id, String comentario, int calificacion, int id_usuario, int id_producto, String fecha_creacion) {
        this.id = id;
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.fecha_creacion = fecha_creacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public static String toArrayJson(ArrayList<Review> reviews) {


        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String answer = gson.toJson(reviews);

        return answer;

    }
}
