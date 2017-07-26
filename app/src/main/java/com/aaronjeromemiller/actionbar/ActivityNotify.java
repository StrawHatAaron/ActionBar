package com.aaronjeromemiller.actionbar;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by aaronmiller on 7/26/17.
 */

public class ActivityNotify extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.notify_activity);

        TextView title = (TextView) findViewById(R.id.notifyTitle);
        title.setText("Notifications");
    }
}
