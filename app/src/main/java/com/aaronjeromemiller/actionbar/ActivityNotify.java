package com.aaronjeromemiller.actionbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

<<<<<<< HEAD
import com.aaronjeromemiller.actionbar.Menu.MenuActivity;
=======
import com.aaronjeromemiller.actionbar.Profile.ProfileActivity;
>>>>>>> profile
import com.aaronjeromemiller.actionbar.Utils.BottomNavigationViewHelper;

/**
 * Created by aaronmiller on 7/26/17.
 */

public class ActivityNotify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify_activity);

        TextView title = (TextView) findViewById(R.id.notifyTitle);
        title.setText("Notifications");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.botNavViewBar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_explore:
                        //Intent intentExplore = new Intent(ActivityNotify.this, MainActivity.class);
                        //startActivity(intentExplore);
                        startActivity(new Intent(ActivityNotify.this, MainActivity.class));
                        break;
                    case R.id.ic_menu:
                        Intent intentNotify = new Intent(ActivityNotify.this, MenuActivity.class);
                        startActivity(intentNotify);
                        break;
                    case R.id.ic_home:
                        Intent intentMenu = new Intent(ActivityNotify.this, HomeActivity.class);
                        startActivity(intentMenu);
                        break;
                    case R.id.ic_notify:
                        break;
                    case R.id.ic_profile:
                        Intent intentProfile = new Intent(ActivityNotify.this, ProfileActivity.class);
                        startActivity(intentProfile);
                        break;
                }
                return false;
            }
        });
    }
}
