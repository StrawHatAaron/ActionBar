package com.aaronjeromemiller.actionbar;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;

/**
 * Created by aaronmiller on 7/29/17.
 */

public class AmazonWebServices extends AppCompatActivity {
    private String identityId;
    private static final String TAG = "AmazonWebServices";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_login);

        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(), // Context
                "us-east-1_szCnjXzd9", // Identity Pool ID
                Regions.US_EAST_1 // Region
        );

        String identityId = credentialsProvider.getIdentityId();
        Log.d("LogTag", "my ID is " + identityId);

    }



}
