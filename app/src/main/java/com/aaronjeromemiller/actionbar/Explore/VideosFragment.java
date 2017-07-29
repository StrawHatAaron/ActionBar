package com.aaronjeromemiller.actionbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by aaronmiller on 7/25/17.
 */

public class VideosFragment extends Fragment {
    private static final String TAG = "VideosFragment";

    private Button btnTEST;

    private TextView title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videos_fragment,container,false);
        btnTEST = (Button) view.findViewById(R.id.btnTEST);

        title = (TextView) view.findViewById(R.id.textTabVideos);
        title.setText("Tab Videos");

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 1",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
