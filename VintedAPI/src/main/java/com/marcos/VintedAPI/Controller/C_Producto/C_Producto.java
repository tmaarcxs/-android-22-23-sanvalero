package com.marcos.VintedAPI.Controller.C_Producto;

import com.marcos.VintedAPI.Model.DAO.Producto.Producto;
import com.marcos.VintedAPI.Model.DAO.Producto.ProductoDAO;
import com.marcos.VintedAPI.Model.DAO.Review.Review;
import com.marcos.VintedAPI.Model.DAO.Review.ReviewDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static java.lang.System.out;

@RestController
@RequestMapping("/productos")
public class C_Producto {
    @GetMapping("/")
    public String productosAll() {
        ProductoDAO producto = new ProductoDAO();
        String SQL_MODIFIER = "where estado = 1";
        ArrayList<Producto> productos = producto.getAll(SQL_MODIFIER);
        String categoriaListJSON = Producto.toArrayJson(productos);
        out.println(categoriaListJSON);
        return categoriaListJSON;
    }

    @GetMapping("/id={id}")
    public String productos(@PathVariable int id) {
        ProductoDAO producto = new ProductoDAO();
        String SQL_MODIFIER = "WHERE id = " + id;
        ArrayList<Producto> productos = producto.getAll(SQL_MODIFIER);
        String categoriaListJSON = Producto.toArrayJson(productos);
        out.println(categoriaListJSON);
        return categoriaListJSON;
    }

    @GetMapping("/top10")
    public String productosTop10() {
        ProductoDAO producto = new ProductoDAO();
        String SQL_MODIFIER = "ORDER BY id DESC LIMIT 10";
        ArrayList<Producto> productos = producto.getTop10(SQL_MODIFIER);
        String categoriaListJSON = Producto.toArrayJson(productos);
        out.println(categoriaListJSON);
        return categoriaListJSON;
    }

    @PostMapping("/insertar")
    public String addProducto(@RequestBody Producto producto) {
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.insertarProducto(producto);
        return "Producto creado exitosamente.";
    }



}
