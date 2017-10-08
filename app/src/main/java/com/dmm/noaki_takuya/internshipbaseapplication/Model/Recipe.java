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
        recipe.prosess   = "1 卵を割る \n2 砂糖と醤油を入れて混ぜる \n3 フライパンに油をひく \n4 焼く";
        recipe.recipeName = "オムレツ";
        recipe.imageId    = R.drawable.f_omelette;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "にんじん、たまねぎ、じゃがいも、肉、カレーのルー";
        recipe.prosess   = "1 野菜を切る \n2 鍋に油をひき、材料をいためる \n3 水を加える \n4 沸騰したらあくをとる　\n5 弱火～中火で材料が柔らかくなるまで約15分煮込む \n6 いったん火を止め、ルウを割り入れて溶かす \n7 再び弱火でとろみがつくまで約10分煮込む ";
        recipe.recipeName = "カレー";
        recipe.imageId    = R.drawable.f_curry;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "長ねぎ、豚肉、米、卵、しおこしょう、醤油";
        recipe.prosess   = "1 ごはんをあたためておく \n2 長ネギはみじん切り、豚肉は一口大に切り、卵は溶いておく \n3 フライパンでゴマ油を熱する \n4　豚肉、長ネギの順で炒め、軽く塩こしょうをする \n5 卵を入れ、すぐにご飯も入れ、 強火で炒める\n6 ぱらぱらになったら調味料を加える";
        recipe.recipeName = "チャーハン";
        recipe.imageId    = R.drawable.f_friedrice;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "もやし、にら、パスタ、塩、醤油";
        recipe.prosess   = "1 水を沸騰させる \n2 その間にもやしとにらをいためる \n3 水が沸騰したらパスタをゆでる \n4 パスタがゆであがったら野菜の入っているフライパンでいっしょにいためる";
        recipe.recipeName = "パスタ";
        recipe.imageId    = R.drawable.f_pasta;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "うどん、だし汁、醤油、みりん、塩";
        recipe.prosess   = "1 材料をなべにいれて火にかける \n2 沸騰したら麺をいれる";
        recipe.recipeName = "うどん";
        recipe.imageId    = R.drawable.f_udon;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "鳥もも肉、にんじん、ごぼう、こんにゃく、厚揚げ、しいたけ、たけのこ、油、醤油、みりん、酒、砂糖";
        recipe.prosess   = "1 ごぼうは汚れを落とし、斜め切りにする \n2 ごぼうを水で10分さらし、アク抜きをする \n3 ニンジンを乱切りにする \n4 鶏もも肉・たけのこ・厚揚げを一口大に切る \n5 こんにゃくは手で一口大にちぎる \n6 こんにゃくを水洗いして500wで2分レンジする \n7 油を敷いた鍋に、鶏肉→ごぼう→ニンジン→こんにゃく→たけのこ→しいたけ・厚揚げの順でいためる \n8 全体が炒められたら調味料を入る \n9 アルミホイルで蓋をして弱火で10分煮込む \n10 仕上げに火を強めの中火にし、2～3分水分を飛ばして完成！";
        recipe.recipeName = "筑前煮";
        recipe.imageId    = R.drawable.f_chiku;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "ひじき、にんじん、水煮大豆、油揚げ、ごま油、だしの素、砂糖、みりん、酒、醤油";
        recipe.prosess   = "1 ひじきはタップリの水に30分位浸ける \n2 やわらかく戻ったら水気をきる \n3 水煮大豆はザルに入れて水気をきる \n4 人参は千切りにする \n5 油揚げは熱湯をかけて油抜きして半分に切ってから細切りにする \n6 鍋で軽くいためる \n7 全体に火がまわったら汁気がなくなるまで煮る";
        recipe.recipeName = "ひじき";
        recipe.imageId    = R.drawable.f_hijiki;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "かぼちゃの煮物";
        recipe.imageId    = R.drawable.f_kabo;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "高野豆腐";
        recipe.imageId    = R.drawable.f_koya;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "なすのおひたし";
        recipe.imageId    = R.drawable.f_nasu;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "肉じゃが";
        recipe.imageId    = R.drawable.f_niku02;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "にらのおひたし";
        recipe.imageId    = R.drawable.f_nira;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "さばの味噌煮";
        recipe.imageId    = R.drawable.f_saba;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "豚汁";
        recipe.imageId    = R.drawable.f_ton;
        menu.put(recipe.recipeName, recipe);

        recipe     = new Recipe();
        recipe.myMenu     = true;
        recipe.houseName  = "すぎやま";
        recipe.recipeName = "あたらしいレシピ";
        recipe.ingredient   = "材料をかいてね";
        recipe.prosess   = "1 レシピの名前をいれる \n2 材料の名前をいれる \n3 手順をいれてね";
        recipe.imageId    = R.drawable.f_cake;

        houses.put(recipe.houseName, menu);


        menu = new TreeMap<String, Recipe>();
        recipe = new Recipe();

        recipe.myMenu     = false;
        recipe.houseName  = "えびたに";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "グラタン";
        recipe.imageId    = R.drawable.f_gratan;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = false;
        recipe.houseName  = "えびたに";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "カレー";
        recipe.imageId    = R.drawable.f_carry02;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = false;
        recipe.houseName  = "えびたに";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "にくじゃが";
        recipe.imageId    = R.drawable.f_niku;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = false;
        recipe.houseName  = "えびたに";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "フレンチトースト";
        recipe.imageId    = R.drawable.f_frenchtoast;
        menu.put(recipe.recipeName, recipe);

        houses.put(recipe.houseName, menu);


        menu = new TreeMap<String, Recipe>();
        recipe = new Recipe();

        recipe.myMenu     = false;
        recipe.houseName  = "やまさき";
        recipe.ingredient = "卵、砂糖、醤油";
        recipe.prosess    = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "カレー";
        recipe.imageId    = R.drawable.f_carry03;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = false;
        recipe.houseName  = "やまさき";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "オムライス";
        recipe.imageId    = R.drawable.f_omu;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = false;
        recipe.houseName  = "やまさき";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "パスタ";
        recipe.imageId    = R.drawable.f_pasta02;
        menu.put(recipe.recipeName, recipe);

        recipe            = new Recipe();
        recipe.myMenu     = false;
        recipe.houseName  = "やまさき";
        recipe.ingredient   = "卵、砂糖、醤油";
        recipe.prosess   = "1 卵を割ります。 \n2 \n3 \n4 \n5 \n6 \n7 \n8 ";
        recipe.recipeName = "サラダ";
        recipe.imageId    = R.drawable.f_salada;
        menu.put(recipe.recipeName, recipe);

        houses.put(recipe.houseName, menu);

        return houses;
    }


    ///////////////////////////
    /// 初期データ流し込み
    ///////////////////////////

    public static HashMap<String, TreeMap<String, Recipe> > firstDataLoading(){

        HashMap<String, TreeMap<String, Recipe> > houses = new HashMap<>();
        TreeMap<String, Recipe> menu = new TreeMap<>();
        Recipe recipe     = new Recipe();

        recipe.myMenu     = true;
        recipe.houseName  = "わたし";
        recipe.recipeName = "あたらしいレシピ";
        recipe.ingredient   = "材料をかいてね";
        recipe.prosess   = "1 レシピの名前をいれる \n2 材料の名前をいれる \n3 手順をいれてね";
        recipe.imageId    = R.drawable.f_cake;

        menu.put(recipe.recipeName, recipe);
        houses.put(recipe.houseName, menu);

        return houses;
    }
}
