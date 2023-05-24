package com.example.mobilapp_programmering_project;

@SuppressWarnings("WeakerAccess")
public class RecycleItems{

    private String title;
    private String place;

    public RecycleItems(String title, String place) {
        this.title = title;
        this.place = place;
    }

    public String getTitle() {
        return title;
    }
    public String getPlace() {
        return place;
    }
}