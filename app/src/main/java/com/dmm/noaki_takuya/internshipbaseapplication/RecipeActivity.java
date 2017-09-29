package com.dmm.noaki_takuya.internshipbaseapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dmm.noaki_takuya.internshipbaseapplication.logic.RecipeLogic;

public class RecipeActivity extends AppCompatActivity {

    // 自分自身のインスタンスを入れておく用
    RecipeActivity activity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 自分自身をインスタンス変数として保持
        activity = this;
        // 触ってもらうクラスに処理を飛ばしています
        RecipeLogic.instance().onCreate(activity);


        /////////////////////////
        ///  ボタンイベント設定
        /////////////////////////
        // 編集ボタン
        Button editButton = (Button)findViewById(R.id.edit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecipeLogic.instance().edit(activity);
            }
        });


        // できたよボタン
        Button cookedButton = (Button)findViewById(R.id.cooked);
        cookedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecipeLogic.instance().cooked(activity);
                Log.v("Button","onClick");
            }
        });


        // できたよボタン
        Button mailButton = (Button)findViewById(R.id.mail);
        mailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecipeLogic.instance().toMail(activity);
                Log.v("Button","onClick");
            }
        });
    }
}
