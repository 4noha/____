package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;

import com.dmm.noaki_takuya.internshipbaseapplication.Model.Recipe;
import com.dmm.noaki_takuya.internshipbaseapplication.R;
import com.dmm.noaki_takuya.internshipbaseapplication.RecipeActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by noaki-takuya on 2017/09/27.
 */

public class RecipeIO {
    public static String OUTPUT_NAME = "export.recipe";
    public static String FILE_NAME   = "strage.recipe";

    // メールアプリにレシピを投げる
    public static void callMailIntent(RecipeActivity activity){
        // レシピファイルを作成
        File     sendFile = new File(activity.getCacheDir(), OUTPUT_NAME);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(sendFile));

            Recipe recipe = RecipeMenuLogic.instance().recipe;
            HashMap<String, HashMap<String, Recipe>> houses = new HashMap<>();
            HashMap<String, Recipe> menu                    = new HashMap<>();
            menu.put(recipe.recipeName, recipe);
            houses.put(recipe.houseName, menu);

            // 現在選択中のメニューの書き出し
            out.writeObject(houses);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // content:// スキームのURIの作成
        Intent intent     = new Intent();
        Uri contentUri = FileProvider.getUriForFile(activity, "com.dmm.noaki_takuya.internshipbaseapplication.fileprovider", sendFile);


        // メール送信インテントの作成
        intent.setAction(Intent.ACTION_SEND);
        //intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"test@exsample.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "レシピの共有");
        intent.putExtra(Intent.EXTRA_TEXT, "test");
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_STREAM, contentUri);
        activity.startActivity(intent);
    }


    public void save(Activity activity){
        // レシピファイルを作成
        File sendFile = new File(activity.getCacheDir(), FILE_NAME);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(sendFile));

            // 全てのレシピを取得
            HashMap<String, TreeMap<String, Recipe>> houses = RecipeLogic.houses;

            // 書き出し
            out.writeObject(houses);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void receiveRecipeIntent(Intent intent){
        String action   = intent.getAction();
        String mimeType = intent.getType();



        // Gmail->Preview->ファイル送信のインテント
        if (Intent.ACTION_SEND.equals(action)) {

            if ("application/octet-stream".equals(mimeType)) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    Uri uri = extras.getParcelable(Intent.EXTRA_STREAM);




                    // myMenu = Trueのレシピがある家が自分の家
                    for (String houseName: RecipeLogic.houses.keySet()){
                        TreeMap<String, Recipe> m = RecipeLogic.houses.get(houseName);
                        Recipe recipe_ = (Recipe)(m.values().toArray()[0]);
                        if(recipe_.myMenu){
                            ChoiceHouseLogic.instance().myHouse = houseName;
                        }
                    }


                    TreeMap<String, Recipe> menu;

                    // テストデータ
                    Recipe recipe     = new Recipe();
                    recipe.myMenu     = true;
                    recipe.houseName  = "すぎやま";
                    recipe.ingredient   = "卵、砂糖、醤油";
                    recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
                    recipe.recipeName = "オムレツ";
                    recipe.imageId    = R.drawable.cake;
                    //

                    // ファイル読み込み
                    if(recipe.houseName.equals(ChoiceHouseLogic.instance().myHouse)){
                        recipe.myMenu = true;
                    }

                    // OO家のメニューを取得、なければ追加
                    menu = RecipeLogic.houses.get(recipe.houseName);
                    if(menu == null){
                        menu = new TreeMap<String, Recipe>();
                    }
                    // 上書き
                    menu.put(recipe.recipeName, recipe);

                    ChoiceHouseLogic.instance().houseName = recipe.houseName;
                    RecipeLogic.houses.put(recipe.houseName, menu);
                    RecipeMenuLogic.instance().recipe = recipe;
                }
            }
        }
    }
}
