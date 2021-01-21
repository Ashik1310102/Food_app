package com.example.ashik.food_order;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Registration extends AppCompatActivity {
    Button BtRegistration;
    EditText EtRegPassword,EtRegEmail;
    String email,password;
    ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;
    private PhoneAuthProvider phoneAuthProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        BtRegistration = findViewById(R.id.BtRegistration);
        EtRegPassword = findViewById(R.id.EtRegPassword);
        EtRegEmail = findViewById(R.id.EtRegEmail);

        firebaseAuth = FirebaseAuth.getInstance();
        phoneAuthProvider = PhoneAuthProvider.getInstance();

        progressBar = new ProgressBar(this);

        BtRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = EtRegEmail.getText().toString().trim();
                password = EtRegPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ) {

                    if (TextUtils.isEmpty(email)) {

                        EtRegEmail.setError("Please Enter Email ");
                    }
                    if (TextUtils.isEmpty(password)) {

                        EtRegPassword.setError("Please Enter Password");
                    }
                }
                else{


                }

            }
        });
    }
}
