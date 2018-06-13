package com.example.yonyo.templateproject.service;

import com.example.yonyo.templateproject.model.MainResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APICollections {

    @GET("categories.json")
    Call<MainResponse> getCategory();

}
