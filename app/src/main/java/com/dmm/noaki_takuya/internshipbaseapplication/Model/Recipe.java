package com.dmm.noaki_takuya.internshipbaseapplication.Model;

import android.widget.TextView;

import com.dmm.noaki_takuya.internshipbaseapplication.R;
import com.dmm.noaki_takuya.internshipbaseapplication.RecipeActivity;
import com.dmm.noaki_takuya.internshipbaseapplication.logic.ChoiceHouseLogic;
import com.dmm.noaki_takuya.internshipbaseapplication.logic.Export;
import com.dmm.noaki_takuya.internshipbaseapplication.logic.RecipeMenuLogic;

import java.io.Serializable;

/**
 * Created by noaki-takuya on 2017/09/27.
 */

public class Recipe implements Serializable {
    public String houseName;
    public String recipeName;
    public String howToUse;
}
