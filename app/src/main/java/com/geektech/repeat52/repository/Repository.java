package com.geektech.repeat52.repository;

import android.util.Log;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.geektech.repeat52.App;
import com.geektech.repeat52.network.LoveModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private final String HOST = "love-calculator.p.rapidapi.com";
    private final String KEY = "2611949ba1msha3bd1bac2be828cp1e93bejsn05be3f998e60";

    public MutableLiveData<LoveModel> getData(String first, String sekond){
        MutableLiveData<LoveModel> lokalMutableLiveData = new MediatorLiveData<>();

        App.api.loveCalculate(first,sekond,HOST,KEY).enqueue(new Callback<LoveModel>() {
            @Override
            public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
                if (response.isSuccessful()){
                    lokalMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<LoveModel> call, Throwable t) {
                Log.e("ololo", "onFailure: " + t.getLocalizedMessage());
            }
        });

        return lokalMutableLiveData;
    }
}
