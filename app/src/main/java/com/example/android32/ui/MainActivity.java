package com.example.android32.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.android32.R;
import com.example.android32.data.model.Film;
import com.example.android32.data.remote.GhibliApi;
import com.example.android32.data.remote.RetrofitFactory;
import com.example.android32.databinding.ActivityMainBinding;
;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFilm();
    }

    private void loadFilm() {

        RetrofitFactory
                .getInstance().getFilm("ebbb6b7c-945c-41ee-a792-de0e43191bd8")
                .enqueue(new Callback<Film>() {
                    @Override
                    public void onResponse(Call<Film> call, Response<Film> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Log.d("ololo", response.body().getTitle());
                        }
                    }

                    @Override
                    public void onFailure(Call<Film> call, Throwable t) {
                        Log.d("tag", t.getLocalizedMessage());

                    }
                });
    }
}