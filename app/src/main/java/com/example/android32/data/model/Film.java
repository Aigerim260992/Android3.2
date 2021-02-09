package com.example.android32.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.android32.data.local.ListConverter;
import com.example.android32.data.local.ObjectConverter;
import com.google.gson.annotations.SerializedName;

import java.util.List;


@Entity(tableName = "films")
public class Film {
    @PrimaryKey
    @SerializedName("id")
    @NonNull
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("director")
    private String director;

    @SerializedName("producer")
    private String producer;

    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("rt_score")
    private String rtScore;
    @SerializedName("people")
    @TypeConverters({ListConverter.class})
    private List<String> people = null;
    @SerializedName("species")
    @TypeConverters({ListConverter.class})
    private List<String> species = null;
    @SerializedName("locations")
    @TypeConverters({ListConverter.class})
    private List<String> locations = null;
    @SerializedName("vehicles")
    @TypeConverters({ListConverter.class})
    private List<String> vehicles = null;
    @SerializedName("url")

    private String url;
    @SerializedName("length")
    @TypeConverters({ObjectConverter.class})
    private Object length;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRtScore() {
        return rtScore;
    }

    public void setRtScore(String rtScore) {
        this.rtScore = rtScore;
    }

    public List<String> getPeople() {
        return people;
    }


    public void setPeople(List<String> people) {
        this.people = people;
    }


    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getLength() {
        return length;
    }

    public void setLength(Object length) {
        this.length = length;
    }

}
