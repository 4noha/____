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

    // 画像
    Bitmap bitmap;
    // 描画ペン
    Paint  paint;
    // 横Fitさせた画像倍率に対する縦倍率
    int imageSizeY = 1;

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

        // プログラムがAndroid Studioのデザイナに非対応でデザイナが落ちるのを回避
        if (this.isInEditMode()){
            return;
        }

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

        // プログラムがAndroid Studioのデザイナに非対応でデザイナが落ちるのを回避
        if (this.isInEditMode()){
            return;
        }

        // 解像度が変わったとき(画面回転など)
        if(changed) {
            // 画面のサイズを取得
            Point displaySize = new Point();
            this.getDisplay().getSize(displaySize);

            // 描画ペンを初期化
            paint  = new Paint();
            // 画像の読み込み
            bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.wallpaper);

            // 縦横比固定用の縦画像の倍率算出
            if(displaySize.x > bitmap.getWidth()){
                imageSizeY = (int)( displaySize.y * (bitmap.getWidth() / (float)displaySize.x) );
            } else {
                imageSizeY = (int)( displaySize.y * (displaySize.x / (float)bitmap.getWidth()) );
            }
            // 画像を画面サイズにあわせてスケーリング
            bitmap = Bitmap.createScaledBitmap(bitmap, displaySize.x, imageSizeY, true);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // プログラムがAndroid Studioのデザイナに非対応でデザイナが落ちるのを回避
        if (this.isInEditMode()){
            return;
        }
        super.onDraw(canvas);

        // 画像が見つからなければ描画しない
        if (bitmap == null) return;

        // ポイントが画面外に出るまで壁紙画像をリピートする
        Point position = new Point(0, 0);
        while(position.y < this.getHeight()) {
            canvas.drawBitmap(bitmap, 0, position.y, paint);
            position.y += imageSizeY;
        }
    }
}