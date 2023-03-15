package com.marcos.VintedAPI.Model.DAO.Categoria;

import com.marcos.VintedAPI.Model.DAO.DAO;
import com.marcos.VintedAPI.Model.FactoryConection;
import com.marcos.VintedAPI.Model.Motor;

import java.sql.ResultSet;
import java.util.ArrayList;

import static java.lang.System.out;

public class CategoriaDAO implements DAO<Categoria,Integer> {


    ArrayList<Categoria> result = new ArrayList<>();
    //private MotorSQL motorSQL;
    private Motor motorSQL;

    public CategoriaDAO() {
        this.motorSQL = FactoryConection.getConnection("mysql");
    }
    public ArrayList<Categoria> getAll(String SQL_MODIFIER) {
        return getCategorias(SQL_MODIFIER);
    }

    public String SQL_BUILDER(String SQL_MODIFIER) {
        return "SELECT * FROM categoria "+SQL_MODIFIER;
    }

    private ArrayList<Categoria> getCategorias(String SQL_MODIFIER) {
        try {
            String SQL_SELECT = SQL_BUILDER(SQL_MODIFIER);
            motorSQL.connect();
            ResultSet rs = motorSQL.executeQuery(SQL_SELECT);
            if (rs != null) {
                while (rs.next()) {
                    Categoria Categoria = new Categoria();
                    Categoria.setId(rs.getInt(1));
                    Categoria.setNombre(rs.getString(2));
                    result.add(Categoria);
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
}
