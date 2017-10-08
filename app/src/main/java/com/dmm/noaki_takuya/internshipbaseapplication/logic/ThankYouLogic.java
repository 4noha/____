package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.dmm.noaki_takuya.internshipbaseapplication.ChoiceHouseActivity;
import com.dmm.noaki_takuya.internshipbaseapplication.ThankyouActivity;

/**
 * Created by noaki-takuya on 2017/09/27.
 */

public class ThankYouLogic {
    // シングルトンパターン
    private static ThankYouLogic singleton = new ThankYouLogic();
    // どこから呼んでも同じインスタンスが参照できる
    public static ThankYouLogic instance(){
        return singleton;
    }


    // ボタンが押されたとき
    public void toMail(ThankyouActivity activity) {
        Intent intent     = new Intent();

        intent.setType("text/plain");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "今日のメニュー");
        intent.putExtra(Intent.EXTRA_TEXT, "できました！");

        activity.startActivity(intent);
    }

    // topへ戻るボタン
    public void back(Activity activity) {
        Intent intent = new Intent(activity, ChoiceHouseActivity.class);
        activity.startActivity(intent);
    }
}
