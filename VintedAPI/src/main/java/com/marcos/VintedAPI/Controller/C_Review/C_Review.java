package com.marcos.VintedAPI.Controller.C_Review;

import com.marcos.VintedAPI.Model.DAO.Review.Review;
import com.marcos.VintedAPI.Model.DAO.Review.ReviewDAO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static java.lang.System.out;
@RestController
@RequestMapping("/reviews")
public class C_Review {
    @GetMapping("/id={id_producto}")
    public String reviewsProducto(@PathVariable int id_producto) {
        ReviewDAO review = new ReviewDAO();
        String SQL_MODIFIER = "WHERE id_producto = " + id_producto;
        ArrayList<Review> reviews = review.getAll(SQL_MODIFIER);
        String reviewListJSON = Review.toArrayJson(reviews);
        out.println(reviewListJSON);
        return reviewListJSON;
    }
    @PostMapping("/insertar")
    public String addReview(@RequestBody Review review) {
        ReviewDAO reviewDAO = new ReviewDAO();
        reviewDAO.insertarReview(review);
        return "Review creada exitosamente.";
    }


}
