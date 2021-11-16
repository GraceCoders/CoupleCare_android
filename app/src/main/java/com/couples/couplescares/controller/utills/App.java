package com.couples.couplescares.controller.utills;

/*
 * Created by Nishant  Bhardwaj on 15-06-2017.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;



public class App extends MultiDexApplication {
    public static App appInstance;
    public static AppPreferences appPreferences;





    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        appInstance = this;
        appPreferences =AppPreferences.init(appInstance);

    }



    public static App getAppContext() {
        return appInstance;

    }

    public static AppPreferences getAppPreferences() {
        return appPreferences;
    }










}
