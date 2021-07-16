package com.jiajun.rest_example;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Weather {
    public static final String QUERY_TO_GET_CITY_ID = "https://www.metaweather.com/api/location/search/?query=";
    public static final String QUERY_TO_GET_FORECAST_BY_CITY_ID = "https://www.metaweather.com/api/location/";
    Context context;
    String cityID = "";
    /** Construtor initial with the context.
     * **/
    public Weather(Context context) {
        this.context = context;
    }
    /**call back for city id
     * **/
    public interface VolleyResponseListener{
        void onError(String message);
        void onResponse(String cityID);
    }

    /** call back for forecast by id.
     * **/
    public interface ForecastByIDResponse{
        void onError(String message);
        void onResponse(List<WeatherForecastReport> weatherForecastReport);
    }
    /** return city id
     * **/
    public void getcityID(String cityName, VolleyResponseListener volleyResponseListener){
        // Instantiate the RequestQueue.
        //RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = QUERY_TO_GET_CITY_ID + cityName;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONObject city_data = response.getJSONObject(0);
                    cityID = city_data.getString("woeid");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //wont show as the process goes through, because volley is in background thread.
                //need call back to make this toast work.
                //Toast.makeText(context,"The city id we get is "+ cityID, Toast.LENGTH_SHORT).show();
                volleyResponseListener.onResponse(cityID);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(context,"Something Wrong when getting city ID",Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError("Something wrong");
            }
        });


        Volley_Singleton.getInstance(context).addToRequestQueue(request);
        //using call backs no longer need return.
        //return cityID;
    }

    public void getForcastByID(String cityID, ForecastByIDResponse forecastByIDResponse){
        List<WeatherForecastReport> weatherForecastReports = new ArrayList<>();

        String url = QUERY_TO_GET_FORECAST_BY_CITY_ID + cityID;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Toast.makeText(context,response.toString(),Toast.LENGTH_SHORT).show();

                try {
                    JSONArray weather_list = response.getJSONArray("consolidated_weather");

                    for (int i = 0; i < weather_list.length(); i++) {
                        WeatherForecastReport one_day_report = new WeatherForecastReport();
                        JSONObject first_day = (JSONObject) weather_list.get(i);

                        one_day_report.setId(first_day.getInt("id"));
                        one_day_report.setWeather_state_name(first_day.getString("weather_state_name"));
                        one_day_report.setWeather_state_abbr(first_day.getString("weather_state_abbr"));
                        one_day_report.setWind_direction_compass(first_day.getString("wind_direction_compass"));
                        one_day_report.setCreated(first_day.getString("created"));
                        one_day_report.setApplicable_date(first_day.getString("applicable_date"));
                        one_day_report.setMin_temp(first_day.getLong("min_temp"));
                        one_day_report.setMax_temp(first_day.getLong("max_temp"));
                        one_day_report.setThe_temp(first_day.getLong("the_temp"));
                        one_day_report.setWind_speed(first_day.getLong("wind_speed"));
                        one_day_report.setWind_direction(first_day.getLong("wind_direction"));
                        one_day_report.setAir_pressure(first_day.getInt("air_pressure"));
                        one_day_report.setHumidity(first_day.getInt("humidity"));
                        one_day_report.setVisibility(first_day.getLong("humidity"));
                        one_day_report.setPredictability(first_day.getInt("predictability"));
                        weatherForecastReports.add(one_day_report);
                    }
                    forecastByIDResponse.onResponse(weatherForecastReports);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley_Singleton.getInstance(context).addToRequestQueue(request);
    }
}
//string request notes.
// Request a string response from the provided URL.
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                // Display the first 500 characters of the response string
//                                Toast.makeText(MainActivity.this, response,Toast.LENGTH_SHORT).show();
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, "error occured", Toast.LENGTH_SHORT).show();
//                    }
//                });

// Add the request to the RequestQueue.
//                queue.add(request);
// Toast.makeText(MainActivity.this, "clicked",Toast.LENGTH_SHORT).show();