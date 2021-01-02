package com.example.servicesapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreff {

    private static SharedPreff instance;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private SharedPreff(Activity activity) {
        this.sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }


    public static synchronized SharedPreff getInstance(Activity activity) {
        if(instance == null) {
            instance = new SharedPreff(activity);
        }

        return instance;
    }

    public void saveData(String key, String value) {
        this.editor.putString(key, value);
        this.editor.apply();
    }

    public String getData(String key) {
       return sharedPreferences.getString(key, "");
    }

}
