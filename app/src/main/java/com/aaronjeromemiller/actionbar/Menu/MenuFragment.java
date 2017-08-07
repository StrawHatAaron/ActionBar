package com.aaronjeromemiller.actionbar.Menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aaronjeromemiller.actionbar.R;

import java.util.ArrayList;

import static com.aaronjeromemiller.actionbar.R.id.menu_list_view;
//import static com.aaronjeromemiller.actionbar.R.id.menu_layout;

/**
 * Created by aaronmiller on 8/5/17.
 */

public class MenuFragment  extends Fragment {
    private static final String TAG = "BlogFragment";

    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment,container,false);
        mListView = (ListView) view.findViewById(menu_list_view);

        ArrayList<Menu> list;
        list = new ArrayList<>();

        list.add(new Menu("drawable://" + R.drawable.chickentikkamasala, "Chicken Tikka Masala", "Awesome food is described here"));
        list.add(new Menu("drawable://" + R.drawable.heartybeefstew410x274, " Hearty Beef Stew", "Awesome food is described here"));
        list.add(new Menu("drawable://" + R.drawable.foodonfork, "Garlic Chicken", "Awesome food is described here"));
        list.add(new Menu("drawable://" + R.drawable.heartybeefstew1200x630, "Beef Stew", "Awesome food is described here"));
        list.add(new Menu("drawable://" + R.drawable.carneasadalime, "Steak and Lime", "Awesome food is described here"));
        list.add(new Menu("drawable://" + R.drawable.yucatanpork, "Yucatan Pulled Pork", "Awesome food is described here"));
        list.add(new Menu("drawable://" + R.drawable.carneasadaoverlettuce, "Sliced Steak Over Lettuce", "Awesome food is described here"));

        com.aaronjeromemiller.actionbar.MenuListAdapter adapter = new com.aaronjeromemiller.actionbar.MenuListAdapter(getActivity(), R.layout.menu_layout, list);
        mListView.setAdapter(adapter);

        return view;
    }
}

