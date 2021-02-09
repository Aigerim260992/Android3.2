package com.example.android32.data.local;

import androidx.annotation.Nullable;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ListConverter {

    @TypeConverter
    public static String toRaw(@Nullable List<String> filmList) {
        if (filmList == null) return null;
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>() {
        }.getType();
        return gson.toJson(filmList, type);
    }
    @TypeConverter
    public static List<String> toString(@Nullable String raw) {
        if (raw == null) return null;
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>() {
        }.getType();
        return gson.fromJson(raw, type);
    }
}
