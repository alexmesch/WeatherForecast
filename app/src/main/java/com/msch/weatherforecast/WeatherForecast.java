package com.msch.weatherforecast;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherForecast {
    @SerializedName("list")
    private ArrayList<WeatherDay> items;

    public WeatherForecast(ArrayList<WeatherDay> items) {
        this.items = items;
    }

    public ArrayList<WeatherDay> getItems() {
        return items;
    }
}
