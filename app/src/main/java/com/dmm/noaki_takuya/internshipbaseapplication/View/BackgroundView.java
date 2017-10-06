package com.dmm.noaki_takuya.internshipbaseapplication.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import com.dmm.noaki_takuya.internshipbaseapplication.R;

public class BackgroundView extends View {

    Bitmap bitmap;
    Paint paint;

    // 様々な引数でBackgroundViewが初期化される時の処理
    public BackgroundView(Context context) {
        super(context);
    }
    public BackgroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public BackgroundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // このビューのサイズや位置を決める
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 端末の画面サイズ呼び出し
        Point displaySize = new Point();
        this.getDisplay().getSize(displaySize);
        // 画面サイズのビューを作成
        this.setMeasuredDimension(displaySize.x, displaySize.y);
        // ビューのX位置を設定 Float型の0
        //this.setTranslationX(-1f);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if(changed) {
            Point displaySize = new Point();
            this.getDisplay().getSize(displaySize);

            paint = new Paint();
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.sky);
            bitmap = Bitmap.createScaledBitmap(bitmap, displaySize.x, bitmap.getHeight(), true);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(bitmap == null) return;

        Point position = new Point(0, 0);
        while(position.y < this.getHeight()) {
            canvas.drawBitmap(bitmap, 0, position.y, paint);
            position.y += bitmap.getHeight();
        }
    }
}