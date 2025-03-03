package com.b0nggo.weatherapp;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.ui.AppBarConfiguration;

import com.b0nggo.weatherapp.databinding.ActivityWeatherDisplayBinding;

public class WeatherDisplay extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityWeatherDisplayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.weather_display_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setContentView(R.layout.activity_weather_display);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<HourData> hourDataList = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            String hour = String.format("%02d:00", i);
            String temp = (20 + i % 5) + "°C";
            String rain = (i % 10) * 10 + "%";
            hourDataList.add(new HourData(hour, temp, rain));
        }
        HourAdapter adapter = new HourAdapter(hourDataList);
        recyclerView.setAdapter(adapter);
    }
}