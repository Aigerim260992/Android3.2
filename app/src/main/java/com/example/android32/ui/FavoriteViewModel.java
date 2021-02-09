package com.example.android32.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.android32.App;
import com.example.android32.data.model.Film;

import java.util.List;

public class FavoriteViewModel extends ViewModel {
    MutableLiveData<List<Film>> mutableLiveDataRoom = new MutableLiveData<>();


    public FavoriteViewModel() {
        App.database.filmDao().getFilm().observeForever(new Observer<List<Film>>() {
            @Override
            public void onChanged(List<Film> films) {
                mutableLiveDataRoom.setValue(films);
            }
        });
    }
}