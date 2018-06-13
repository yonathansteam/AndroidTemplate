package com.example.yonyo.templateproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Category {

    @SerializedName("id")
    String id;

    @Expose
    @SerializedName("name")
    private String name;

    @SerializedName("children")
    List<CategoryChildren> children = new ArrayList<>();

    private int childrenSize;

    public Category(String name, int childrenSize) {
        this.name = name;
        this.childrenSize = childrenSize;
    }

    public int getChildrenSize() { return childrenSize; }

    public String getId() { return id; }

    public String getName() { return name; }

    public List<CategoryChildren> getChildren() { return children; }
}
