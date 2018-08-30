package com.example.yonyo.templateproject.model;

public class Dog extends AnimalResponse {

    private String bark;
    private String smell;

    public Dog(String bark, String smell) {
        this.bark = bark;
        this.smell = smell;
    }

    public String getBark() {
        return bark;
    }

    public void setBark(String bark) {
        this.bark = bark;
    }

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }
}
