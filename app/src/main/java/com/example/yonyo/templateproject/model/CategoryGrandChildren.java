package com.example.yonyo.templateproject.model;

import com.google.gson.annotations.SerializedName;

public class CategoryGrandChildren {

    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
