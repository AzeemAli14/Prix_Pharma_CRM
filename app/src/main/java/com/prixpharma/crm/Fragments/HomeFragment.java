package com.prixpharma.crm.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.tabs.TabLayout;
import com.prixpharma.crm.R;
import com.prixpharma.crm.Adapters.Slide;
import com.prixpharma.crm.Adapters.SliderPagerAdapter;
import com.prixpharma.crm.Fragments.Activities.TabActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;



public class HomeFragment extends Fragment {

    private FloatingActionMenu menu;
    private FloatingActionButton fab;
    private List<Slide> slideList;
    private ViewPager slidePager;
    private TabLayout tabLayout;

    public HomeFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_home, container, false);
        menu = v.findViewById(R.id.fabmenu);
        fab = v.findViewById(R.id.fab_label);
        slidePager = v.findViewById(R.id.slider_pager);
        tabLayout = v.findViewById(R.id.indicator);

        slideList = new ArrayList<>();
        slideList.add(new Slide(R.drawable.prix1,"Making the difference"));
        slideList.add(new Slide(R.drawable.prix2,"We care for your animals"));
        slideList.add(new Slide(R.drawable.prix3,"Health || Prosperity || Productivity"));
        slideList.add(new Slide(R.drawable.prix4,"Leading you into the future"));
        slideList.add(new Slide(R.drawable.prix5,"Keeping your flocks healthy and profitable"));
        slideList.add(new Slide(R.drawable.prix6,"WE GROW TOGETHER"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(getContext(), slideList);
        slidePager.setAdapter(adapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeFragment.slideTimer(),4000, 6000);

        tabLayout.setupWithViewPager(slidePager,true);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext(), TabActivity.class));
            }
        });

        return v;
    }

    class slideTimer extends TimerTask {
        @Override
        public void run() {
            if (getActivity() != null) {
                getActivity().runOnUiThread(() -> {
                    if (slidePager.getCurrentItem() < slideList.size() - 1) {
                        slidePager.setCurrentItem(slidePager.getCurrentItem() + 1);
                    } else {
                        slidePager.setCurrentItem(0);
                    }
                });
            }
        }
    }

}
