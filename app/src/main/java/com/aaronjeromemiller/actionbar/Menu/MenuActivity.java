package com.aaronjeromemiller.actionbar.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

//<<<<<<< HEAD:app/src/main/java/com/aaronjeromemiller/actionbar/Menu/MenuActivity.java
import com.aaronjeromemiller.actionbar.ActivityNotify;
import com.aaronjeromemiller.actionbar.HomeActivity;
import com.aaronjeromemiller.actionbar.MainActivity;
import com.aaronjeromemiller.actionbar.ProfileActivity;
import com.aaronjeromemiller.actionbar.R;
//=======
//>>>>>>> profile:app/src/main/java/com/aaronjeromemiller/actionbar/MenuActivity.java
import com.aaronjeromemiller.actionbar.Utils.BottomNavigationViewHelper;
import com.aaronjeromemiller.actionbar.Utils.SectionsPagerAdapter;

/**
 * Created by aaronmiller on 7/26/17.
 */

public class MenuActivity  extends AppCompatActivity {

    private final String TAG = "MenuActivity";

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        TextView title = (TextView) findViewById(R.id.menuTitle);
        title.setText("Menu");

//        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        //try to setup onClickListener for all items in the array


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.botNavViewBar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_explore:
                        //Intent intentExplore = new Intent(MenuActivity.this, MainActivity.class);
                        //startActivity(intentExplore);
                        startActivity(new Intent(MenuActivity.this, MainActivity.class));
                        break;
                    case R.id.ic_menu:
                        break;
                    case R.id.ic_home:
                        Intent intentMenu = new Intent(MenuActivity.this, HomeActivity.class);
                        startActivity(intentMenu);
                        break;
                    case R.id.ic_notify:
                        Intent intentNotify = new Intent(MenuActivity.this, ActivityNotify.class);
                        startActivity(intentNotify);
                        break;
                    case R.id.ic_profile:
                        Intent intentProfile = new Intent(MenuActivity.this, ProfileActivity.class);
                        startActivity(intentProfile);
                        break;
                }
                return false;
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MenuFragment());
        //adapter.addFragment(new com.aaronjeromemiller.actionbar.VideosFragment());
        //adapter.addFragment(new com.aaronjeromemiller.actionbar.MoreFragment());
        viewPager.setAdapter(adapter);
    }
}
