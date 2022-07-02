package com.prixpharma.crm.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.prixpharma.crm.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CampaignFragment extends Fragment {

    private EditText editText;
    String[] listItems;

    public CampaignFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_campaign, container, false);
        final EditText editText = (EditText) v.findViewById(R.id.type1);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems = new String[]{"Injections","Oral liquids","Bolus","Water soluble powder"};
                AlertDialog.Builder mBuilder2 = new AlertDialog.Builder(getContext());
                mBuilder2.setTitle("Chose Team Range");
                mBuilder2.setIcon(R.drawable.desicon);
                mBuilder2.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int j) {
                        editText.setText(listItems[j]);
                        dialog.dismiss();
                    }
                });
                AlertDialog mDialog = mBuilder2.create();
                mBuilder2.show();
            }
        });
        return v;
    }

}
