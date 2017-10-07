package com.dmm.noaki_takuya.internshipbaseapplication.Model;


import com.dmm.noaki_takuya.internshipbaseapplication.R;

import java.io.Serializable;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by noaki-takuya on 2017/09/27.
 */

public class Recipe implements Serializable {
    public boolean myMenu;
    public String  houseName;
    public String  recipeName;
    public String  ingredient;
    public String  prosess;
    public int     imageId;



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
        recipe.ingredient = "卵、砂糖、醤油";
        recipe.prosess    = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "シチュー";
        recipe.imageId    = R.drawable.cake;
        menu.put(recipe.recipeName, recipe);

        for (int i = 0; i < 30 ; i++ ) {
            recipe            = new Recipe();
            recipe.myMenu     = false;
            recipe.houseName  = "やまさき";
            recipe.ingredient = "卵、砂糖、醤油";
            recipe.prosess    = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
            recipe.recipeName = "シチュー"+ i;
            recipe.imageId    = R.drawable.omelette;
            menu.put(recipe.recipeName, recipe);
        }
        houses.put(recipe.houseName, menu);

        return houses;
    }
}
