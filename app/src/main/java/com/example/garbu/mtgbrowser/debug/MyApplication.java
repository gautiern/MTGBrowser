package com.example.garbu.mtgbrowser.debug;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by garbu on 9/10/2018.
 */

public class MyApplication extends Application {

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}