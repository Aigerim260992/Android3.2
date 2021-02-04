package com.example.android32.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android32.data.model.Film;
import com.example.android32.databinding.ItemFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    List<Film> filmsList = new ArrayList<>();
    Listener listener;

    public FilmAdapter(List<Film> filmsList, Listener listener) {
        this.filmsList = filmsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.onBind(filmsList.get(position));

    }

    @Override
    public int getItemCount() {
        return filmsList.size();
    }

    public Film getItem(int position) {
        return filmsList.get(position);
    }

    public class FilmViewHolder extends RecyclerView.ViewHolder {

        private final ItemFilmBinding binding;

        public FilmViewHolder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.titleFilm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onTitleClick(getAdapterPosition());
                }
            });
        }

        void onBind(Film film) {
            binding.titleFilm.setText(film.getTitle());
        }
    }

    public interface Listener {
        void onTitleClick(int position);
    }


}
