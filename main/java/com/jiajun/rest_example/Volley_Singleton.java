package com.jiajun.rest_example;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Volley_Singleton {
    private static Volley_Singleton instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private Volley_Singleton(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized Volley_Singleton getInstance(Context context) {
        if (instance == null) {
            instance = new Volley_Singleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
