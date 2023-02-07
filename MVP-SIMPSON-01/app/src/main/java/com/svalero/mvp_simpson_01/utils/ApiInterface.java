package com.svalero.mvp_simpson_01.utils;

import com.svalero.mvp_simpson_01.entities.Simpson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("quotes")
    Call<ArrayList<Simpson>> getPopularSimpson(@Query("count") int count);
    //Call<ArrayList<Simpson>>  getPopularSimpson(@Path("count") int count);
/*
    @GET("movie/{movie_id}")
    Call<Movie> getMovieDetails(@Path("movie_id") int movieId,
                @Query("api_key") String apiKey, @Query("append_to_response") String credits);
*/
}
