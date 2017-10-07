package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmm.noaki_takuya.internshipbaseapplication.Model.Recipe;
import com.dmm.noaki_takuya.internshipbaseapplication.R;
import com.dmm.noaki_takuya.internshipbaseapplication.RecipeActivity;
import com.dmm.noaki_takuya.internshipbaseapplication.ThankyouActivity;

import java.util.HashMap;
import java.util.TreeMap;

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

    // HashMap: 名前を付けて複数の値を保存できるクラス
    // レシピのデータ構造
    // Houses("家名")
    //    |- Menu("レシピ名")
    //         |- Recipeクラス
    public static HashMap<String, TreeMap<String, Recipe>> houses = new HashMap<>();// テストデータ流す


    public void onCreate(RecipeActivity activity){
        // activity_recipe.xmlのデザインをActivityに読み込み
        activity.setContentView(R.layout.activity_recipe);


        Intent intent = activity.getIntent();
        String action = intent.getAction();
        // Gmail->Preview->ファイル送信のインテント
        if (Intent.ACTION_SEND.equals(action)) {
            // レシピ読み込み処理
            RecipeIO.receiveRecipeIntent(intent);
        }


        // idでbuttonを取得
        TextView homeRecipe = (TextView)( activity.findViewById(R.id.homeRecipe) );

        Recipe recipe = RecipeMenuLogic.instance().recipe;
        // 文字をせってい
        homeRecipe.setText(recipe.houseName + "さんちの" + recipe.recipeName);

        ImageView imageView = (ImageView)(activity.findViewById(R.id.cookedview)) ;
        imageView.setImageResource(recipe.imageId);


        // idでbuttonを取得
        TextView ingredient = (TextView)( activity.findViewById(R.id.ingredient) );
        // 文字をせってい
        ingredient.setText(recipe.ingredient);

        TextView process = (TextView)( activity.findViewById(R.id.process) );
        // 文字をせってい
        process.setText(recipe.prosess);
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


    // editモード
    public void goEdit(Activity activity) {
        // idでTextViewを取得
        TextView homeRecipe  = (TextView)( activity.findViewById(R.id.homeRecipe) );
        TextView ingredient  = (TextView)( activity.findViewById(R.id.ingredient) );
        TextView process     = (TextView)( activity.findViewById(R.id.process) );
        EditText eHomeRecipe  = (EditText)( activity.findViewById(R.id.eHomeRecipe) );
        EditText eIngredient  = (EditText)( activity.findViewById(R.id.eIngredient) );
        EditText eProcess     = (EditText)( activity.findViewById(R.id.eProcess) );

        // データ流し込み
        Recipe recipe = RecipeMenuLogic.instance().recipe;
        eHomeRecipe.setText(recipe.recipeName);
        eIngredient.setText(recipe.ingredient);
        eProcess.setText(recipe.prosess);


        // 非表示設定
        homeRecipe.setVisibility(View.GONE);
        ingredient.setVisibility(View.GONE);
        process.setVisibility(View.GONE);
        eHomeRecipe.setVisibility(View.VISIBLE);
        eIngredient.setVisibility(View.VISIBLE);
        eProcess.setVisibility(View.VISIBLE);
    }
    // diseditモード
    public void goStandard(Activity activity) {
        // idでTextViewを取得
        TextView homeRecipe  = (TextView)( activity.findViewById(R.id.homeRecipe) );
        TextView ingredient  = (TextView)( activity.findViewById(R.id.ingredient) );
        TextView process     = (TextView)( activity.findViewById(R.id.process) );
        EditText eHomeRecipe  = (EditText)( activity.findViewById(R.id.eHomeRecipe) );
        EditText eIngredient  = (EditText)( activity.findViewById(R.id.eIngredient) );
        EditText eProcess     = (EditText)( activity.findViewById(R.id.eProcess) );


        // データ流し込み
        Recipe recipe = RecipeMenuLogic.instance().recipe;
        recipe.recipeName = eHomeRecipe.getText().toString();
        recipe.ingredient = eIngredient.getText().toString();
        recipe.prosess = eProcess.getText().toString();
        homeRecipe.setText(recipe.houseName + "さんちの" + recipe.recipeName);
        ingredient.setText(recipe.ingredient);
        process.setText(recipe.prosess);


        // 表示設定
        homeRecipe.setVisibility(View.VISIBLE);
        ingredient.setVisibility(View.VISIBLE);
        process.setVisibility(View.VISIBLE);
        eHomeRecipe.setVisibility(View.GONE);
        eIngredient.setVisibility(View.GONE);
        eProcess.setVisibility(View.GONE);
    }



    ///////////////////////////
    /// テストデータ流し込み
    ///////////////////////////

    public static HashMap<String, TreeMap<String, Recipe> > testDataLoading(){

        HashMap<String, TreeMap<String, Recipe> > houses = new HashMap<>();


        TreeMap<String, Recipe> menu = new TreeMap<>();
        Recipe recipe     = new Recipe();

        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "オムレツ";
        recipe.imageId    = R.drawable.cake;
        menu.put(recipe.recipeName, recipe);

        for (int i = 0; i < 30 ; i++ ) {
            recipe            = new Recipe();
            recipe.myMenu     = true;
            recipe.houseName  = "すぎやま";
            recipe.ingredient   = "卵、砂糖、醤油";
            recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
            recipe.recipeName = "オムレツ"+ i;
            recipe.imageId    = R.drawable.omelette;
            menu.put(recipe.recipeName, recipe);
        }
        houses.put(recipe.houseName, menu);


        menu = new TreeMap<String, Recipe>();
        recipe = new Recipe();

        recipe.myMenu     = false;
        recipe.houseName  = "えびたに";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "グラタン";
        recipe.imageId    = R.drawable.cake;
        menu.put(recipe.recipeName, recipe);

        for (int i = 0; i < 30 ; i++ ) {
            recipe            = new Recipe();
            recipe.myMenu     = false;
            recipe.houseName  = "えびたに";
            recipe.ingredient   = "卵、砂糖、醤油";
            recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
            recipe.recipeName = "グラタン"+ i;
            recipe.imageId    = R.drawable.omelette;
            menu.put(recipe.recipeName, recipe);
        }
        houses.put(recipe.houseName, menu);


        menu = new TreeMap<String, Recipe>();
        recipe = new Recipe();

        recipe.myMenu     = false;
        recipe.houseName  = "やまさき";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "シチュー";
        recipe.imageId    = R.drawable.cake;
        menu.put(recipe.recipeName, recipe);

        for (int i = 0; i < 30 ; i++ ) {
            recipe            = new Recipe();
            recipe.myMenu     = false;
            recipe.houseName  = "やまさき";
            recipe.ingredient   = "卵、砂糖、醤油";
            recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
            recipe.recipeName = "シチュー"+ i;
            recipe.imageId    = R.drawable.omelette;
            menu.put(recipe.recipeName, recipe);
        }
        houses.put(recipe.houseName, menu);

        return houses;
    }
}
