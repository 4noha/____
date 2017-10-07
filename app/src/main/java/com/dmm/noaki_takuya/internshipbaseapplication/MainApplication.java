package com.dmm.noaki_takuya.internshipbaseapplication;

import android.app.Application;

import com.dmm.noaki_takuya.internshipbaseapplication.Model.Recipe;
import com.dmm.noaki_takuya.internshipbaseapplication.logic.ChoiceHouseLogic;
import com.dmm.noaki_takuya.internshipbaseapplication.logic.RecipeLogic;

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
        RecipeLogic.instance().houses = RecipeLogic.testDataLoading();
        ChoiceHouseLogic.instance().houseName = "すぎやま家";


        super.onCreate();
    }
}
