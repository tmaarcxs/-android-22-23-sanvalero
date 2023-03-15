package com.marcos.VintedAPI.Model.DAO.Producto;


import com.marcos.VintedAPI.Model.DAO.DAO;
import com.marcos.VintedAPI.Model.DAO.Review.Review;
import com.marcos.VintedAPI.Model.FactoryConection;
import com.marcos.VintedAPI.Model.Motor;

import java.sql.ResultSet;
import java.util.ArrayList;

import static java.lang.System.out;

public class ProductoDAO implements DAO<Producto, Integer> {
    private static String SQL_INSERT = "INSERT INTO producto VALUES(nombre, descripcion, id_categoria, precio, imagen, id_usuario, estado) VALUES (?,?,?,?,?,?,?)";
    ArrayList<Producto> result = new ArrayList<>();
    //private MotorSQL motorSQL;
    private Motor motorSQL;

    public ProductoDAO() {
        this.motorSQL = FactoryConection.getConnection("mysql");
    }

    public ArrayList<Producto> getAll(String SQL_MODIFIER) {
        return getProductos(SQL_MODIFIER);
    }

    public String SQL_BUILDER(String SQL_MODIFIER) {
        return "SELECT * FROM producto "+SQL_MODIFIER;
    }

    public ArrayList<Producto> getTop10(String SQL_MODIFIER) {

        return getProductos(SQL_MODIFIER);
    }

    private ArrayList<Producto> getProductos(String SQL_MODIFIER) {
        try {
            String SQL_SELECT = SQL_BUILDER(SQL_MODIFIER);
            motorSQL.connect();
            ResultSet rs = motorSQL.executeQuery(SQL_SELECT);
            if (rs != null) {
                while (rs.next()) {
                    Producto Producto = new Producto();
                    Producto.setId(rs.getInt(1));
                    Producto.setNombre(rs.getString(2));
                    Producto.setDescripcion(rs.getString(3));
                    Producto.setId_categoria(rs.getInt(4));
                    Producto.setPrecio(rs.getString(5));
                    Producto.setImagen(rs.getString(6));
                    Producto.setId_usuario(rs.getInt(7));
                    Producto.setEstado(rs.getBoolean(8));
                    result.add(Producto);
                }
            } else {
                out.println("No hay datos");
            }
            motorSQL.disconnect();
        } catch (Exception e) {
            out.println("Error");
        }
        return result;
    }
    public void insertarProducto(Producto producto) {
        try {
            SQL_INSERT += "VALUES ('" + producto.getNombre() + "','" + producto.getDescripcion() + "','" + producto.getId_categoria() + "','" + producto.getPrecio() + "','" + producto.getImagen() + "','" + producto.getId_usuario() + "','" + producto.getEstado() + "')";
            motorSQL.connect();
            motorSQL.executeUpdate(SQL_INSERT);
        }catch (Exception e) {
            out.println("Error");
        }
    }

}
