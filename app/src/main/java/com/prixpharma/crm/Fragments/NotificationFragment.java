package com.prixpharma.crm.Fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prixpharma.crm.Adapters.Adapter;
import com.prixpharma.crm.Model.ModelClass;
import com.prixpharma.crm.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {


    public NotificationFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notification, container, false);

        recyclerView = v.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        List<ModelClass> modelClassList = new ArrayList<>();
        modelClassList.add(new ModelClass(R.mipmap.ic_launcher_round, "user one", "Hello this is user one"));
        modelClassList.add(new ModelClass(R.mipmap.ic_launcher_round, "user two", "Hello this is user two"));
        modelClassList.add(new ModelClass(R.mipmap.ic_launcher_round, "user three", "Hello this is user three"));
        modelClassList.add(new ModelClass(R.mipmap.ic_launcher_round, "user four", "Hello this is user four"));
        modelClassList.add(new ModelClass(R.mipmap.ic_launcher_round, "user five", "Hello this is user five"));
        modelClassList.add(new ModelClass(R.mipmap.ic_launcher_round, "user six", "Hello this is user six"));
        modelClassList.add(new ModelClass(R.mipmap.ic_launcher_round, "user seven", "Hello this is user seven"));
        modelClassList.add(new ModelClass(R.mipmap.ic_launcher_round, "user eight", "Hello this is user eight"));
        modelClassList.add(new ModelClass(R.mipmap.ic_launcher_round, "user nine", "Hello this is user nine"));
        modelClassList.add(new ModelClass(R.mipmap.ic_launcher_round, "user ten", "Hello this is user ten"));

        Adapter adapter = new Adapter(modelClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return v;
    }

}
