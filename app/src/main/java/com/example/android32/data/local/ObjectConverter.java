package com.example.android32.data.local;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

public class ObjectConverter {

    @TypeConverter
    public String fromObjectToString(Object object) {
        return new Gson().toJson(object);
    }
    @TypeConverter
    public Object fromStringToObject(String string) {
        return new Gson().fromJson(string, Object.class);
    }
}
