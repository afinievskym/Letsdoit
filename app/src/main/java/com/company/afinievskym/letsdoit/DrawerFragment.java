package com.company.afinievskym.letsdoit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Locale;

/**
 * Created by Programmer on 07.02.2018.
 */

public class DrawerFragment extends Fragment {
    public static final String Task_NUMBER = "task_number";

    public DrawerFragment() {
        // Для фрагмента требуется пустой конструктор
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.drawerfragment, container, false);
        int i = getArguments().getInt(Task_NUMBER);
        String menuItems = getResources().getStringArray(R.array.MyMenu)[i];
        getActivity().setTitle(menuItems);
        return rootView;
    }
}
