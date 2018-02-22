package com.example.selema.my.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by selema on 1/30/18.
 */


public interface ApiInterface {
    @GET("offers")
    Call<MovieResponse> getTopRatedMovies();

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}