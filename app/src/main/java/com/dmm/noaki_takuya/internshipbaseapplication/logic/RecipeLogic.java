package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.content.Intent;
import android.widget.TextView;

import com.dmm.noaki_takuya.internshipbaseapplication.Model.Recipe;
import com.dmm.noaki_takuya.internshipbaseapplication.R;
import com.dmm.noaki_takuya.internshipbaseapplication.RecipeActivity;
import com.dmm.noaki_takuya.internshipbaseapplication.ThankyouActivity;

import java.util.ArrayList;

/**
 * Created by noaki-takuya on 2017/09/27.
 */

public class RecipeLogic {
    // シングルトンパターン
    private static RecipeLogic singleton = new RecipeLogic();
    // どこから呼んでも同じインスタンスが参照できる
    public static RecipeLogic instance(){
        return singleton;
    }


    public static ArrayList<Recipe> recipes = new ArrayList();

    public void onCreate(RecipeActivity activity){
        // activity_recipe.xmlのデザインをActivityに読み込み
        activity.setContentView(R.layout.activity_recipe);

        Recipe recipe = new Recipe();
        recipe.houseName = "杉山";
        recipe.howToUse = "1.2.3.";
        recipe.recipeName = "オムレツ";
        recipes.add(recipe);
        recipe = new Recipe();
        recipe.houseName = "蛯谷";
        recipe.howToUse = "1.2.3.";
        recipe.recipeName = "オム";
        recipes.add(recipe);


        // どのレシピを選んだかを取得
        String recipeName = RecipeMenuLogic.instance().recipeName;
        // 誰の家を選んだかを取得
        String houseName = ChoiceHouseLogic.instance().houseName;



        // idでbuttonを取得
        TextView homeRecipe = (TextView)( activity.findViewById(R.id.homeRecipe) );
        // 文字をせってい
        homeRecipe.setText(houseName + "さんちの" + recipeName);


        // idでbuttonを取得
        TextView ingredient = (TextView)( activity.findViewById(R.id.ingredient) );
        // 文字をせってい
        ingredient.setText("卵、砂糖、醤油");

        TextView process = (TextView)( activity.findViewById(R.id.process) );
        // 文字をせってい
        process.setText("1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ");
    }


    // editボタン
    public void edit(RecipeActivity activity) {
        // まえのがめんに戻る
        activity.finish();
    }

    // cookedボタン
    public void cooked(RecipeActivity activity) {
        // 次のActivityへの一時的な遷移(一方的な遷移はまた別の書き方があります)
        Intent intent = new Intent(activity, ThankyouActivity.class);
        activity.startActivity(intent);
    }

    // メールボタン
    public void toMail(RecipeActivity activity) {
        // メールアプリにレシピを投げる
        RecipeIO.callMailIntent(activity);
    }
}
