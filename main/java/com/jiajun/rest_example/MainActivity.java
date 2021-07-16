package com.jiajun.rest_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_cityID, btn_getWeather_by_cityName, btn_getWeather_by_cityID;
    EditText et_input;
    ListView lv_report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_cityID = findViewById(R.id.btn_Get_City_id);
        btn_getWeather_by_cityID = findViewById(R.id.btn_Get_Weather_By_ID);
        btn_getWeather_by_cityName = findViewById(R.id.BTN_Get_Weather_By_Name);
        et_input = findViewById(R.id.et_input);
        lv_report = findViewById(R.id.lv_report);
        Weather weather = new Weather(MainActivity.this);

        //listeners.
        btn_cityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 weather.getcityID(et_input.getText().toString(), new Weather.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this,"Something wrong when get city id.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String cityID) {
                        Toast.makeText(MainActivity.this,"The city id is "+ cityID, Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        btn_getWeather_by_cityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





            }
        });
        btn_getWeather_by_cityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weather.getForcastByID(et_input.getText().toString(), new Weather.ForecastByIDResponse() {
                    @Override
                    public void onError(String message) {

                    }

                    @Override
                    public void onResponse(List<WeatherForecastReport> weatherForecastReport) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,weatherForecastReport);
                        lv_report.setAdapter(arrayAdapter);
                        //Toast.makeText(MainActivity.this, weatherForecastReport.toString(),Toast.LENGTH_SHORT).show();
//                        Toast.makeText(MainActivity.this, "weatherForecastReport.toString()",Toast.LENGTH_SHORT).show();
                    }
                });
                //Toast.makeText(MainActivity.this, "clicked",Toast.LENGTH_SHORT).show();
                //et_input.getText().toString()
            }
        });
    }





}