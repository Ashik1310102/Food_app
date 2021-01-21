package com.example.ashik.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity implements ValueEventListener {
    EditText userName,Password;
    TextView regBT;

    Button loginBT;

    int ok=0;

    String UserNameValue,Passwordvalue;

    private FirebaseDatabase mfirebaseDatabase =FirebaseDatabase.getInstance();
    private DatabaseReference mdatabaseReference = mfirebaseDatabase.getReference();
//    private DatabaseReference mtable = mdatabaseReference.child("userTabb");
//    private DatabaseReference mUserNameCollam = mtable.child("userCollam");
//    private DatabaseReference mUser = mUserNameCollam.child("UserName");
//    private DatabaseReference mPassword = mUserNameCollam.child("Password");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        loginBT = findViewById(R.id.loginBT);
        regBT = findViewById(R.id.regBT);

        regBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });


        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserNameValue = userName.getText().toString();
                Passwordvalue = Password.getText().toString();

                if(chakeData()==1){
                    Toast.makeText(Login.this,"Problem",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Login.this,"Ok",Toast.LENGTH_LONG).show();
                    String userid = String.valueOf(ok);
                    mdatabaseReference.child("user").child(userid).child("username").setValue(UserNameValue);
                    mdatabaseReference.child("user").child(userid).child("password").setValue(Passwordvalue);

//                    mUser.setValue(UserNameValue);
//                    mPassword.setValue(Passwordvalue);

                    ok++;

//                    new Handler().postDelayed(new Runnable(){
//                        @Override
//                        public void run() {
//
//                            userName.setText(null);
//                            Password.setText(null);
//
////                            Intent mainIntent = new Intent(Login.this,Home.class);
////                            startActivity(mainIntent);
//
//                        }
//                    }, 1000);
                }
            }
        });



    }

    public int chakeData(){
        int i=0;
        if(UserNameValue.length()<5){
            userName.setError("mandetory filed");
            i=1;

        }
        if(Passwordvalue.length()<5){
            Password.setError("mandetory filed");
            i=1;

        }

        return i;



    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    @Override
    protected void onStart() {
        super.onStart();
//        mUser.addValueEventListener(this);
//        mPassword.addValueEventListener(this);
    }
}
