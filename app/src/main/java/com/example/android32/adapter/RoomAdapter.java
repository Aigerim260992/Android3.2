package com.example.android32.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android32.data.model.Film;
import com.example.android32.databinding.ItemRoomFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {

    List<Film> favoriteList = new ArrayList<>();

    public void addList(List<Film> filmList) {
        this.favoriteList = filmList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RoomViewHolder(ItemRoomFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        holder.onBind(favoriteList.get(position));

    }

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder{

       private ItemRoomFilmBinding binding;


        public RoomViewHolder(@NonNull ItemRoomFilmBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

         void onBind(Film film){
            binding.titleFilm.setText(film.getTitle());
         }
    }
}
