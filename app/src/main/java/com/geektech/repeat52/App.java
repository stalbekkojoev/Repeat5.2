package com.geektech.repeat52;

import android.app.Application;

import com.geektech.repeat52.network.LoveApi;
import com.geektech.repeat52.network.RetrofitService;

public class App extends Application {

    public static LoveApi api;

    @Override
    public void onCreate() {
        super.onCreate();

        RetrofitService retrofitService = new RetrofitService();

        api = retrofitService.getLoveApi();

    }
}
