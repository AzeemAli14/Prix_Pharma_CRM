package com.prixpharma.crm.Adapters;

//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prixpharma.crm.Model.ModelClass;
import com.prixpharma.crm.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> modelClassList;

    public Adapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        int resource = modelClassList.get(i).getImageResource();
        String textView1 = modelClassList.get(i).getTitle();
        String textView2 = modelClassList.get(i).getBody();
        viewHolder.setData(resource, textView1, textView2);
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;

        public ViewHolder (@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            textView1 = itemView.findViewById(R.id.title);
            textView2 = itemView.findViewById(R.id.body);
        }

        private void setData(int resource, String titleText, String bodyText) {
            imageView.setImageResource(resource);
            textView1.setText(titleText);
            textView2.setText(bodyText);
        }
    }
}
