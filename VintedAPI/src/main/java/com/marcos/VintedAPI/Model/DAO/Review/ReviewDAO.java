package com.marcos.VintedAPI.Model.DAO.Review;

import com.marcos.VintedAPI.Model.DAO.DAO;
import com.marcos.VintedAPI.Model.DAO.Usuario.Usuario;
import com.marcos.VintedAPI.Model.FactoryConection;
import com.marcos.VintedAPI.Model.Motor;

import java.sql.ResultSet;
import java.util.ArrayList;

import static java.lang.System.out;

public class ReviewDAO implements DAO<Review,Integer> {
    ArrayList<Review> reviews = new ArrayList<>();
    private Motor motorSQL;

    public ReviewDAO() {
        this.motorSQL = FactoryConection.getConnection("mysql");
    }
    public ArrayList<Review> getAll(String SQL_MODIFIER) {
        return getReviews(SQL_MODIFIER);
    }

    public String SQL_BUILDER(String SQL_MODIFIER) {
        return "SELECT * FROM review "+SQL_MODIFIER;
    }

    public String SQL_INSERT_BUILDER(String SQL_MODIFIER) {
        return "INSERT INTO review (comentario, calificacion, id_usuario, id_producto, fecha_creacion) "+SQL_MODIFIER;
    }


    private ArrayList<Review> getReviews(String SQL_MODIFIER) {
        try {
           String SQL_SELECT = SQL_BUILDER(SQL_MODIFIER);
            motorSQL.connect();
            ResultSet rs = motorSQL.executeQuery(SQL_SELECT);
            if (rs != null) {
                while (rs.next()) {
                    Review review = new Review();
                    review.setId(rs.getInt(1));
                    review.setComentario(rs.getString(2));
                    review.setCalificacion(rs.getInt(3));
                    review.setId_usuario(rs.getInt(4));
                    review.setId_producto(rs.getInt(5));
                    review.setFecha_creacion(rs.getString(6));
                    reviews.add(review);
                }
            } else {
                out.println("No hay datos");
            }
            motorSQL.disconnect();
        } catch (Exception e) {
            out.println("Error");
        }
        return reviews;
    }

    public void insertarReview(Review review) {
        try {
            String SQL_INSERT = SQL_INSERT_BUILDER("VALUES ('"+review.getComentario()+"',"+review.getCalificacion()+","+review.getId_usuario()+","+review.getId_producto()+",'"+review.getFecha_creacion()+"')");
            motorSQL.connect();
            motorSQL.executeUpdate(SQL_INSERT);
        }catch (Exception e) {
            out.println("Error");
        }
    }
}
