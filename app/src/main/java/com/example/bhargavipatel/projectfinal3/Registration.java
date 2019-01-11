package com.example.bhargavipatel.projectfinal3;

/**
 * Created by bhargavipatel on 3/7/17.
 */


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {
    EditText nm, em, ps, rps, ph, ad, b;
    Date date2,date3;
    Button r, s;
    CheckBox ch;
    RadioButton m, f;
    String name , email, password, mobile, address,email2, birthdate,gender,curdate;
    int flag = 0, checkbox = 1,gen,flag2=1;
   private Pattern pattern1,pattern2;
    private Matcher matcher1;



    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nm = (EditText) findViewById(R.id.name);
        b = (EditText) findViewById(R.id.birth);
        ad = (EditText) findViewById(R.id.add);
        em = (EditText) findViewById(R.id.email);
        ps = (EditText) findViewById(R.id.pass);
        rps = (EditText) findViewById(R.id.pass2);
        ph = (EditText) findViewById(R.id.num);
        ch = (CheckBox) findViewById(R.id.check);

        s = (Button) findViewById(R.id.submit);
        r = (Button) findViewById(R.id.reset);

        m = (RadioButton) findViewById(R.id.radio1);
        f = (RadioButton) findViewById(R.id.radio2);
         curdate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

     //   Toast.makeText(getApplicationContext(),curdate,Toast.LENGTH_LONG).show();




        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nm.getText().toString().length() == 0) {
                    flag = 1;
                    nm.setError("Name is required");
                }
                if(!nm.getText().toString().matches("[a-zA-Z ]+"))
                {
                    flag=1;
                    nm.setError("Name can only have alphabets");
                }
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(em.getText().toString()).matches())
                {
                    flag=1;
                    em.setError("Email Id is invalid");
                }

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try {
                     date2 = format.parse(b.getText().toString());
                     date3=format.parse(curdate);

                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                }

               //Birthday validator
                if(date2.after(date3))
                {
                    flag=1;
                    b.setError("Birthdate is invalid");
                }

              if(!b.getText().toString().matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$"))
                {
                    flag=1;
                    b.setError("Birthdate is in(dd/mm/yyyy) format");
                }

                if (ad.getText().toString().length() == 0) {
                    flag = 1;
                    ad.setError("Address is required");
                }
                if (ph.getText().toString().length() <10) {
                    flag = 1;
                    ph.setError("Mobile number is required");
                }
                if (ph.getText().toString().length() > 10) {
                    flag = 1;
                    ph.setError("Mobile number is invalid");
                }
                if (em.getText().toString().length() == 0) {
                    flag = 1;
                    em.setError("Email is required");
                }
                if (b.getText().toString().length() == 0) {
                    flag = 1;
                    b.setError("Birthdate is required");
                }

                if (ps.getText().toString().length() == 0) { 
                    flag = 1;
                    ps.setError("Password required");
                }

             /*   if (!b.getText().toString().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")) {
                    flag = 1;
                    ps.setError("Password should have one number,one alphabet,one special character and it should be between length of 6-20 characters");
                }*/
                if (!rps.getText().toString().equals(ps.getText().toString())) {
                    rps.setText(null);
                    flag = 1;
                    rps.setError("Password is not correct");
                }
                if (rps.getText().toString().length() == 0) {
                    flag = 1;
                    rps.setError("Password not Entered");
                }
                if (!rps.getText().toString().equals(ps.getText().toString())) {
                    //rps.setText(null);
                    flag = 1;
                    rps.setError("Password is not correct");
                }
                if (rps.getText().toString().length() == 0) {
                    flag = 1;
                    rps.setError("Password not Entered");
                }



                if (ch.isChecked()) {
                    flag2 = 0;
                }

                if (flag == 0)
                {
                    name = nm.getText().toString().toLowerCase();
                    email = em.getText().toString().toLowerCase();
                    password = ps.getText().toString().toLowerCase();
                    mobile = ph.getText().toString().toLowerCase();
                    address = ad.getText().toString().toLowerCase();
                    birthdate = b.getText().toString().toLowerCase();
                    email2=email.replace(".","");
                    Toast.makeText(getApplicationContext(),"Values "+name+email+password,Toast.LENGTH_LONG).show();
                    if (m.isChecked()) {
                        gender = "Male";
                    }
                    else {

                        gender = "Female";
                    }

                    setSignup();
                    Intent i = new Intent(Registration.this,MainActivity.class);
                    startActivity(i);
                }



            }});




        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm.setText(null);
                em.setText(null);
                ad.setText(null);
                b.setText(null);
                ph.setText(null);
                ps.setText(null);
                rps.setText(null);


            }
        });
    }

  /*  public PasswordValidator(){
        pattern2 = Pattern.compile(PASSWORD_PATTERN);
    }



    public boolean validate(final String date){

        matcher1 = pattern1.matcher(date);

        if(matcher1.matches()){
            matcher1.reset();

            if(matcher1.find()){
                String day = matcher1.group(1);
                String month = matcher1.group(2);
                int year = Integer.parseInt(matcher1.group(3));

                if (day.equals("31") &&
                        (month.equals("4") || month .equals("6") || month.equals("9") ||
                                month.equals("11") || month.equals("04") || month .equals("06") ||
                                month.equals("09"))) {
                    return false; // only 1,3,5,7,8,10,12 has 31 days
                }

                else if (month.equals("2") || month.equals("02")) {
                    //leap year
                    if(year % 4==0){
                        if(day.equals("30") || day.equals("31")){
                            return false;
                        }
                        else{
                            return true;
                        }
                    }
                    else{
                        if(day.equals("29")||day.equals("30")||day.equals("31")){
                            return false;
                        }
                        else{
                            return true;
                        }
                    }
                }

                else{
                    return true;
                }
            }

            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    */
    void setSignup()
    {
        final ProgressDialog loading;
        loading=new ProgressDialog(Registration.this);
        loading.setCancelable(false);
        loading.setTitle("Please Wait....");

        loading.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        loading.show();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");

        Map<String,Object> data =new LinkedHashMap<>();
        data.put("Name",name);
        data.put("Address",address);
        data.put("Mobile",mobile);
        data.put("Gender",gender);
        data.put("Email",email);
        data.put("Password",password);
        data.put("DOB",birthdate);


        myRef.child(email2+"_"+password).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override

            public void onComplete(@NonNull Task<Void> task) {
                loading.dismiss();
                Toast.makeText(getApplicationContext(),"Successfully Registered",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Try again later",Toast.LENGTH_SHORT).show();

            }

        });
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(Registration.this,LoginActivity2.class);
        startActivity(i);
    }


}

