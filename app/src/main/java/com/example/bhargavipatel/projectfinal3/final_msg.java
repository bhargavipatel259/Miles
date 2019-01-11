package com.example.bhargavipatel.projectfinal3;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class final_msg extends AppCompatActivity {

    FragmentManager fm;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_msg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "shahid.ttf");
        TextView myTextView = (TextView)findViewById(R.id.textView2);
        myTextView.setTypeface(myTypeFace);
        fm=getSupportFragmentManager();
        b=(Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.mycont,new Search()).commit();

            }
        });




    }

    @Override
    public void onBackPressed() {
        fm.beginTransaction().replace(R.id.mycont,new Search()).commit();

    }

}
