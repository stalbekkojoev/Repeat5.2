package com.geektech.repeat52.hilt;

import com.geektech.repeat52.network.LoveModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class AppModule {

    public interface LoveApi{

        @GET("getPercentage")
        Call<LoveModel> loveCalculate(@Query("fname") String firstName,
                                      @Query("sname") String secondName,
                                      @Query("X-RapidAPI-Host") String host,
                                      @Query("X-RapidAPI-Key") String key);
    }
}
