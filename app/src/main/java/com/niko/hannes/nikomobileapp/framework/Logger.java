package com.niko.hannes.nikomobileapp.framework;

import android.util.Log;

/**
 * Created by Hannes on 28/07/2015.
 */
public class Logger {

    private String mName;

    public Logger(String name) {

        mName = name;
    }

    public void Debug(String message){
        Log.d(mName, message);

    }

    public void Info(String message){
        Log.i(mName, message);

    }
}
