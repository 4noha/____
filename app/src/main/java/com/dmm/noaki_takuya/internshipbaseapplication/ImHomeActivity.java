package com.dmm.noaki_takuya.internshipbaseapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmm.noaki_takuya.internshipbaseapplication.logic.ChoiceHouseLogic;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class ImHomeActivity extends AppCompatActivity {

    // 自分自身のインスタンスを入れておく用
    ImHomeActivity activity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 自分自身をインスタンス変数として保持
        activity = this;

        String houseName = ChoiceHouseLogic.instance().houseName;
        String myHouse = ChoiceHouseLogic.instance().myHouse;

        // layoutをMainActivityに読み込み
        activity.setContentView(R.layout.activity_imhome);




        if (houseName == myHouse){
            // ただいま
            TextView textArea = (TextView)( activity.findViewById(R.id.text_area) );
            // 文字をせってい
            textArea.setText( "ただいま！");
            textArea.setTextSize(50);


            ImageView imhomepage = (ImageView)( activity.findViewById(R.id.imhomepage) );
            // 文字をせってい
            imhomepage.setImageResource(R.drawable.tadaima);
        }

        else {
            //おじゃまします
            TextView textArea = (TextView)( activity.findViewById(R.id.text_area) );
            // 文字をせってい
            textArea.setText("おじゃまします！" );
            textArea.setTextSize(40);

            ImageView imhomepage = (ImageView)( activity.findViewById(R.id.imhomepage) );
            // 文字をせってい
            imhomepage.setImageResource(R.drawable.ojamashimasu);

        }

        Handler hdl = new Handler();
        final splashHandler shdl = new splashHandler();

        // 第２引数で切り替わる秒数(ミリ秒)を指定、今回は2秒
        hdl.postDelayed(shdl, 2000);


        ConstraintLayout page = (ConstraintLayout) activity.findViewById(R.id.thankyoupage);
        page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shdl.stop();

                Intent intent = new Intent(activity, RecipeMenuActivity.class);
                activity.startActivity(intent);

            }
        });
    }

    class splashHandler implements Runnable {

        boolean flag = false;

        public void run() {
            if (flag){
                return;
            }

            Intent intent = new Intent(activity, RecipeMenuActivity.class);
            startActivity(intent);
            activity.finish();

        }

        public void stop() {
            flag = true;
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
