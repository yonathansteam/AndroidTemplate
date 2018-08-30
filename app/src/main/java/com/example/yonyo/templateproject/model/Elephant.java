package com.example.yonyo.templateproject.model;

public class Elephant extends AnimalResponse {

    private String bigEars;
    private String bigFoot;

    public Elephant(String bigEars, String bigFoot) {
        this.bigEars = bigEars;
        this.bigFoot = bigFoot;
    }

    public String getBigEars() {
        return bigEars;
    }

    public void setBigEars(String bigEars) {
        this.bigEars = bigEars;
    }

    public String getBigFoot() {
        return bigFoot;
    }

    public void setBigFoot(String bigFoot) {
        this.bigFoot = bigFoot;
    }
}
