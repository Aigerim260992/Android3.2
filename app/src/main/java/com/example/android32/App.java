package com.example.android32;

import android.app.Application;

import androidx.room.Room;

import com.example.android32.data.local.FilmDatabase;

public class App extends Application  {

    public  static FilmDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(
                getApplicationContext(),
                FilmDatabase.class, "filmRoom")
                .allowMainThreadQueries()
                .build();
    }
}
