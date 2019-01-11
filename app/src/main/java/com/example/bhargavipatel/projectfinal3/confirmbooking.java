package com.example.bhargavipatel.projectfinal3;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

public class confirmbooking extends AppCompatActivity implements
        licenseupload.OnFragmentInteractionListener,
        payment.OnFragmentInteractionListener,
        confirmbooking_frag.OnFragmentInteractionListener{

    TextView city,area,cname,cac,cpet,cnum,cseats,csdate,cedate;
    Button b;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmbooking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fm=getSupportFragmentManager(); 
        fm.beginTransaction().replace(R.id.mycont,new confirmbooking_frag()).commit();

       /* city = (TextView)findViewById(R.id.city);
        area = (TextView)findViewById(R.id.area);
        cname = (TextView)findViewById(R.id.cname);
        cac = (TextView)findViewById(R.id.cac);
        cpet =(TextView)findViewById(R.id.cpet);
        cnum =(TextView)findViewById(R.id.cnum);
        cseats = (TextView)findViewById(R.id.cseats);
        csdate=(TextView)findViewById(R.id.csdate);
        cedate=(TextView)findViewById(R.id.cedate);
        b=(Button)findViewById(R.id.cbook);
        fm=getSupportFragmentManager();



        city.setText(Myapplication.carcity);
        area.setText(Myapplication.cararea);
        cname.setText(Myapplication.carname);
        cac.setText(Myapplication.cartype);
        cnum.setText(Myapplication.carnum);
        cseats.setText(Myapplication.carseat);
        csdate.setText(Myapplication.sdate);
        cedate.setText(Myapplication.edate);
        cpet.setText(Myapplication.cartype2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fm.beginTransaction().replace(R.id.mycont,new payment()).commit();

            }
        });


*/


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
