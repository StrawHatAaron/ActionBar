package com.aaronjeromemiller.actionbar.Profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.aaronjeromemiller.actionbar.R;

/**
 * Created by Nicole's PC on 8/12/2017.
 */

public class FoodPreferenceActivity extends AppCompatActivity {

    TextView final_result;
    private static final String TAG = "FoodPreferenceActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodpreference);

        final_result = (TextView)findViewById(R.id.select_result);
        final_result.setEnabled(false);

        Log.d(TAG, "onCreate: started.");


        // Set up back arrow for navigating back to "ProfileActivity"
        ImageView backArrow = (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating back to 'ProfileActivity'");
                finish();
            }
        });
    }


    public void selectFoodPreference(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId())
        {
            case R.id.radio_vegan:
                if(checked)
                {
                    final_result.setText("Current Saved Preference: Vegan");
                    final_result.setEnabled(true);
                }
                else
                {
                    final_result.setEnabled(false);
                }
                break;
            case R.id.radio_vegetarian:
                if(checked)
                {
                    final_result.setText("Current Saved Preference: Vegetarian");
                    final_result.setEnabled(true);

                }
                else
                {
                    final_result.setEnabled(false);
                }
                break;
            case R.id.radio_paleotarian:
                if(checked)
                {
                    final_result.setText("Current Saved Preference: Paleotarian");
                    final_result.setEnabled(true);

                }
                else
                {
                    final_result.setEnabled(false);
                }
                break;
            case R.id.radio_pescatarian:
                if(checked)
                {
                    final_result.setText("Current Saved Preference: Pescatarian");
                    final_result.setEnabled(true);

                }
                else
                {
                    final_result.setEnabled(false);
                }
                break;

            case R.id.radio_omnivore:
                if(checked)
                {
                    final_result.setText("Current Saved Preference: Omnivore");
                    final_result.setEnabled(true);

                }
                else
                {
                    final_result.setEnabled(false);
                }
                break;
            case R.id.radio_other:
                if(checked)
                {
                    final_result.setEnabled(true);


                }
                else
                {
                    final_result.setEnabled(false);
                }
                break;

        }
    }
}

