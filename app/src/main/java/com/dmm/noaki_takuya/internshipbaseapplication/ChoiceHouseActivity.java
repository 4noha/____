package com.dmm.noaki_takuya.internshipbaseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dmm.noaki_takuya.internshipbaseapplication.logic.ChoiceHouseLogic;
import com.dmm.noaki_takuya.internshipbaseapplication.logic.RecipeLogic;

/////////////
// 最初の画面
/////////////

public class ChoiceHouseActivity extends AppCompatActivity {

    // 自分自身のインスタンスを入れておく用
    private ChoiceHouseActivity activity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 自分自身を保持
        activity = this;
        // 触ってもらうクラスに処理を飛ばしています
        ChoiceHouseLogic.instance().onCreate(activity);




        /////////////////////////
        ///  ボタンイベント設定
        /////////////////////////
        // えびボタン
        Button editButton = (Button)findViewById(R.id.house1);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChoiceHouseLogic.instance().toMenu(activity, "SUGIYAMA");
            }
        });


        // やまボタン
        Button cookedButton = (Button)findViewById(R.id.house2);
        cookedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChoiceHouseLogic.instance().toMenu(activity, "YAMASAKI");
                Log.v("Button","onClick");
            }
        });


        // すぎボタン
        Button mailButton = (Button)findViewById(R.id.house3);
        mailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChoiceHouseLogic.instance().toMenu(activity, "SUGIYAMA");
                Log.v("Button","onClick");
            }
        });
    }
}
