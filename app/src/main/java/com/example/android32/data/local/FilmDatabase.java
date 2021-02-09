package com.example.android32.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.android32.data.model.Film;

@Database(entities = {Film. class}, version = 1, exportSchema = false)
public abstract class FilmDatabase extends RoomDatabase {
    public abstract FilmDao filmDao();
}
