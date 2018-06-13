package com.example.yonyo.templateproject.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CategoryChildren  {

    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;


    @SerializedName("children")
    List<CategoryGrandChildren> categoryGrandchildren = new ArrayList<>();

    public String getId() { return id; }

    public String getName() { return name; }

    public List<CategoryGrandChildren> getCategoryGrandchildren() { return categoryGrandchildren; }
}
