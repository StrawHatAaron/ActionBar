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

public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        TextView title = (TextView) findViewById(R.id.menuTitle);
        title.setText("Menu");

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
                        //Intent intentExplore = new Intent(ActivityMenu.this, MainActivity.class);
                        //startActivity(intentExplore);
                        startActivity(new Intent(ActivityMenu.this, MainActivity.class));
                        break;
                    case R.id.ic_menu:

                        break;
                    case R.id.ic_home:
                        Intent intentMenu = new Intent(ActivityMenu.this, ActivityHome.class);
                        startActivity(intentMenu);
                        break;
                    case R.id.ic_notify:
                        Intent intentNotify = new Intent(ActivityMenu.this, ActivityNotify.class);
                        startActivity(intentNotify);
                        break;
                    case R.id.ic_profile:
                        Intent intentProfile = new Intent(ActivityMenu.this, ActivityProfile.class);
                        startActivity(intentProfile);
                        break;
                }
                return false;
            }
        });
    }
}
