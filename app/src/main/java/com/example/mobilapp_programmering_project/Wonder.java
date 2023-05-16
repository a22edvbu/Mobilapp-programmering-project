package com.example.mobilapp_programmering_project;

import com.google.gson.annotations.SerializedName;

public class Wonder {
    private String name;
    private String ID;
    private int size;

    public Wonder(String name, String ID, int size) {
        this.name = name;
        this.ID = ID;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Wonder{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", size=" + size +
                '}';
    }
}
