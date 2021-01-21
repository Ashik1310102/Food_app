package com.example.ashik.food;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Registration extends AppCompatActivity implements ValueEventListener {

    EditText name,phone,username,password;
    String nameV,phoneV,usernameV,passwordV;
    Button regBT;

    private FirebaseDatabase nfirebaseDatabase =FirebaseDatabase.getInstance();
    private DatabaseReference ndatabaseReference = nfirebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name= findViewById(R.id.name);
        phone= findViewById(R.id.phone);
        username= findViewById(R.id.username);
        password= findViewById(R.id.password);

        regBT= findViewById(R.id.regBT);

        regBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameV=name.getText().toString();
                phoneV=phone.getText().toString();
                usernameV=username.getText().toString();
                passwordV=password.getText().toString();

                ndatabaseReference.child("user").child(usernameV).child("name").setValue(nameV);
                ndatabaseReference.child("user").child(usernameV).child("Phone").setValue(phoneV);
                ndatabaseReference.child("user").child(usernameV).child("name").setValue(nameV);
                ndatabaseReference.child("user").child(usernameV).child("password").setValue(passwordV);

                name.setText("");
                phone.setText("");
                username.setText("");
                password.setText("");

            }
        });
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

    }
}
