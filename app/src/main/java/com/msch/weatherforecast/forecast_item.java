package com.msch.weatherforecast;

import java.util.Date;

public class forecast_item {
    private String mDay;
    private String mDate;
    private String mTemp;

    public forecast_item(String day, String date, String temp) {
        mDay = day;
        mDate = date;
        mTemp = temp;
    }

    public String getDay() {
        return mDay;
    }
    public String getDate() {
        return mDate;
    }
    public String getTemp() {
        return mTemp;
    }
}
