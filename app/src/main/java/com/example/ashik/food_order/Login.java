package com.example.ashik.food_order;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView TxRegistration;
    Button BtLogIn;
    EditText EtPassword,EtEmail;
    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TxRegistration = findViewById(R.id.TxRegistration);
        BtLogIn = findViewById(R.id.BtLogin);
        EtPassword = findViewById(R.id.EtPassword);
        EtEmail = findViewById(R.id.EtEmail);

        TxRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Login.this,Registration.class);
                startActivity(mainIntent);
                Login.this.finish();
            }
        });

        BtLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = EtEmail.getText().toString();
                password = EtPassword.getText().toString();

            }
        });



    }
}
