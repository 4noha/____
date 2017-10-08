package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dmm.noaki_takuya.internshipbaseapplication.ChoiceHouseActivity;
import com.dmm.noaki_takuya.internshipbaseapplication.ImHomeActivity;
import com.dmm.noaki_takuya.internshipbaseapplication.Model.Recipe;
import com.dmm.noaki_takuya.internshipbaseapplication.R;
import com.dmm.noaki_takuya.internshipbaseapplication.View.Splash;

import java.util.ArrayList;
import java.util.TreeMap;

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

    // editモード
    public void goEdit(Activity activity) {
        // idでTextViewを取得
        TextView houseName  = (TextView)( activity.findViewById(R.id.pager_textview) );
        EditText eHouseName = (EditText) ( activity.findViewById(R.id.pager_edit) );

        // フォーカスできなくしたのを解除
        eHouseName.setFocusable(true);
        eHouseName.setFocusableInTouchMode(true);

        // データ流し込み
        eHouseName.setText(ChoiceHouseLogic.instance().houseName);


        // 非表示設定
        houseName.setVisibility(View.GONE);
        eHouseName.setVisibility(View.VISIBLE);
    }

    // diseditモード
    public void goStandard(Activity activity) {
        // idでTextViewを取得
        TextView houseName  = (TextView)( activity.findViewById(R.id.pager_textview) );
        EditText eHouseName = (EditText) ( activity.findViewById(R.id.pager_edit) );

        // フォーカスできなくする
        eHouseName.setFocusable(false);

        // データ流し込み
        String houseNameStr = eHouseName.getText().toString();
        houseName.setText(houseNameStr + "家");


        // 全てのデータの家を書き換え
        String beforeHouseName = ChoiceHouseLogic.instance().houseName;
        TreeMap<String, Recipe> menu = RecipeLogic.instance().houses.get(beforeHouseName);
        for(Recipe recipe: menu.values()){
            recipe.houseName = houseNameStr;
        }
        RecipeLogic.instance().houses.remove(beforeHouseName);
        RecipeLogic.instance().houses.put(houseNameStr, menu);

        // 現在の家の名前を書き換え
        ChoiceHouseLogic.instance().houseName = houseNameStr;
        ChoiceHouseLogic.instance().houseNames = new ArrayList<>(RecipeLogic.instance().houses.keySet());


        // 表示設定
        houseName.setVisibility(View.VISIBLE);
        eHouseName.setVisibility(View.GONE);

        // ファイル保存
        RecipeIO.save(activity);
    }
}
