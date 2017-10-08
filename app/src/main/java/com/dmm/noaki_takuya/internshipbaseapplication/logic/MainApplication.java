package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.app.Application;
import android.util.Log;

import com.dmm.noaki_takuya.internshipbaseapplication.Model.Recipe;
import com.dmm.noaki_takuya.internshipbaseapplication.R;

import java.util.TreeMap;

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

        // テストデータ
        ///*
        RecipeLogic.instance().houses = Recipe.testDataLoading();
        ChoiceHouseLogic.instance().houseName = "すぎやま";
        ChoiceHouseLogic.instance().myHouse = "すぎやま";
        //*/

        // 初期データ
        /*
        if( !RecipeIO.load(this.getBaseContext()) ){
            RecipeLogic.instance().houses = Recipe.firstDataLoading();
            ChoiceHouseLogic.instance().houseName = "わたし";
            ChoiceHouseLogic.instance().myHouse   = "わたし";

            // ファイル出力
            RecipeIO.save(this.getBaseContext());
        } else {
            // myMenu = Trueのレシピがある家が自分の家
            for (String houseName: RecipeLogic.instance().houses.keySet()){
                TreeMap<String, Recipe> m = RecipeLogic.houses.get(houseName);
                Recipe recipe_ = (Recipe)(m.values().toArray()[0]);
                if(recipe_.myMenu){
                    ChoiceHouseLogic.instance().myHouse   = houseName;
                    ChoiceHouseLogic.instance().houseName = houseName;
                    Log.w(ChoiceHouseLogic.instance().myHouse, ChoiceHouseLogic.instance().houseName);
                }
            }
        }
        */

        super.onCreate();
    }
}
