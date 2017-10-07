package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.content.Intent;

import com.dmm.noaki_takuya.internshipbaseapplication.ChoiceHouseActivity;
import com.dmm.noaki_takuya.internshipbaseapplication.ImHomeActivity;
import com.dmm.noaki_takuya.internshipbaseapplication.R;
import com.dmm.noaki_takuya.internshipbaseapplication.View.Splash;

import java.util.ArrayList;

/**
 * Created by noaki-takuya on 2017/09/27.
 */

public class ChoiceHouseLogic {
    // シングルトンパターン
    private static ChoiceHouseLogic singleton = new ChoiceHouseLogic();
    // どこから呼んでも同じインスタンスが参照できる
    public static ChoiceHouseLogic instance(){
        return singleton;
    }


    public String myHouse;
    public String houseName;
    public ArrayList<String> houseNames = new ArrayList<>(RecipeLogic.instance().houses.keySet());


    public void onCreate(ChoiceHouseActivity activity){
        // layoutをMainActivityに読み込み
        activity.setContentView(R.layout.activity_choice);
    }


    // ボタンが押されたとき
    public void toHome(ChoiceHouseActivity activity, String houseName) {
        // 選択中のhouseNameを更新
        this.houseName = houseName;

        // 次のActivityへの一時的な遷移(一方的な遷移はまた別の書き方があります)
        Intent intent = new Intent(activity, ImHomeActivity.class);
        activity.startActivity(intent);
    }
}
