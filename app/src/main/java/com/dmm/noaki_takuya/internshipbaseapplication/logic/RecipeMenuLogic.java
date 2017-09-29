package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.content.Intent;
import android.widget.TextView;

import com.dmm.noaki_takuya.internshipbaseapplication.R;
import com.dmm.noaki_takuya.internshipbaseapplication.RecipeActivity;
import com.dmm.noaki_takuya.internshipbaseapplication.RecipeMenuActivity;

/**
 * Created by noaki-takuya on 2017/09/27.
 */

public class RecipeMenuLogic {
    // シングルトンパターン
    private static RecipeMenuLogic singleton = new RecipeMenuLogic();
    // どこから呼んでも同じインスタンスが参照できる
    public static RecipeMenuLogic instance(){
        return singleton;
    }


    public String recipeName;


    public void onCreate(RecipeMenuActivity activity){
        // activity_main.xmlのデザインをMainActivityに読み込み
        activity.setContentView(R.layout.activity_menu);


        // 誰の家を選んだかを取得
        String houseName = ChoiceHouseLogic.instance().houseName;


        // idでTextViewを取得
        TextView textArea = (TextView)( activity.findViewById(R.id.text_area) );
        // 文字をせってい
        textArea.setText(houseName + "家のレシピだよ！");
    }


    // ボタンが押されたとき
    public void toRecipe(RecipeMenuActivity activity, String recipeName) {
        this.recipeName = recipeName;

        // 次のActivityへの一時的な遷移(一方的な遷移はまた別の書き方があります)
        Intent intent = new Intent(activity, RecipeActivity.class);
        activity.startActivity(intent);
    }
}
