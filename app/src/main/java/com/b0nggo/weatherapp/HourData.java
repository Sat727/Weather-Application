package com.b0nggo.weatherapp;

public class HourData {
    private String hour;
    private String temperature;
    private String rainChance;

    public HourData(String hour, String temperature, String rainChance) {
        this.hour = hour;
        this.temperature = temperature;
        this.rainChance = rainChance;
    }

    public String getHour() {
        return hour;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getRainChance() {
        return rainChance;
    }
}