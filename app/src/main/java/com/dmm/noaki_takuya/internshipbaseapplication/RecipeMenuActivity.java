package com.dmm.noaki_takuya.internshipbaseapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dmm.noaki_takuya.internshipbaseapplication.logic.RecipeMenuLogic;

public class RecipeMenuActivity extends AppCompatActivity {

    // 自分自身のインスタンスを入れておく用
    RecipeMenuActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 自分自身をインスタンス変数として保持
        activity = this;
        // 触ってもらうクラスに処理を飛ばしています
        RecipeMenuLogic.instance().onCreate(activity);


        // idでbuttonを取得
        Button cookedButton = (Button)findViewById(R.id.recipeBtn1);
        // レシピ選択ボタンのイベントを設定
        cookedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecipeMenuLogic.instance().toRecipe(activity, "オムレツ");
                Log.v("Button","onClick");
            }
        });
    }
}
