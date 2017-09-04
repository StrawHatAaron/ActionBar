package com.aaronjeromemiller.actionbar.Menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.aaronjeromemiller.actionbar.R;

public class MenuDetailActivity extends AppCompatActivity {

    private TextView mTextView;
    private ImageView mImageView;
    private ListView detailListView;
    private String foodName = "lol";
    private int foodPic = R.drawable.ic_backarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity_detail);
        detailListView = (ListView) findViewById(R.id.menu_act_detail_list);
        MenuDetailAdapter menuDetailAdapter = new MenuDetailAdapter(MenuDetailActivity.this, foodName, foodPic);
        detailListView.setAdapter(menuDetailAdapter);
        mTextView = (TextView) findViewById(R.id.detail_meal_des);
        mImageView = (ImageView) findViewById(R.id.detail_meal_image);
        Bundle mBundle = getIntent().getExtras();



        //mTextView.setText(mBundle.getString("foodName"));
        //mTextView.setText("hey");
        /*if(mBundle != null){
            //mTextView.setText(mBundle.getString("foodName"));
            //mImageView.setImageResource(mBundle.getInt("foodPic"));
            //mImageView.setImageResource(R.drawable.ic_chat_black_24dp);
        }*/
    }
}
