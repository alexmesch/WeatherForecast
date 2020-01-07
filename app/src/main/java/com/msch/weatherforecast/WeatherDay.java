package com.msch.weatherforecast;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WeatherDay {
    public class WeatherTemp {
        Double temp;
        Double temp_min;
        Double temp_max;
    }


    @SerializedName("main")
    private WeatherTemp temp;

    @SerializedName("name")
    private String city;

    @SerializedName("dt")
    private long timestamp;

    public WeatherDay(WeatherTemp temp) {
        this.temp = temp;
    }

    public String getDate() {
        Calendar date = Calendar.getInstance();
        String strdate = null;
        SimpleDateFormat sdf = new SimpleDateFormat();
        date.setTimeInMillis(timestamp * 1000);
        strdate = sdf.format(date.getTime());
        return strdate;
    }
    public Calendar splitDays() {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(timestamp * 1000);
        return date;
    }

    public String getTemp() {
        return String.valueOf(temp.temp);
    }

    public String getTempMin() {
        return String.valueOf(temp.temp_min);
    }

    public String getTempMax() {
        return String.valueOf(temp.temp_max);
    }

    public String getTempInteger() {
        return String.valueOf(temp.temp.intValue());
    }

    public String getTempWithDegree() {
        return String.valueOf(temp.temp.intValue()) + "\u00B0";
    }

    public String getCity() {
        return city;
    }
}