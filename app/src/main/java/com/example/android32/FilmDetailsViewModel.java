package com.example.android32;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android32.data.model.Film;
import com.example.android32.data.remote.RetrofitFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmDetailsViewModel extends ViewModel {
   MutableLiveData<Film> filmMutableLiveData = new MutableLiveData<>();

   void getFilm(String id){
       RetrofitFactory.getInstance().getFilm(id).enqueue(new Callback<Film>() {
           @Override
           public void onResponse(Call<Film> call, Response<Film> response) {
               filmMutableLiveData.setValue(response.body());
               Log.d("ololo","getFilm" + response.body());
           }
           @Override
           public void onFailure(Call<Film> call, Throwable t) {
               Log.d("ololo", "onFailure" + t.getMessage());
           }
       });

   }

}