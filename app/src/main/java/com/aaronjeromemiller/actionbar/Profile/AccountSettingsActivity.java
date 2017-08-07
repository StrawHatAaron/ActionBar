package com.aaronjeromemiller.actionbar.Profile;


import android.support.annotation.Nullable;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.aaronjeromemiller.actionbar.R;
import com.aaronjeromemiller.actionbar.Utils.BottomNavigationViewHelper;
import com.aaronjeromemiller.actionbar.Utils.BottomNavigationViewEx;

/**
 * Created by Nicole's PC on 8/6/2017.
 */

public class AccountSettingsActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingsActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);
        Log.d(TAG, "onCreate: started.");
    }
}
