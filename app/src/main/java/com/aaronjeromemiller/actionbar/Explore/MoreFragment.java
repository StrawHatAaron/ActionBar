package com.aaronjeromemiller.actionbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/**
 * Created by aaronmiller on 7/25/17.
 */

public class MoreFragment extends Fragment{
    private static final String TAG = "MoreFragment";

    private Button btnTEST;
    private Button logOut;

    public MoreFragment() {
        this.btnTEST = btnTEST;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.more_fragment,container,false);
        btnTEST = (Button) view.findViewById(R.id.btnTEST);
        logOut = (Button) view.findViewById(R.id.log_out_btn);

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 1",Toast.LENGTH_SHORT).show();
            }
        });

        /*
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //auth.signOut();
                AuthUI.getInstance()
                        .signOut()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.d("MoreFragment", "sign out");
                            }
                        });
            }
        });
        */

        return view;
    }
}