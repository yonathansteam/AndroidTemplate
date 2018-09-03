package com.example.yonyo.templateproject.view;

import java.util.Objects;

public class Key {

    String day;

    Key(String day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return day != null ? day.equals(key.day) : key.day == null;
    }

    @Override
    public int hashCode() {
        return day != null ? day.hashCode() : 0;
    }
}
