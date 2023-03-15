package com.marcos.VintedAPI.Controller.C_Categoria;

import com.marcos.VintedAPI.Model.DAO.Categoria.Categoria;
import com.marcos.VintedAPI.Model.DAO.Categoria.CategoriaDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static java.lang.System.out;
@RestController
@RequestMapping("/categorias")
public class C_Categoria {
    @GetMapping("/")
    public String categorias() {
        CategoriaDAO categoria = new CategoriaDAO();
        String SQL_MODIFIER = "";
        ArrayList<Categoria> categorias = categoria.getAll(SQL_MODIFIER);
        String categoriaListJSON = Categoria.toArrayJson(categorias);
        out.println(categoriaListJSON);
        return categoriaListJSON;
    }

    @GetMapping("/id={id}")
    public String categorias(@PathVariable int id) {
        CategoriaDAO categoria = new CategoriaDAO();
        String SQL_MODIFIER = "WHERE id = " + id;
        ArrayList<Categoria> categorias = categoria.getAll(SQL_MODIFIER);
        String categoriaListJSON = Categoria.toArrayJson(categorias);
        out.println(categoriaListJSON);
        return categoriaListJSON;
    }
}
