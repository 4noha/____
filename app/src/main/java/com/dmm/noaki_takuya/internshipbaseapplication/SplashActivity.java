package com.dmm.noaki_takuya.internshipbaseapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by michiko on 10/7/17.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SplashActivity activity = this;
        activity.setContentView(R.layout.activity_main);

        //ImageView top= (ImageView) findViewById(R.id.top_image);


        Handler hdl = new Handler();
        // 第２引数で切り替わる秒数(ミリ秒)を指定、今回は2秒
        hdl.postDelayed(new splashHandler(), 2000);
    }

    class splashHandler implements Runnable {
        public void run() {
            Intent intent = new Intent( getApplication(), ChoiceHouseActivity.class);
            startActivity(intent);
            SplashActivity.this.finish();
        }
    }
}