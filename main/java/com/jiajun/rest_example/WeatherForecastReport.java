package com.jiajun.rest_example;

public class WeatherForecastReport {
    private int id, air_pressure, humidity, predictability;

    public void setId(int id) {
        this.id = id;
    }

    public void setAir_pressure(int air_pressure) {
        this.air_pressure = air_pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setPredictability(int predictability) {
        this.predictability = predictability;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    public void setWind_direction_compass(String wind_direction_compass) {
        this.wind_direction_compass = wind_direction_compass;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public void setMin_temp(float min_temp) {
        this.min_temp = min_temp;
    }

    public void setMax_temp(float max_temp) {
        this.max_temp = max_temp;
    }

    public void setThe_temp(float the_temp) {
        this.the_temp = the_temp;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public void setWind_direction(float wind_direction) {
        this.wind_direction = wind_direction;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    private String weather_state_name, weather_state_abbr, wind_direction_compass, created;
    private String applicable_date;
    private float min_temp,max_temp,the_temp, wind_speed,wind_direction, visibility;

    public WeatherForecastReport() {
    }

    public WeatherForecastReport(int id, int air_pressure, int humidity, int predictability, String weather_state_name, String weather_state_abbr, String wind_direction_compass, String created, String applicable_date, float min_temp, float max_temp, float the_temp, float wind_speed, float wind_direction, float visibility) {
        this.id = id;
        this.air_pressure = air_pressure;
        this.humidity = humidity;
        this.predictability = predictability;
        this.weather_state_name = weather_state_name;
        this.weather_state_abbr = weather_state_abbr;
        this.wind_direction_compass = wind_direction_compass;
        this.created = created;
        this.applicable_date = applicable_date;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.the_temp = the_temp;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return  "Date: " + applicable_date + "\n" +
                "weather state name: " + weather_state_name + "\n" +
                "wind direction compass: " + wind_direction_compass + "\n" +

                "min temp= " + min_temp + "\n" +
                "max temp= " + max_temp + "\n" +
                "the temp= " + the_temp + "\n" +
                "wind speed= " + wind_speed;
    }
}
