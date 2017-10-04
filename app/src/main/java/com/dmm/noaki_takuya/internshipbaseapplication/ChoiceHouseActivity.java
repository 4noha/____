package com.dmm.noaki_takuya.internshipbaseapplication;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.dmm.noaki_takuya.internshipbaseapplication.logic.ChoiceHouseLogic;
import com.dmm.noaki_takuya.internshipbaseapplication.logic.HousePagerAdapter;
import com.tmall.ultraviewpager.UltraViewPager;

/////////////
// 最初の画面
/////////////

public class ChoiceHouseActivity extends AppCompatActivity{

    // 自分自身のインスタンスを入れておく用
    private ChoiceHouseActivity activity;
    // スワイプジェスチャーの検知用
    GestureDetector gesture;
    private UltraViewPager housePager;
    private PagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 自分自身を保持
        activity = this;
        // 触ってもらうクラスに処理を飛ばしています
        ChoiceHouseLogic.instance().onCreate(activity);


        /////////////////////////
        ///  家の選択カルーセル
        /////////////////////////

        // カルーセル本体
        housePager = (UltraViewPager) activity.findViewById(R.id.ultra_viewpager);
        // カルーセルのスクロール方向(水平)
        housePager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        // 家データ流し込みクラスのインスタンス生成
        adapter = new HousePagerAdapter(false);
        // 家データ流し込み
        housePager.setAdapter(adapter);
        // スクロールアニメーションスピード
        housePager.setInfiniteRatio(100);



        // activityのどこをクリックしても家を選択したことになるイベントを設定
        gesture = new GestureDetector(activity, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                // pagerから要素番号を取得
                int position = housePager.getCurrentItem();
                // houseNamesから現在選択されている家の名前を取得
                String houseName = ChoiceHouseLogic.instance().houseNames[position];
                // RecipeMenuに遷移
                ChoiceHouseLogic.instance().toHome(activity, houseName);

                return false;
            }
        });
    }

    // Activity.dispatchTouchEvent()
    // ViewGroup.dispatchTouchEvent()
    // View.dispatchTouchEvent()
    // View.onTouchEvent()
    // ViewGroup.onTouchEvent()
    // Activity.onTouchEvent()
    // タッチイベントは上記の順番で呼ばれる。housePagerに使っているライブラリ、UltraPagerはViewGroup層の
    // dispatchTouchEventで以降のイベントを握りつぶす汚い実装だったのでActivity層のdispatchTouchEventで
    // イベントを取り返している。イベントが発火しないのでUltraPagerのソースコードを読み込んで発覚した。
    // Android UIではこういうことがよくあるのでUIの外部ライブラリは極力使いたくない。。。
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        // Activity.dispatchTouchEventを呼んだことで逆にUltraPagerのdispatchTouchEventを殺さないように
        // ここで呼ぶ。ただActivityのEventなので普通に渡してしまうと画面のどこを操作してもイベントが走る
        housePager.dispatchTouchEvent(event);
        // GestureDetectorのイベントを発火させるにはonTouchEventにMotionEventを渡してあげないといけない
        gesture.onTouchEvent(event);

        return false;
    }
}
