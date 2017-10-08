package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.util.Log;

import com.dmm.noaki_takuya.internshipbaseapplication.Model.Recipe;
import com.dmm.noaki_takuya.internshipbaseapplication.RecipeActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
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
            HashMap<String, TreeMap<String, Recipe>> houses = new HashMap<>();
            TreeMap<String, Recipe> menu                    = new TreeMap<>();
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
        intent.putExtra(Intent.EXTRA_SUBJECT, "レシピの共有");
        intent.putExtra(Intent.EXTRA_TEXT, "test");
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_STREAM, contentUri);
        activity.startActivity(intent);
    }


    public static void save(Activity activity){
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


    public static void receiveRecipeIntent(Activity activity){
        Intent intent = activity.getIntent();
        String action   = intent.getAction();
        String mimeType = intent.getType();



        // Gmail->Preview->ファイル送信のインテント
        if (Intent.ACTION_SEND.equals(action)) {

            if ("application/octet-stream".equals(mimeType)) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    Uri uri = extras.getParcelable(Intent.EXTRA_STREAM);
                    HashMap<String, TreeMap<String, Recipe>> houses = null;
                    TreeMap<String, Recipe> menu;
                    Recipe recipe = null;


                    // myMenu = Trueのレシピがある家が自分の家
                    for (String houseName: RecipeLogic.houses.keySet()){
                        TreeMap<String, Recipe> m = RecipeLogic.houses.get(houseName);
                        Recipe recipe_ = (Recipe)(m.values().toArray()[0]);
                        if(recipe_.myMenu){
                            ChoiceHouseLogic.instance().myHouse = houseName;
                        }
                    }

                    // レシピファイルを読み込み
                    try {
                        InputStream inStream = activity.getContentResolver().openInputStream(uri);
                        ObjectInputStream in = new ObjectInputStream(inStream);

                        // レシピの書き出し
                        houses = (HashMap<String, TreeMap<String, Recipe>>)in.readObject();
                        in.close();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(houses != null){
                        String[] aryName = houses.keySet().toArray(new String[houses.size()]);

                        if(aryName.length == 1){
                            TreeMap<String, Recipe> menu_ = houses.get(aryName[0]);
                            String[] recipeNames = menu_.keySet().toArray(new String[menu_.size()]);

                            // レシピ単体インポート
                            if(recipeNames.length == 1){
                                recipe = menu_.get(recipeNames[0]);

                                // ファイル読み込み
                                if(recipe.houseName.equals(ChoiceHouseLogic.instance().myHouse)){
                                    recipe.myMenu = true;
                                } else {
                                    recipe.myMenu = false;
                                }
                            }

                        } else {
                            // バックアップ読み込み
                        }
                        Log.w("data", houses.keySet().toString());
                        // houses = new HashMap<>();
                    }

                    // Failed
                    if(recipe == null){
                        return;
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

                    // ファイル出力
                    save(activity);
                }
            }
        }
    }
}
