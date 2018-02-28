package com.company.afinievskym.letsdoit.Notes;

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

public class NotesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notes, container, false);

        return view;
    }
}
