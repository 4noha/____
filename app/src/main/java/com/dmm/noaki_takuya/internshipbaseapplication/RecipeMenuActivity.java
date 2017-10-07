package com.dmm.noaki_takuya.internshipbaseapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmm.noaki_takuya.internshipbaseapplication.Model.Recipe;
import com.dmm.noaki_takuya.internshipbaseapplication.logic.ChoiceHouseLogic;
import com.dmm.noaki_takuya.internshipbaseapplication.logic.RecipeLogic;
import com.dmm.noaki_takuya.internshipbaseapplication.logic.RecipeMenuLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class RecipeMenuActivity extends AppCompatActivity {

    // 自分自身のインスタンスを入れておく用
    RecipeMenuActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 自分自身をインスタンス変数として保持
        activity = this;
        // 触ってもらうクラスに処理を飛ばしています
        RecipeMenuLogic.instance().onCreate(activity);


        // idでbuttonを取得
        Button cookedButton = (Button)findViewById(R.id.recipeBtn1);
        // レシピ選択ボタンのイベントを設定
        cookedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe recipe = new Recipe();
                recipe.recipeName = "オムレツ";
                RecipeMenuLogic.instance().toRecipe(activity, recipe);
                Log.v("Button","onClick");
            }
        });



        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        // 家の名前取得
        String houseName = ChoiceHouseLogic.instance().houseName;
        // メニューを取得
        TreeMap<String, Recipe> menu = RecipeLogic.instance().houses.get(houseName);
        // ArrayListに変換
        List<Recipe> list = new ArrayList<>(menu.values());


        recyclerView.setAdapter(new RecyclerAdapter(activity, getApplicationContext(), list));
    }


    private static final class RecyclerAdapter
            extends RecyclerView.Adapter {
        private final RecipeMenuActivity activity;
        private final Context mContext;
        private List<Recipe> mItemList = new ArrayList();
        private RecyclerAdapter (RecipeMenuActivity activity, final Context context, final List<Recipe> itemList) {
            this.activity = activity;
            mContext = context;
            mItemList = itemList;

        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
            final View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
            final ViewHolder holder = new ViewHolder(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Recipe recipe = mItemList.get(holder.getPosition());
                    RecipeMenuLogic.instance().toRecipe(activity, recipe);
                }
            });

            return holder ;
        }
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Recipe recipe= mItemList.get(position);
            final TextView textItem = (TextView) holder.itemView.findViewById(R.id.itemText);
            textItem.setText(recipe.recipeName);

            final ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.itemImage);
            imageView.setImageResource(recipe.imageId);

        }
        @Override
        public int getItemCount() {
            return mItemList.size();
        }

        private static class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView mTextView;
            private ViewHolder(View v) {
                super(v);
                mTextView = (TextView) v.findViewById(R.id.itemText);
            }
        }
    }
}
