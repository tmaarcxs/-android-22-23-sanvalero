package com.marcos.VintedAPI.Controller.C_Usuario;

import com.google.gson.Gson;
import com.marcos.VintedAPI.Model.DAO.Usuario.Usuario;
import com.marcos.VintedAPI.Model.DAO.Usuario.UsuarioDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static java.lang.System.out;

@RestController
@RequestMapping("/usuarios")
public class C_Usuario {
    @GetMapping("/")
    public String usuarios() {
        UsuarioDAO usuario = new UsuarioDAO();
        String SQL_MODIFIER = "";
        ArrayList<Usuario> usuarios = usuario.getAll(SQL_MODIFIER);
        String usuarioListJSON = Usuario.toArrayJson(usuarios);
        out.println(usuarioListJSON);
        return usuarioListJSON;
    }

    @GetMapping("/top10")
    public String usuariosTop10() {
        UsuarioDAO usuario = new UsuarioDAO();
        String SQL_MODIFIER = "ORDER BY id ASC LIMIT 10";
        ArrayList<Usuario> usuarios = usuario.getTop10(SQL_MODIFIER);
        String usuarioListJSON = Usuario.toArrayJson(usuarios);
        out.println(usuarioListJSON);
        return usuarioListJSON;
    }

    @GetMapping("/id={id}")
    public String usuarios(@PathVariable int id) {
        UsuarioDAO usuario = new UsuarioDAO();
        String SQL_MODIFIER = "WHERE id = " + id;
        ArrayList<Usuario> usuarios = usuario.getAll(SQL_MODIFIER);
        String usuarioListJSON = Usuario.toArrayJson(usuarios);
        out.println(usuarioListJSON);
        return usuarioListJSON;
    }

    @GetMapping("/nombre={nombre}")
    public String usuarios(@PathVariable String nombre) {
        UsuarioDAO usuario = new UsuarioDAO();
        String SQL_MODIFIER = "WHERE nombre = '" + nombre + "'";
        ArrayList<Usuario> usuarios = usuario.getAll(SQL_MODIFIER);
        String usuarioListJSON = Usuario.toArrayJson(usuarios);
        out.println(usuarioListJSON);
        return usuarioListJSON;
    }

    //insertar usuario
    @PostMapping("/insertar")
    public ResponseEntity<String> insertarUsuario(@RequestBody String usuarioJSON) {
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(usuarioJSON, Usuario.class);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (usuarioDAO.insertarUsuario(usuario) == true){
            return ResponseEntity.ok("1");
        } else {
            return ResponseEntity.ok("0");
        }

    }

}
