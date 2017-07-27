package com.aaronjeromemiller.actionbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by aaronmiller on 7/25/17.
 */

public class BlogFragment extends Fragment{
    private static final String TAG = "BlogFragment";

    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.blog_fragment,container,false);
        mListView = (ListView) view.findViewById(R.id.listView);

        ArrayList<Card> list = new ArrayList<>();

        list.add(new Card("drawable//" + R.drawable.chickentikkamasala, "Chicken Tikka Masala"));
        list.add(new Card("drawable//" + R.drawable.heartybeefstew410x274, " Hearty Beef Stew"));
        list.add(new Card("drawable//" + R.drawable.foodonfork, "Garlic Chicken"));
        list.add(new Card("drawable//" + R.drawable.heartybeefstew1200x630, "Beef Stew"));
        list.add(new Card("drawable//" + R.drawable.carneasadalime, "Steak and Lime"));
        list.add(new Card("drawable//" + R.drawable.yucatanpork, "Yucatan Pulled Pork"));
        list.add(new Card("drawable//" + R.drawable.carneasadaoverlettuce, "Sliced Steak Over Lettuce"));

        CustomListAdapter adapter = new CustomListAdapter(getActivity(), R.layout.activity_main, list);
        mListView.setAdapter(adapter);
        return view;
    }
}
