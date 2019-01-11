package com.example.bhargavipatel.projectfinal3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv=(ListView)findViewById(R.id.mobile_list);

       ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Myapplication.allloc);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),"Item : "+i+ "- "+Myapplication.allres.get(Myapplication.allloc.get(i)),Toast.LENGTH_SHORT).show();

                Intent ii=new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(ii);

            }
        });

    }


}
