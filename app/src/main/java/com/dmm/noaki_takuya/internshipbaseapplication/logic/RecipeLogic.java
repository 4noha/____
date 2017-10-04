package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.widget.TextView;

import com.dmm.noaki_takuya.internshipbaseapplication.Model.Recipe;
import com.dmm.noaki_takuya.internshipbaseapplication.R;
import com.dmm.noaki_takuya.internshipbaseapplication.RecipeActivity;

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
        // activity_recipe.xmlのデザインをRecipeActivityに読み込み
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
        TextView textArea = (TextView)( activity.findViewById(R.id.text_area) );
        // 文字をせってい
        textArea.setText(houseName + "さんちの" + recipeName + "のレシピだよ！");
    }


    // editボタン
    public void edit(RecipeActivity activity) {
        // まえのがっめんに戻る
        activity.finish();
    }

    // cookedボタン
    public void cooked(RecipeActivity activity) {
        // まえのがっめんに戻る
        activity.finish();
    }

    // メールボタン
    public void toMail(RecipeActivity activity) {
        // メールアプリにレシピを投げる
        Export.callMailIntent(activity);
    }
}
