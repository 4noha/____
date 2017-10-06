package com.dmm.noaki_takuya.internshipbaseapplication;

import android.content.Context;
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
import com.dmm.noaki_takuya.internshipbaseapplication.logic.RecipeMenuLogic;

import java.util.ArrayList;
import java.util.List;

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
                RecipeMenuLogic.instance().toRecipe(activity, "オムレツ");
                Log.v("Button","onClick");
            }
        });



        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        final List list = new ArrayList<Recipe>();
        Recipe cake=new Recipe();
        cake.recipeName = "cake";
        cake.imageId= R.drawable.cake;
        list.add(cake);

        for (int i = 0; i < 30 ; i++ ) {
            Recipe recipe =new Recipe();
            recipe.recipeName = "food"+ i;
            recipe.imageId= R.drawable.omelette;
            list.add(recipe);
        }
        recyclerView.setAdapter(new RecyclerAdapter(getApplicationContext(), list));
    }


    private static final class RecyclerAdapter
            extends RecyclerView.Adapter {
        private final Context mContext;
        private List<Recipe> mItemList = new ArrayList();
        private RecyclerAdapter (final Context context, final List<Recipe> itemList) {
            mContext = context;
            mItemList = itemList;

        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
            return new ViewHolder(view);
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
