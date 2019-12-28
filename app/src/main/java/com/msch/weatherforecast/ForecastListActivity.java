package com.msch.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ForecastListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_list);

        ArrayList<forecast_item> forecastList = new ArrayList();
        forecastList.add(new forecast_item("Понедельник","22.02.2020","-14C°"));
        forecastList.add(new forecast_item("Вторник","23.02.2020","-13C°"));
        forecastList.add(new forecast_item("Среда","24.02.2020","-15C°"));
        forecastList.add(new forecast_item("Четверг","25.02.2020","-20C°"));
        forecastList.add(new forecast_item("Пятница","26.02.2020","-12C°"));
        forecastList.add(new forecast_item("Суббота","27.02.2020","-17C°"));
        forecastList.add(new forecast_item("Воскресенье","28.02.2020","-15C°"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this );
        mAdapter = new forecastAdapter(forecastList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
