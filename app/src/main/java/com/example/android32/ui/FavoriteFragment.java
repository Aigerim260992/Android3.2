package com.example.android32.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android32.App;
import com.example.android32.R;
import com.example.android32.adapter.RoomAdapter;
import com.example.android32.data.model.Film;
import com.example.android32.databinding.FavoriteFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {

    private FavoriteViewModel mViewModel;

    FavoriteFragmentBinding binding;
    RoomAdapter roomAdapter;
    List<Film> filmList = new ArrayList<>();


    public static FavoriteFragment newInstance() {
        return new FavoriteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FavoriteFragmentBinding.inflate(inflater);
        roomAdapter = new RoomAdapter();
        binding.recyclerViewRoom.setAdapter(roomAdapter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FavoriteViewModel.class);

        App.database.filmDao().getFilm().observe(requireActivity(), new Observer<List<Film>>() {
            @Override
            public void onChanged(List<Film> films) {
                roomAdapter.addList(films);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FavoriteViewModel.class);




        mViewModel.mutableLiveDataRoom.observe(getViewLifecycleOwner(), new Observer<List<Film>>() {
            @Override
            public void onChanged(List<Film> films) {
                films.addAll(films);
                roomAdapter.notifyDataSetChanged();
            }
        });
    }
}