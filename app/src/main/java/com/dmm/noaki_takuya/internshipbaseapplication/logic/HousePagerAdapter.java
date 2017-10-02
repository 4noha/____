/*
 *
 *  MIT License
 *
 *  Copyright (c) 2017 Alibaba Group
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 *
 */

package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dmm.noaki_takuya.internshipbaseapplication.R;

/**
 * Created by mikeafc on 15/11/26.
 */
public class HousePagerAdapter extends PagerAdapter {
    // UltraViewPager本体の制御用
    private boolean isMultiScr;
    // UltraViewPager本体の制御用
    public HousePagerAdapter(boolean isMultiScr) { this.isMultiScr = isMultiScr; }

    // UltraViewPager本体の制御用
    @Override
    public int getCount() {
        // ページ数を家配列の家の数から取得
        return ChoiceHouseLogic.instance().houseNames.length;
    }

    @Override public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    // 家データの初期化処理、
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(container.getContext()).inflate(R.layout.layout_pager, null);

        // 家情報の配列に要素番号を入れて家の名前を取得
        String houseName = ChoiceHouseLogic.instance().houseNames[position];

        // 現在の家の名前を取得して表示する
        TextView textView = (TextView) linearLayout.findViewById(R.id.pager_textview);
        textView.setText(houseName);

        // 動的作成したLinerLayoutにIDを設定
        linearLayout.setId(R.id.item_id);
        // linearLayout.setBackgroundResource(R.drawable.bg1);


        // activity_choice.xmlのデザインにlayout_child.xmlのデザインを追加
        container.addView(linearLayout);

        return linearLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        LinearLayout view = (LinearLayout) object;
        container.removeView(view);
    }
}
