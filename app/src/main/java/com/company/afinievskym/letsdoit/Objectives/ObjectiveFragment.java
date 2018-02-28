package com.company.afinievskym.letsdoit.Objectives;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.afinievskym.letsdoit.R;

/**
 * Created by Programmer on 28.02.2018.
 */

public class ObjectiveFragment extends Fragment {
    //Нужный мне фрагмент пока этот не доделал переписать
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_objective_fragment, container, false);

        return view;
    }
}
