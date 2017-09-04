package com.aaronjeromemiller.actionbar.Menu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aaronjeromemiller.actionbar.R;

/**
 * Created by aaronmiller on 8/21/17.
 */

public class MenuDetailAdapter extends ArrayAdapter<Menu> {
    private static final String TAG = "CustomListAdapter";

    private Context mContext;
    private String foodName;
    private int foodPic;

//    private int mResource;
//    private int lastPosition = -1;
    //NEW IMPLEMENTATION FOR ACTIVITY TO FRAGMENT ON CLICK

    public MenuDetailAdapter(Context context, String foodName, int foodPic){
        super(context, R.layout.menu_view_detail_item);
        this.foodName = foodName;
        this.foodPic = foodPic;
        this.mContext = context;
    }
    /*@Override
    public int getCount(){
        return foodNames.length;
    }*/
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView==null) {
            LayoutInflater mInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.menu_view_detail_item, parent, false);
            mViewHolder.mFoodPic = (ImageView) convertView.findViewById(R.id.detail_meal_image);
            mViewHolder.mFoodName = (TextView) convertView.findViewById(R.id.detail_meal_des);
            convertView.setTag(mViewHolder);
        }
        else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mFoodPic.setImageResource(foodPic);
        mViewHolder.mFoodName.setText(foodName);

        return convertView;
    }

    static class ViewHolder{
        ImageView mFoodPic;
        TextView mFoodName;
    }

}
