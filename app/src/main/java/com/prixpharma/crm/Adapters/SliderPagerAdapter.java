package com.prixpharma.crm.Adapters;

import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.prixpharma.crm.R;

import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {

    private Context context;
    private List<Slide> list;

    public SliderPagerAdapter(Context context, List<Slide> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout = inflater.inflate(R.layout.slider_item, null);
        ImageView slideImage = slideLayout.findViewById(R.id.slide_img);
        TextView slideText = slideLayout.findViewById(R.id.slider_title);
        slideImage.setImageResource(list.get(position).getImage());
        slideText.setText(list.get(position).getTitle());
        container.addView(slideLayout);
        return slideLayout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
