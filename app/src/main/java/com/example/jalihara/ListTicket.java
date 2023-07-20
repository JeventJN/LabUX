package com.example.jalihara;

public class ListTicket {
    String name, time;
    Double price;
    int image;

    public ListTicket(String name, String time, Double price, int image) {
        this.name = name;
        this.time = time;
        this.price = price;
        this.image = image;
    }

    private boolean clickable;

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }
    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return time;
    }
}