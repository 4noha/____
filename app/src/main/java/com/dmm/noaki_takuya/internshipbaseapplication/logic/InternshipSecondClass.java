package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.widget.TextView;

import com.dmm.noaki_takuya.internshipbaseapplication.R;
import com.dmm.noaki_takuya.internshipbaseapplication.SecondActivity;

/**
 * Created by noaki-takuya on 2017/09/27.
 */

public class InternshipSecondClass {
    // シングルトンパターン
    private static InternshipSecondClass singleton = new InternshipSecondClass();
    // どこから呼んでも同じインスタンスが参照できる
    public static InternshipSecondClass instance(){
        return singleton;
    }



    public void onCreate(SecondActivity activity){
        // activity_main.xmlのデザインをMainActivityに読み込み
        activity.setContentView(R.layout.activity_main);


        // idでbuttonを取得
        TextView textArea = (TextView)( activity.findViewById(R.id.text_area) );
        // 文字をせってい
        textArea.setText("次のがめんだよ！");
    }


    // ボタンが押されたとき
    public void buttonClick(SecondActivity activity) {
        // まえのがっめんに戻る
        activity.finish();
    }
}
