package com.marcos.VintedAPI.Model.DAO.Usuario;

import com.marcos.VintedAPI.Model.DAO.DAO;
import com.marcos.VintedAPI.Model.FactoryConection;
import com.marcos.VintedAPI.Model.Motor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.ResultSet;
import java.util.ArrayList;

import static java.lang.System.out;

public class UsuarioDAO implements DAO<Usuario, Integer> {
    ArrayList<Usuario> result = new ArrayList<>();
    private Motor motorSQL;

    public UsuarioDAO() {
        this.motorSQL = FactoryConection.getConnection("mysql");
    }

    public ArrayList<Usuario> getAll(String SQL_MODIFIER) {
        return getUsuarios(SQL_MODIFIER);
    }

    public String SQL_SELECT_BUILDER(String SQL_MODIFIER) {
        return "SELECT * FROM usuario "+SQL_MODIFIER;
    }

    public String SQL_INSERT_BUILDER(String SQL_MODIFIER) {
        return "INSERT INTO usuario (nombre, email, contrasena, fecha_registro) "+SQL_MODIFIER;
    }

    public ArrayList<Usuario> getTop10(String SQL_MODIFIER) {
        return getUsuarios(SQL_MODIFIER);
    }

    private ArrayList<Usuario> getUsuarios(String SQL_MODIFIER) {
        try {
            String SQL_SELECT = SQL_SELECT_BUILDER(SQL_MODIFIER);
            motorSQL.connect();
            ResultSet rs = motorSQL.executeQuery(SQL_SELECT);
            if (rs != null) {
                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt(1));
                    usuario.setNombre(rs.getString(2));
                    usuario.setEmail(rs.getString(3));
                    usuario.setContrasena(rs.getString(4));
                    usuario.setFecha_registro(rs.getString(5));
                    usuario.setVentas(rs.getInt(6));
                    result.add(usuario);
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

    //insertar usuario
    public boolean insertarUsuario(Usuario usuario) {
        boolean exito = false;
        try {
            //insert nombre,email y contrasena
            String SQL_INSERT = SQL_INSERT_BUILDER("VALUES ('"+usuario.getNombre()+"','"+usuario.getEmail()+"','"+usuario.getContrasena() +"',NOW())");
            motorSQL.connect();
            int res = motorSQL.executeUpdate(SQL_INSERT);
            if (res == 1) {
                exito = true;
            }

        }catch (Exception e) {
            out.println("Error");
        }

        return exito;
    }

}
