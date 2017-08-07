package com.aaronjeromemiller.actionbar;

import android.content.Context;
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

import com.aaronjeromemiller.actionbar.Login.LoginActivity;
import com.aaronjeromemiller.actionbar.Menu.MenuActivity;
import com.aaronjeromemiller.actionbar.Utils.BottomNavigationViewHelper;
import com.aaronjeromemiller.actionbar.Utils.SectionsPagerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ACTIVITY_NUM = 0;

    private Context mContext = MainActivity.this;

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupFirebaseAuth();
        setupBottomNavigationView();

        //signs out person on the device
        //when explore button is clicked it will sign the user back out
        //mAuth.signOut();
    }


    private void setupBottomNavigationView(){
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        Log.d(TAG, "before Tablayout set");
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
                switch (item.getItemId()) {
                    case R.id.ic_explore:
                        break;
                    case R.id.ic_menu:
                        Intent intentMenu = new Intent(MainActivity.this, MenuActivity.class);
                        startActivity(intentMenu);
                        break;
                    case R.id.ic_home:
                        Intent intentMain = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intentMain);
                        break;
                    case R.id.ic_notify:
                        Intent intentNotify = new Intent(MainActivity.this, ActivityNotify.class);
                        startActivity(intentNotify);
                        break;
                    case R.id.ic_profile:
                        Intent intentProfile = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(intentProfile);
                        break;
                }
                return false;
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new com.aaronjeromemiller.actionbar.BlogFragment());
        adapter.addFragment(new com.aaronjeromemiller.actionbar.VideosFragment());
        adapter.addFragment(new com.aaronjeromemiller.actionbar.MoreFragment());
        viewPager.setAdapter(adapter);
    }

/*
********************************** FIREBASE ***********************************
 */

    //setup firebase authentication
    private void setupFirebaseAuth() {

        Log.d(TAG, "setupFireBaseAuth: setting up firebase auth!");

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                //check if user logged in
                checkCurrentUser(user);

                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };
    }

    private void checkCurrentUser(FirebaseUser user){
        Log.d(TAG, "checkCurrentUser: checking if user is logged in");

        if (user == null){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            Log.d(TAG, "checkCurrentUser: user is not logged in");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
        checkCurrentUser(mAuth.getCurrentUser());
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}