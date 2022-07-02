package com.prixpharma.crm.Fragments;


import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.alamkanak.weekview.WeekView;
import com.prixpharma.crm.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgendaFragment extends Fragment {


    public AgendaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notification, container, false);


        return v;
    }

}
