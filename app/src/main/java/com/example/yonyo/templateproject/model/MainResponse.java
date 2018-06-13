package com.example.yonyo.templateproject.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MainResponse {

    @SerializedName("status")
    String status;

    @SerializedName("categories")
    List<Category> categoryList = new ArrayList<>();

    public String getStatus() { return status; }

    public List<Category> getCategoryList() { return categoryList; }
}
