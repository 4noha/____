package com.dmm.noaki_takuya.internshipbaseapplication.logic;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.util.Log;

import com.dmm.noaki_takuya.internshipbaseapplication.Model.Recipe;
import com.dmm.noaki_takuya.internshipbaseapplication.RecipeActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by noaki-takuya on 2017/09/27.
 */

public class RecipeIO {
    public static String FILE_NAME = "export.recipe";

    // メールアプリにレシピを投げる
    public static void callMailIntent(RecipeActivity activity){
        // レシピファイルを作成
        File     sendFile = new File(activity.getCacheDir(), FILE_NAME);
        Context  context  = activity.getBaseContext();

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(sendFile));

            Recipe recipe = new Recipe();
            recipe.houseName = "杉山";
            recipe.howToUse = "1.2.3.";
            recipe.recipeName = "オムレツ";

            out.writeObject(recipe);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Intent intent     = new Intent();
        //String contentUri = activity.getBaseContext().getCacheDir() + FILE_NAME;
        Log.v("Save to InternalStarage", sendFile.getPath());
        Uri contentUri = FileProvider.getUriForFile(activity, "com.dmm.noaki_takuya.internshipbaseapplication.fileprovider", sendFile);
        Log.v("Save to InternalStarage", contentUri.toString());


        intent.setAction(Intent.ACTION_SEND);
        //intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"test@exsample.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "レシピの共有");
        intent.putExtra(Intent.EXTRA_TEXT, "test");
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_STREAM, contentUri);
        activity.startActivity(intent);
    }
}
