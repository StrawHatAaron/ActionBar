package com.aaronjeromemiller.actionbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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
        Log.d("hey", "unknow files");
        tabLayout.setupWithViewPager(mViewPager);
//change
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_chat_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_video_library_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_more_horiz_black_24dp);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.botNavViewBar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_explore:
                        break;
                    case R.id.ic_menu:
                        Intent intentMenu = new Intent(MainActivity.this, ActivityMenu.class);
                        startActivity(intentMenu);
                        break;
                    case R.id.ic_home:
                        Intent intentMain = new Intent(MainActivity.this, ActivityHome.class);
                        startActivity(intentMain);
                        break;
                    case R.id.ic_notify:
                        Intent intentNotify = new Intent(MainActivity.this, ActivityNotify.class);
                        startActivity(intentNotify);
                        break;
                    case R.id.ic_profile:
                        Intent intentProfile = new Intent(MainActivity.this, ActivityProfile.class);
                        startActivity(intentProfile);
                        break;
                }
                return false;
            }
        });

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BlogFragment());
        adapter.addFragment(new MoreFragment());
        adapter.addFragment(new VideosFragment());
        viewPager.setAdapter(adapter);


    }
}
