package com.aaronjeromemiller.actionbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aaronjeromemiller.actionbar.Menu.Menu;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

/**
 * Created by User on 8/5/2017.
 */

public class MenuListAdapter extends ArrayAdapter<Menu> {

    private static final String TAG = "CustomListAdapter";
    private Context mContext;
    private String[] foodNames;
    private int[] foodPics;
//    private int mResource;
//    private int lastPosition = -1;
    //NEW IMPLEMENTATION FOR ACTIVITY TO FRAGMENT ON CLICK

    public MenuListAdapter(Context context, String[] foodNames, int[] foodPics) {
        super(context, R.layout.menu_view_item);
        this.foodNames = foodNames;
        this.foodPics = foodPics;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return foodNames.length;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.menu_view_item, parent, false);
            mViewHolder.mFoodPics = (ImageView) convertView.findViewById(R.id.bio_image);
            mViewHolder.mFoodNames = (TextView) convertView.findViewById(R.id.bio_text);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mFoodPics.setImageResource(foodPics[position]);
        mViewHolder.mFoodNames.setText(foodNames[position]);

        return convertView;
    }

    static class ViewHolder {
        ImageView mFoodPics;
        TextView mFoodNames;
    }
    //************************************************************
}

    /**
     * Holds variables in a View
     TODO
    private static class ViewHolder {
        TextView title;
        TextView description;
        ImageView image;
        ProgressBar dialog;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     TODO
    public MenuListAdapter(Context context, int resource, ArrayList<Menu> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;

        //sets up the image loader library
        setupImageLoader();
    }

    /*********** Commented out for the TODO implement activity
     @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the persons information
        String title = getItem(position).getFoodCardTitle();
        Log.d(TAG, title);
        String imgUrl = getItem(position).getFoodCardImage();
        String description = getItem(position).getFoodCardDescription();


            try{

            //create the view result for showing the animation
            final View result;

            //ViewHolder object
            final ViewHolder holder;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder= new ViewHolder();
                holder.title = (TextView) convertView.findViewById(R.id.food_card_title);
                holder.image = (ImageView) convertView.findViewById(R.id.food_card_image);
                holder.description = (TextView) convertView.findViewById(R.id.food_card_description);
                holder.dialog = (ProgressBar) convertView.findViewById(R.id.cardProgressDialog);
                result = convertView;

                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
                result = convertView;
            }


//            Animation animation = AnimationUtils.loadAnimation(mContext,
//                    (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
//            result.startAnimation(animation);
            lastPosition = position;

            holder.title.setText(title);

            //create the imageloader object
            ImageLoader imageLoader = ImageLoader.getInstance();

            int defaultImage = mContext.getResources().getIdentifier("@colors/colorWhite",null,mContext.getPackageName());

            //create display options
            DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                    .cacheOnDisc(true).resetViewBeforeLoading(true)
                    .showImageForEmptyUri(defaultImage)
                    .showImageOnFail(defaultImage)
                    .showImageOnLoading(defaultImage).build();

            //download and display image from url
            imageLoader.displayImage(imgUrl, holder.image, options, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {
                    holder.dialog.setVisibility(View.VISIBLE);
                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    holder.dialog.setVisibility(View.GONE);
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {

                }
            });

            return convertView;
        }catch (IllegalArgumentException e){
            Log.e(TAG, "getView: IllegalArgumentException: " + e.getMessage() );
            return convertView;
        }

    }*/

    /**
     * Required for setting up the Universal Image loader Library

    private void setupImageLoader(){
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }*/
