package com.dmm.noaki_takuya.internshipbaseapplication;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ThankyouActivity extends AppCompatActivity {

    // 自分自身のインスタンスを入れておく用
    ThankyouActivity activity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 自分自身をインスタンス変数として保持
        activity = this;

        activity.setContentView(R.layout.activity_thankyou);

        ConstraintLayout page = (ConstraintLayout) activity.findViewById(R.id.thankyoupage);
        page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }
}
