package com.aaronjeromemiller.actionbar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        Log.d(TAG,"before Tablayout set");
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        Log.d(TAG, "after Tablayout set");
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_chat_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_video_library_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_more_horiz_black_24dp);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BlogFragment());
        adapter.addFragment(new MoreFragment());
        adapter.addFragment(new VideosFragment());
        viewPager.setAdapter(adapter);


    }
}
