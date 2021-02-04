package com.example.android32;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android32.data.model.Film;
import com.example.android32.databinding.FilmDetailsFragmentBinding;

public class FilmDetails extends Fragment {

    private FilmDetailsViewModel mViewModel;
    FilmDetailsFragmentBinding binding;
    String id;

    public static FilmDetails newInstance() {
        return new FilmDetails();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            id = getArguments().getString("filmId");
        }else {
            Log.d("ololo", "Oh no!");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FilmDetailsFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FilmDetailsViewModel.class);
        mViewModel.getFilm(id);
        mViewModel.filmMutableLiveData.observe(getViewLifecycleOwner(), new Observer<Film>() {
            @Override
            public void onChanged(Film film) {
                binding.titleOneFilm.setText("Title:  "+ film.getTitle());
                binding.description.setText("Description:  "+ film.getDescription());
                binding.director.setText("Director:  "+ film.getDirector());
            }
        });

    }

}