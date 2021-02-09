package com.example.android32.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android32.App;
import com.example.android32.R;
import com.example.android32.adapter.FilmAdapter;
import com.example.android32.data.model.Film;
import com.example.android32.databinding.FilmListFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class FilmList extends Fragment implements FilmAdapter.Listener {


   private FilmListFragmentBinding binding;
   private FilmListViewModel mViewModel;
   FilmAdapter filmAdapter;
   List<Film> filmList = new ArrayList<>();
   NavController navController;

    public static FilmList newInstance() {
        return new FilmList();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FilmListFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        filmAdapter = new FilmAdapter(filmList, this);
        binding.rvFilmList.setAdapter(filmAdapter);

        binding.btnFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_filmList_to_favoriteFragment);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FilmListViewModel.class);
        mViewModel.getFilms();
        mViewModel.listMutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<Film>>() {
            @Override
            public void onChanged(List<Film> films) {
                if(films !=null){
                filmList.addAll(films);
                filmAdapter.notifyDataSetChanged();
            }}
        });
    }
    @Override
    public void onTitleClick(Film film) {
        Bundle b = new Bundle();
        b.putString("filmId", film.getId());
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.action_filmList_to_filmDetails, b);

    }

    @Override
    public void onSaveClick(int pos) {
        App.database.filmDao().insertFilm(filmAdapter.getItem(pos));
    }
}