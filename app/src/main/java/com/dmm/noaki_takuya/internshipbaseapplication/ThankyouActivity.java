package com.dmm.noaki_takuya.internshipbaseapplication;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.dmm.noaki_takuya.internshipbaseapplication.logic.ThankYouLogic;

public class ThankyouActivity extends AppCompatActivity {

    // 自分自身のインスタンスを入れておく用
    ThankyouActivity activity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 自分自身をインスタンス変数として保持
        activity = this;
        activity.setContentView(R.layout.activity_thankyou);


        // idでbuttonを取得
        ImageButton mailButton = (ImageButton)findViewById(R.id.to_mail);
        // お礼メール送信のイベントを設定
        mailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThankYouLogic.instance().toMail(activity);
            }
        });


        // 画面全体のイベントを設定
        ConstraintLayout page = (ConstraintLayout) activity.findViewById(R.id.thankyoupage);
        page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });



        /////////////////////////
        ///  ボタンイベント設定
        /////////////////////////
        // 編集ボタン
        ImageButton editButton = (ImageButton) findViewById(R.id.edit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThankYouLogic.instance().back(activity);
            }
        });
    }
}