package com.example.bhargavipatel.projectfinal3;

/**
 * Created by twisha on 04-03-2017.
 *
 * explore vaalu page
 */


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomepageActivity extends AppCompatActivity {
    Button r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "shahid.ttf");
        TextView myTextView = (TextView)findViewById(R.id.textView2);
        myTextView.setTypeface(myTypeFace);


        r = (Button) findViewById(R.id.button);

        r.setOnClickListener(new View.OnClickListener() {

                                 @Override
                                 public void onClick(View view) {
                                     Intent i = new Intent(HomepageActivity.this,LoginActivity2.class);
                                     startActivity(i);
                                 }

                             }
        );


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}

