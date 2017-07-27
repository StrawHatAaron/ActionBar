package com.aaronjeromemiller.actionbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by aaronmiller on 7/26/17.
 */

public class ActivityProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        TextView title = (TextView) findViewById(R.id.profileTitle);
        title.setText("Profile");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.botNavViewBar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_explore:
                        //Intent intentExplore = new Intent(ActivityProfile.this, MainActivity.class);
                        //startActivity(intentExplore);
                        startActivity(new Intent(ActivityProfile.this, MainActivity.class));
                        break;
                    case R.id.ic_menu:
                        Intent intentNotify = new Intent(ActivityProfile.this, ActivityMenu.class);
                        startActivity(intentNotify);
                        break;
                    case R.id.ic_home:
                        Intent intentMenu = new Intent(ActivityProfile.this, ActivityHome.class);
                        startActivity(intentMenu);
                        break;
                    case R.id.ic_notify:
                        Intent intentProfile = new Intent(ActivityProfile.this, ActivityNotify.class);
                        startActivity(intentProfile);
                        break;
                    case R.id.ic_profile:
                        break;
                }
                return false;
            }
        });
    }
}
