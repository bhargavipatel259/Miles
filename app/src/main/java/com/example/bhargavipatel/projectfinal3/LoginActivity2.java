package com.example.bhargavipatel.projectfinal3;

/**
 * Created by twisha on 04-03-2017.
 *
 * explore pachinu page,login vaalu page
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.widget.SearchViewCompatIcs;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


public class LoginActivity2 extends AppCompatActivity {

    String email, password,email2;
    EditText em,pass;
    Button s,r;
    int flag=0;
    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;
  //private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        em = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        s = (Button) findViewById(R.id.submit);
        r = (Button) findViewById(R.id.register);


        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (em.getText().toString().length() == 0) {
                    flag = 1;
                    em.setError("Email is required");
                }
                else   if (pass.getText().toString().length() == 0) {
                    flag = 1;
                    pass.setError("Password required");
                }

                else
                {
                    email = em.getText().toString();
                    password = pass.getText().toString();
                    email2=email.replace(".","");


                    checkUser();



                }

            }

        });

        r.setOnClickListener(new View.OnClickListener() {

                                 @Override
                                 public void onClick(View view) {
                                     Intent i = new Intent(LoginActivity2.this,Registration.class);
                                     startActivity(i);
                                 }

                             }
        );


    }
    void checkUser()
    {
        final ProgressDialog loading;
        loading=new ProgressDialog(LoginActivity2.this);
        loading.setCancelable(false);
        loading.setTitle("Please Wait....");

        loading.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        loading.show();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");
        DatabaseReference inref=myRef.child(email2+"_"+password);

        inref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getValue()== null)
                {
                    Toast.makeText(getApplicationContext(),"Wrong user id and pass", Toast.LENGTH_LONG).show();
                    loading.dismiss();
                }
                else
                {
                    loading.dismiss();
                    Map<String,Object> recdata=(Map<String, Object>)dataSnapshot.getValue();
                    Toast.makeText(getApplicationContext(),"User name : "+recdata.get("Name"), Toast.LENGTH_LONG).show();
                    Myapplication.uid=email2;
                    Myapplication.upass=password;
                    Myapplication.address= (String) recdata.get("Address");
                    Myapplication.mobile=(String) recdata.get("Mobile");
                    Myapplication.dob=recdata.get("DOB").toString();
                    Myapplication.name=recdata.get("Name").toString();
                    Myapplication.gender=recdata.get("Gender").toString();
                    

                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(LoginActivity2.this,HomepageActivity.class);
        startActivity(i);
        }
    }



