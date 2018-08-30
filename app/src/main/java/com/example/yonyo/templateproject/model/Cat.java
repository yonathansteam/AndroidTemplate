package com.example.yonyo.templateproject.model;

public class Cat extends Animal {

    private String smallFoot;
    private String pinkPaw;

    public Cat(String smallFoot, String pinkPaw) {
        this.smallFoot = smallFoot;
        this.pinkPaw = pinkPaw;
    }

    public String getSmallFoot() {
        return smallFoot;
    }

    public void setSmallFoot(String smallFoot) {
        this.smallFoot = smallFoot;
    }

    public String getPinkPaw() {
        return pinkPaw;
    }

    public void setPinkPaw(String pinkPaw) {
        this.pinkPaw = pinkPaw;
    }
}
