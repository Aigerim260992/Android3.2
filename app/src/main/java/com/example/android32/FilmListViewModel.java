package com.example.android32;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android32.data.model.Film;
import com.example.android32.data.remote.RetrofitFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmListViewModel extends ViewModel {

    MutableLiveData<List<Film>> listMutableLiveData = new MutableLiveData<>();

    public void getFilms(){
        RetrofitFactory.getInstance().getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                listMutableLiveData.setValue(response.body());
                Log.d("ololo", "getFilms" + response.body());
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                Log.d("ololo", "onFailure" +t.getMessage());

            }
        });

    }


}