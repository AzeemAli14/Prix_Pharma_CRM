package com.prixpharma.crm.Fragments;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import androidx.fragment.app.Fragment;

import com.prixpharma.crm.R;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class SalesFragment extends Fragment {

    private EditText editText1;
    private EditText editText2;
    private DatePickerDialog.OnDateSetListener mDate;
    static final int Dialog_ID = 0;
    int minute_x;
    int hour_x;

    public SalesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sales, container, false);


        editText1 =  v.findViewById(R.id.editdate);
        editText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int date = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDate, date, month, year);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d("Date", "onDateSet: dd/mm/yy: " + dayOfMonth + " / " + month + " / " + year);
                String date = dayOfMonth + " / " + month + " / " + year;
                editText1.setText(date);
            }
        };
        editText2 = v.findViewById(R.id.editTime);
        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        editText2.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
                //mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });


        return v;
    }
}