
package com.dmm.noaki_takuya.internshipbaseapplication;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by michiko on 10/7/17.
 */

public class Splash {
    RelativeLayout splashLayout;

    protected void setSplash(Activity activity) {

        // SplashのViewを読み込み
        activity.setContentView(R.layout.activity_main);

        // Layout全体を読み込み
        splashLayout = (RelativeLayout) activity.findViewById(R.id.splash_layout);
        // アニメーションさせながら透明に
        animateAlpha(splashLayout);

        Handler hdl = new Handler();
        // 第２引数で切り替わる秒数(ミリ秒)を指定、今回は2秒
        hdl.postDelayed(new splashHandler(), 4000);

    }

    // 4秒タイマーでSplashLayoutを消す
    class splashHandler implements Runnable {
        public void run() {
            splashLayout.setVisibility(View.GONE);
        }
    }

    /**
     * 4秒かけてターゲットを表示
     *
     * @param target
     */
    private void animateAlpha(RelativeLayout target) {// ImageView target ) {

        // alphaプロパティを0fから1fに変化させます
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat( target, "alpha", 1f, 0f );

        try { Thread.sleep(2000); }catch (InterruptedException e){ }

        // 3秒かけて実行させます
        objectAnimator.setDuration( 2000 );

        // アニメーションを開始します
        objectAnimator.start();

    }

}


