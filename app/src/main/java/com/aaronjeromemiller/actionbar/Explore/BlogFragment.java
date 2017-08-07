package com.aaronjeromemiller.actionbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aaronjeromemiller.actionbar.R;

import java.util.ArrayList;

import static com.aaronjeromemiller.actionbar.R.id.blog_list_view;

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
        mListView = (ListView) view.findViewById(blog_list_view);

        ArrayList<com.aaronjeromemiller.actionbar.Card> list;
        list = new ArrayList<>();

        list.add(new com.aaronjeromemiller.actionbar.Card("drawable://" + R.drawable.chickentikkamasala, "Chicken Tikka Masala"));
        list.add(new com.aaronjeromemiller.actionbar.Card("drawable://" + R.drawable.heartybeefstew410x274, " Hearty Beef Stew"));
        list.add(new com.aaronjeromemiller.actionbar.Card("drawable://" + R.drawable.foodonfork, "Garlic Chicken"));
        list.add(new com.aaronjeromemiller.actionbar.Card("drawable://" + R.drawable.heartybeefstew1200x630, "Beef Stew"));
        list.add(new com.aaronjeromemiller.actionbar.Card("drawable://" + R.drawable.carneasadalime, "Steak and Lime"));
        list.add(new com.aaronjeromemiller.actionbar.Card("drawable://" + R.drawable.yucatanpork, "Yucatan Pulled Pork"));
        list.add(new com.aaronjeromemiller.actionbar.Card("drawable://" + R.drawable.carneasadaoverlettuce, "Sliced Steak Over Lettuce"));

        com.aaronjeromemiller.actionbar.CustomListAdapter adapter = new com.aaronjeromemiller.actionbar.CustomListAdapter(getActivity(), R.layout.card_layout, list);
        mListView.setAdapter(adapter);

        return view;
    }
}
