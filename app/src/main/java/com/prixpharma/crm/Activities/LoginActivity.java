package com.prixpharma.crm.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.prixpharma.crm.R;

public class LoginActivity extends AppCompatActivity {

    private Button btn;
    private EditText login;
    private EditText password;
    private FirebaseAuth auth;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dialog = new ProgressDialog(this);
        auth = FirebaseAuth.getInstance();
        btn = findViewById(R.id.btnlog);
        login = findViewById(R.id.loginedit);
        password = findViewById(R.id.passedit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Mlogin= login.getText().toString().trim();
                String Mpassword= password.getText().toString().trim();

                if(Mlogin.isEmpty())
                {
                    login.setError("Required Field");
                    return;
                }

                if(Mpassword.isEmpty())
                {
                    password.setError("Required Field");
                    return;
                }

                dialog.setMessage("Processing...");
                dialog.show();

                auth.signInWithEmailAndPassword(Mlogin, Mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                            startActivity(intent);
                        }

                        else
                        {
                            Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });
            }
        });
    }
}
