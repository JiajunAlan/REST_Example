package com.jiajun.rest_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

        //listeners.
        btn_cityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked",Toast.LENGTH_SHORT).show();
            }
        });
        btn_getWeather_by_cityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Your message" + et_input.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        btn_getWeather_by_cityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }





}