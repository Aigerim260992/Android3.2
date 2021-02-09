package com.example.android32.data.local;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.android32.data.model.Film;

import java.util.List;

@Dao
public interface FilmDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFilm(Film film);

    @Delete
    void deleteFilm(Film film);

    @Update
    void updateFilm(Film film);

    @Query("SELECT * FROM films")
    LiveData<List<Film>> getFilm();


}
