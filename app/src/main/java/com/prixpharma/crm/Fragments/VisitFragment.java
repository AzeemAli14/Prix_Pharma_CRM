package com.prixpharma.crm.Fragments;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.prixpharma.crm.R;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class VisitFragment extends Fragment {

    private EditText editText;
    private Button Vbtn;
    private DatePickerDialog.OnDateSetListener mDate;

    public VisitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_visit, container, false);
        editText = v.findViewById(R.id.edical);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    initCalendar();
                }

            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCalendar();
            }
        });

        Vbtn = v.findViewById(R.id.btnv);
        Vbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CampaignFragment.class));
            }
        });


        mDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                Log.d("Date","onDateSet: dd/mm/yy: " + dayOfMonth + " / " + month + " / " + year);
                String date = dayOfMonth + " / " + month + " / " + year;
                editText.setText(date);
            }
        };
        return v;
    }

    public void initCalendar(){

        Calendar cal = Calendar.getInstance();
        int date = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        DatePickerDialog dialog=new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDate, date, month, year);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

}
