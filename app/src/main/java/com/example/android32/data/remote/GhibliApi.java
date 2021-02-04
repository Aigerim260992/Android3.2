package com.example.android32.data.remote;

import com.example.android32.data.model.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliApi {

    @GET(Endpoints.GET_FILMS)
    Call<List<Film>> getFilms();

    @GET(Endpoints.GET_FILM)
    Call<Film> getFilm(
            @Path("id") String id
    );

}
