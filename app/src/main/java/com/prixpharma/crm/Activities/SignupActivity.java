package com.prixpharma.crm.Activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.prixpharma.crm.R;
//import com.wang.avi.AVLoadingIndicatorView;
import java.util.Calendar;

public class SignupActivity extends AppCompatActivity {

    private Button btnS;
    private TextView txt4;
    private EditText birth;
    private EditText name;
    private EditText mail;
    private EditText pass;
    private EditText num;
    private DatePickerDialog.OnDateSetListener mDate;
    String[] listItems1;
    String[] listItems2;
    private EditText desig;
    private EditText rang;
    private FirebaseAuth auth;
    private Dialog dialog;
    private ProgressDialog pdialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        pdialog = new ProgressDialog(this);
        auth = FirebaseAuth.getInstance();
        name = findViewById(R.id.editname);
        mail = findViewById(R.id.editemail);
        pass = findViewById(R.id.editpass);
        num = findViewById(R.id.editnum);
        rang = findViewById(R.id.editteam);
        rang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems2 = new String[]{"Blue", "Green", "Orange", "Red", "Yellow", "Ocean"};
                AlertDialog.Builder mBuilder2 = new AlertDialog.Builder(SignupActivity.this);
                mBuilder2.setTitle("Choose Team Range");
                mBuilder2.setIcon(R.drawable.desicon);
                mBuilder2.setSingleChoiceItems(listItems2, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int j) {
                        rang.setText(listItems2[j]);
                        dialog.dismiss();
                    }
                });
                AlertDialog mDialog = mBuilder2.create();
                mBuilder2.show();
            }
        });
        txt4 = findViewById(R.id.text4);
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        desig = findViewById(R.id.editdes);
        desig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems1 = new String[]{"Sales Person", "Zonal Manager", "National Sales Manager"};
                AlertDialog.Builder mBuilder1 = new AlertDialog.Builder(SignupActivity.this);
                mBuilder1.setTitle("Choose Designation");
                mBuilder1.setIcon(R.drawable.desicon);
                mBuilder1.setSingleChoiceItems(listItems1, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        desig.setText(listItems1[i]);
                        dialog.dismiss();
                    }
                });
                AlertDialog mDialog = mBuilder1.create();
                mBuilder1.show();

            }
        });

        birth = findViewById(R.id.editbirth);
        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int date = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                DatePickerDialog dialog=new DatePickerDialog(SignupActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDate, date, month, year);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                Log.d("Date","onDateSet: dd/mm/yy: " + dayOfMonth + " / " + month + " / " + year);
                String date = dayOfMonth + " / " + month + " / " + year;
                birth.setText(date);
            }
        };

        btnS=(Button) findViewById(R.id.btnsign);
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Mname= name.getText().toString().trim();
                if(TextUtils.isEmpty(Mname))
                {
                    name.setError("Required Field");
                    return;
                }
                String Mmail= mail.getText().toString().trim();
                if(TextUtils.isEmpty(Mmail))
                {
                    mail.setError("Required Field");
                    return;
                }
                String Mpass= pass.getText().toString().trim();
                if(TextUtils.isEmpty(Mpass))
                {
                    pass.setError("Required Field");
                    return;
                }
                String Mnum= num.getText().toString().trim();
                if(TextUtils.isEmpty(Mnum))
                {
                    num.setError("Required Field");
                    return;
                }
                String Mbirth = birth.getText().toString().trim();
                if (TextUtils.isEmpty(Mbirth))
                {
                    birth.setError("Required Field");
                }
                String Mdesig = desig.getText().toString().trim();
                if (TextUtils.isEmpty(Mdesig))
                {
                    desig.setError("Required Field");
                }
                String Mresig = rang.getText().toString().trim();
                if (TextUtils.isEmpty(Mresig))
                {
                    rang.setError("Required Field");
                }

                pdialog.setMessage("Creating Account...");
                pdialog.show();

                auth.createUserWithEmailAndPassword(Mmail, Mpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(SignupActivity.this, "Registered Successful", Toast.LENGTH_SHORT).show();
                            pdialog.dismiss();
                            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(SignupActivity.this, "Registered Unsuccessful", Toast.LENGTH_SHORT).show();
                            pdialog.dismiss();
                        }
                    }
                });
            }
        });
    }
}
