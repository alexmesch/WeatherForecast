package com.msch.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ForecastListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    WeatherAPI.ApiInterface api;

    String TAG = "WEATHER";
    ArrayList<WeatherDay> forecastList = new ArrayList();

    public void getWeather() {

        Double lat = 54.1867;
        Double lng = 45.1838;
        String units = "metric";
        String key = WeatherAPI.KEY;
        api = WeatherAPI.getClient().create(WeatherAPI.ApiInterface.class);

        Call<WeatherForecast> callForecast = api.getForecast(lat, lng, units, key);
        callForecast.enqueue(new Callback<WeatherForecast>() {
            @Override
            public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
                //Log.e(TAG, "onResponse");
                WeatherForecast forecastData = response.body();

                if (response.isSuccessful()) {
                    for (WeatherDay day : forecastData.getItems()) {
                        if (day.splitDays().get(Calendar.HOUR_OF_DAY) == 9)
                            forecastList.add(day);
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherForecast> call, Throwable t) {
                Log.e(TAG, "onFailure");
                Log.e(TAG, t.toString());
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_list);
        getWeather();

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new forecastAdapter(forecastList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
