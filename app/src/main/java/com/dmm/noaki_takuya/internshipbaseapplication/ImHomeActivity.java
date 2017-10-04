package com.dmm.noaki_takuya.internshipbaseapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmm.noaki_takuya.internshipbaseapplication.logic.ChoiceHouseLogic;

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

        // activity_main.xmlのデザインをMainActivityに読み込み
        activity.setContentView(R.layout.activity_imhome);


        if (houseName == myHouse){
            // ただいま
            TextView textArea = (TextView)( activity.findViewById(R.id.text_area) );
            // 文字をせってい
            textArea.setText( "ただいま！");

            ImageView imhomepage = (ImageView)( activity.findViewById(R.id.imhomepage) );
            // 文字をせってい
            imhomepage.setImageResource(R.drawable.tadaima);
        }

        else {
            //おじゃまします
            TextView textArea = (TextView)( activity.findViewById(R.id.text_area) );
            // 文字をせってい
            textArea.setText("おじゃまします！" );

            ImageView imhomepage = (ImageView)( activity.findViewById(R.id.imhomepage) );
            // 文字をせってい
            imhomepage.setImageResource(R.drawable.ojamashimasu);
        }




        ConstraintLayout page = (ConstraintLayout) activity.findViewById(R.id.thankyoupage);
        page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity, RecipeMenuActivity.class);
                activity.startActivity(intent);

            }
        });
    }
}
