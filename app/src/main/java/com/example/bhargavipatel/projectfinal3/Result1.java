package com.example.bhargavipatel.projectfinal3;

/**
 * Created by JD on 4/5/2017.
 */

public class Result1 {
    public String name;
    public double latitude;
    public double longitude;
    public String vicinity;

    Result1(String name, double latitude, double longitude, String vicinity) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.vicinity = vicinity;
    }

    public String toString () {
        String toReturn = name + ", " + vicinity + ": " + latitude + ", " + longitude;
        return toReturn;
    }
}
