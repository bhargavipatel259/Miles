package com.example.bhargavipatel.projectfinal3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bhargavipatel.projectfinal3.dummy.DummyContent;
import com.example.bhargavipatel.projectfinal3.dummy.DummyContent2;
import com.example.bhargavipatel.projectfinal3.dummy.DummyContent3;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements   NavigationView.OnNavigationItemSelectedListener ,
        AdapterView.OnItemSelectedListener , Add_car.OnFragmentInteractionListener ,
        Search.OnFragmentInteractionListener , Demo.OnFragmentInteractionListener,
        profile.OnFragmentInteractionListener,
        profilecar.OnFragmentInteractionListener,
        sirdemoFragment.OnListFragmentInteractionListener,
        contactpg_frag.OnFragmentInteractionListener,

        licenseupload.OnFragmentInteractionListener,
        sirdemopetrolFragment.OnListFragmentInteractionListener,
        deleteFragment.OnListFragmentInteractionListener,profileCarfragFragment.OnListFragmentInteractionListener
{

    private RadioGroup radioGroup,radioGroup2;
    private RadioButton radioButton,radioButton2,radioButton21,radioButton22;
    private Button btnDisplay;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private DatePicker datePicker2;
    private Calendar calendar2;
    private TextView dateView2;
    private int year2, month2, day2;
    FragmentManager fm;
    String myEmail1,myPass1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);

        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        dateView2 = (TextView) findViewById(R.id.textView32);
        calendar2 = Calendar.getInstance();
        year2 = calendar2.get(Calendar.YEAR);

        month2 = calendar2.get(Calendar.MONTH);
        day2 = calendar2.get(Calendar.DAY_OF_MONTH);
        showDate2(year2, month2+1, day2);

        if(year2<year)
        {

            Toast.makeText(MainActivity.this,"error", Toast.LENGTH_LONG).show();
        }

        else if(year2==year)
        {
            if(month2<month)
            {
                Toast.makeText(MainActivity.this,"error", Toast.LENGTH_LONG).show();
            }

            if(month2==month)
            {
                if(day2<day)
                {
                    Toast.makeText(MainActivity.this,"error", Toast.LENGTH_LONG).show();
                }
            }
        }
*/
        fm=getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.mycont,new Search() ).commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    /*    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(i);
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


/*

// SPINNER FOR CITY
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Vadodara");
        categories.add("Ahmedabad");
        //categories.add("Computers");
        //categories.add("Education");
        //categories.add("Personal");
        //categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);







//SPINNER FOR AREA
        // Spinner click listener
        spinner2.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories2 = new ArrayList<String>();
        categories2.add("Manjalpur");
        categories2.add("Tarsali");
        categories2.add("Karelibaugh");
        categories2.add("Alkapuri");
        categories2.add("Sayajigunj");
        categories2.add("Fatehgunj");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner2.setAdapter(dataAdapter2);








//SPINNER FOR CARS
// Spinner click listener
        spinner3.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories3 = new ArrayList<String>();
        //categories3.add("Wagon R");
        //categories3.add("Amaze");
        //categories3.add("Zest");
        categories3.add("Honda City");
        //categories3.add("Cruze");
        //categories3.add("Audi R8");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3);

        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner3.setAdapter(dataAdapter3);
*/

       /* already commented
        //radio group for petrol diesel
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);

        radioButton = (RadioButton) findViewById(R.id.radioButton);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                Toast.makeText(MainActivity.this,"Selected: "+  radioButton.getText(), Toast.LENGTH_LONG).show();
            }
        });
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton2 = (RadioButton) findViewById(selectedId);
                Toast.makeText(MainActivity.this,"Selected: "+  radioButton2.getText(), Toast.LENGTH_LONG).show();
            }
        });*/


/*
//radio group for ac non ac
        radioGroup2=(RadioGroup)findViewById(R.id.radioGroup2);
        radioButton21 = (RadioButton) findViewById(R.id.radioButton21);

        // btnDisplay=(Button)findViewById(R.id.button);

        radioButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=radioGroup2.getCheckedRadioButtonId();
                radioButton21=(RadioButton)findViewById(selectedId);
                Toast.makeText(MainActivity.this,"Selected: "+ radioButton21.getText(),Toast.LENGTH_LONG).show();
            }
        });

        radioButton22 = (RadioButton) findViewById(R.id.radioButton22);
        radioButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=radioGroup2.getCheckedRadioButtonId();
                radioButton22=(RadioButton)findViewById(selectedId);
                Toast.makeText(MainActivity.this,"Selected: "+ radioButton22.getText(),Toast.LENGTH_LONG).show();
            }
        });

        Intent intent=this.getIntent();
        myEmail1 = intent.getStringExtra("email");
        myPass1=intent.getStringExtra("pass");
        getMyEmail();
        getMyPass();
*/

    }


   //datepicker

   /* void setDate4()
    {
        DialogFragment picker = new DatePickerFragment();
        picker.show(fm,"datepicker");
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(MainActivity.this, "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @SuppressWarnings("deprecation")
    public void setDate2(View view) {
        showDialog(998);
        Toast.makeText(MainActivity.this, "ca",
                Toast.LENGTH_SHORT)
                .show();
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        else if(id== 998)
        {
            return new DatePickerDialog(this,
                    myDateListener2, year2, month2, day2);
        }
        return null;

    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    //datepicker end date


    private DatePickerDialog.OnDateSetListener myDateListener2 = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate2(arg1, arg2 + 1, arg3);
                }
            };

    private void showDate2(int year, int month, int day) {
        dateView2.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }*/
    public String getMyEmail() {
        return(myEmail1);
    }
    public String getMyPass() {
        return(myPass1);
    }



    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.book_car) {
           // Intent i = new Intent(MainActivity.this, MainActivity.class);
            //startActivity(i);

            fm.beginTransaction().replace(R.id.mycont,new Search() ).commit();

        }
        else if (id == R.id.city_tour) {

            Intent i=new Intent(MainActivity.this,MainActivityMap.class);
            startActivity(i);

        }

        else if (id == R.id.add_car) {


            fm.beginTransaction().replace(R.id.mycont,new Add_car() ).commit();

        }

        else if (id == R.id.remove_car) {

            fm.beginTransaction().replace(R.id.mycont,new deleteFragment()).commit();

        }

        else if (id == R.id.profile) {

            fm.beginTransaction().replace(R.id.mycont,new profiletab2() ).commit();

        }


        else if (id == R.id.contact_us) {

            fm.beginTransaction().replace(R.id.mycont,new contactpg_frag() ).commit();

        }

        else if (id == R.id.help ) {

            Intent i=new Intent(MainActivity.this,HomepageActivity.class);
            startActivity(i);



        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent2.DummyItem item) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent3.DummyItem item) {

    }
}
