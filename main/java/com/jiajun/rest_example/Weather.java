package com.jiajun.rest_example;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Weather {
    public static final String QUERY_TO_GET_CITY_ID = "https://www.metaweather.com/api/location/search/?query=";
    Context context;
    String cityID = "";
    /** Construtor initial with the context.
     * **/
    public Weather(Context context) {
        this.context = context;
    }
    /**call back
     * **/
    public interface VolleyResponseListener{
        void onError(String message);
        void onResponse(String cityID);
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