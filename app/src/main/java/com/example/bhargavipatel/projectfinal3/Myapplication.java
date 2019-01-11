package com.example.bhargavipatel.projectfinal3;

import android.app.Application;
import android.content.Context;

import com.example.bhargavipatel.projectfinal3.items.Painting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bhargavipatel on 3/12/17.
 */
public class Myapplication extends Application {

    public static List<Painting> allcars;

    public static String uid;
    public static String upass;
    public static String name;
    public static String gender;
    public static String address;
    public static String mobile;
    public static String dob;
    public static String cararea;
    public static String carcity;
    public static String carname;
    public static String cartype;
    public static String cartype1;
    public static String cartype2;
    public static String carnum;
    public static String caruser;
    public static String carseat;
    public static String sdate;
    public static String edate;
    public static Context mycont;
    public static String carno;
    public static long children_count;
    public static String car_registered_user;
    public static String  no_of_seats;
    static List<String> allloc;
    static Map<String,Result1> allres;
    @Override
    public void onCreate() {
        super.onCreate();
        mycont=getApplicationContext();
        allcars=new ArrayList<>();
        allloc=new ArrayList<>();
        allres=new HashMap<>();
    }
}
