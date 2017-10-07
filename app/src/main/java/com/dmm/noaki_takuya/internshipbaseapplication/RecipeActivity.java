package com.dmm.noaki_takuya.internshipbaseapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.ImageButton;

import com.dmm.noaki_takuya.internshipbaseapplication.Model.Recipe;
import com.dmm.noaki_takuya.internshipbaseapplication.logic.RecipeLogic;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class RecipeActivity extends AppCompatActivity {

    // 自分自身のインスタンスを入れておく用
    RecipeActivity activity;
    boolean isEdit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 自分自身をインスタンス変数として保持
        activity = this;
        // 触ってもらうクラスに処理を飛ばしています
        RecipeLogic.instance().onCreate(activity);

        // edit判定
        isEdit = false;


        /////////////////////////
        ///  ロングタップイベント設定(Edit)
        /////////////////////////
        LinearLayout scroll = (LinearLayout) activity.findViewById(R.id.scroll);
        scroll.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(isEdit){
                    // 普通モード
                    RecipeLogic.instance().goStandard(activity);
                } else {
                    // 編集モード
                    RecipeLogic.instance().goEdit(activity);
                }
                isEdit = !isEdit;

                return false;
            }
        });


        /////////////////////////
        ///  ボタンイベント設定
        /////////////////////////
        // 編集ボタン
        ImageButton editButton = (ImageButton)findViewById(R.id.edit);
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


        // メールボタン
        ImageButton mailButton = (ImageButton)findViewById(R.id.share);
        mailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecipeLogic.instance().toMail(activity);
                Log.v("Button","onClick");
            }
        });
    }


    // カスタムフォント requires
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
