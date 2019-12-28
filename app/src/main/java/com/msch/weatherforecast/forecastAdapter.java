package com.msch.weatherforecast;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class forecastAdapter extends RecyclerView.Adapter<forecastAdapter.ForecastViewHolder> {
    private ArrayList<forecast_item> mForecastList;

    public static class ForecastViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvDay;
        public TextView mTvDate;
        public TextView mTvTemp;

        public ForecastViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvDay = itemView.findViewById(R.id.tvDay);
            mTvDate = itemView.findViewById(R.id.tvDate);
            mTvTemp = itemView.findViewById(R.id.tvTemperature);
        }
    }
    public forecastAdapter(ArrayList<forecast_item> forecastList) {
        mForecastList = forecastList;
    }

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_list, parent, false);
        ForecastViewHolder fvh = new ForecastViewHolder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        forecast_item currentItem = mForecastList.get(position);

        holder.mTvDay.setText(currentItem.getDay());
        holder.mTvDate.setText(currentItem.getDate());
        holder.mTvTemp.setText(currentItem.getTemp());

    }

    @Override
    public int getItemCount() {
        return mForecastList.size();
    }
}
