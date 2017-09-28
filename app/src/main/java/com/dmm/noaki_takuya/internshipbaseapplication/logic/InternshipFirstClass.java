package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.content.Intent;
import android.widget.TextView;

import com.dmm.noaki_takuya.internshipbaseapplication.MainActivity;
import com.dmm.noaki_takuya.internshipbaseapplication.R;
import com.dmm.noaki_takuya.internshipbaseapplication.SecondActivity;

/**
 * Created by noaki-takuya on 2017/09/27.
 */

public class InternshipFirstClass {
    // シングルトンパターン
    private static InternshipFirstClass singleton = new InternshipFirstClass();
    // どこから呼んでも同じインスタンスが参照できる
    public static InternshipFirstClass instance(){
        return singleton;
    }


    public void onCreate(MainActivity activity){
        // activity_main.xmlのデザインをMainActivityに読み込み
        activity.setContentView(R.layout.activity_main);

        // idでTextViewを取得、TextView型に変換
        TextView textArea = (TextView)( activity.findViewById(R.id.text_area) );
        // 文字をせってい
        textArea.setText("最初のがめんだよ！");
    }

    // ボタンが押されたとき
    public void buttonClick(MainActivity activity) {

        // SecondActivityへの一時的な遷移(一方的な遷移はまた別の書き方があります)
        Intent intent = new Intent(activity, SecondActivity.class);
        activity.startActivity(intent);
    }
}
