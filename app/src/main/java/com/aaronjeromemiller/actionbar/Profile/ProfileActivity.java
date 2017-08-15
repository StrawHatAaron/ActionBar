package com.aaronjeromemiller.actionbar.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aaronjeromemiller.actionbar.ActivityNotify;
import com.aaronjeromemiller.actionbar.HomeActivity;
import com.aaronjeromemiller.actionbar.MainActivity;
import com.aaronjeromemiller.actionbar.MenuActivity;
import com.aaronjeromemiller.actionbar.R;
import com.aaronjeromemiller.actionbar.Utils.BottomNavigationViewHelper;
import com.aaronjeromemiller.actionbar.Utils.BottomNavigationViewEx;

import static android.R.attr.onClick;

/**
 * Created by aaronmiller on 7/26/17.
 */


public class ProfileActivity extends AppCompatActivity
{
    private static final String TAG = "ProfileActivity";
    private TextView title;
    private Button logoutButton;
    private Context mContext = ProfileActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logoutButton = (Button) findViewById(R.id.btn_logout);
        //TextView title = (TextView) findViewById(R.id.profileTitle);
        //title.setText("Profile");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.botNavViewBar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Toasted", Toast.LENGTH_LONG).show();
            }
        });


        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_explore:
                        //Intent intentExplore = new Intent(ProfileActivity.this, MainActivity.class);
                        //startActivity(intentExplore);
                        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                        break;
                    case R.id.ic_menu:
                        Intent intentNotify = new Intent(ProfileActivity.this, MenuActivity.class);
                        startActivity(intentNotify);
                        break;
                    case R.id.ic_home:
                        Intent intentMenu = new Intent(ProfileActivity.this, HomeActivity.class);
                        startActivity(intentMenu);
                        break;
                    case R.id.ic_notify:
                        Intent intentProfile = new Intent(ProfileActivity.this, ActivityNotify.class);
                        startActivity(intentProfile);
                        break;
                    case R.id.ic_profile:
                        break;
                }
                return false;
            }
        });


        setupAccountSettingsToolbar();
        setupFoodPreferenceToolbar();
    }

    // Setting up Account Settings Toolbar
    private void setupAccountSettingsToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = (ImageView) findViewById(R.id.profileSettings);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.d(TAG, "onClick: navigating to account settings.");
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    // Setting up Food Preference Toolbar
    private void setupFoodPreferenceToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = (ImageView) findViewById(R.id.food_preference);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.d(TAG, "onClick: navigating to food preferences.");
                Intent intent = new Intent(mContext, FoodPreferenceActivity.class);
                startActivity(intent);
            }
        });
    }

}
