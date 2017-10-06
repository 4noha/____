package com.dmm.noaki_takuya.internshipbaseapplication;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by michiko on 10/4/17.
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setFontAttrId(R.attr.fontPath)
                .build());

        super.onCreate();
    }
}

