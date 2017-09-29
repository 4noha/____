package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.content.Intent;
import android.widget.TextView;

import com.dmm.noaki_takuya.internshipbaseapplication.ChoiceHouseActivity;
import com.dmm.noaki_takuya.internshipbaseapplication.R;
import com.dmm.noaki_takuya.internshipbaseapplication.RecipeMenuActivity;

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

    
    public String houseName;


    public void onCreate(ChoiceHouseActivity activity){
        // activity_main.xmlのデザインをMainActivityに読み込み
        activity.setContentView(R.layout.activity_choice);

        // idでTextViewを取得、TextView型に変換
        TextView textArea = (TextView)( activity.findViewById(R.id.text_area) );
        // 文字をせってい
        textArea.setText("最初のがめんだよ！");
    }

    // ボタンが押されたとき
    public void toMenu(ChoiceHouseActivity activity, String houseName) {
        this.houseName = houseName;

        // 次のActivityへの一時的な遷移(一方的な遷移はまた別の書き方があります)
        Intent intent = new Intent(activity, RecipeMenuActivity.class);
        activity.startActivity(intent);
    }
}
