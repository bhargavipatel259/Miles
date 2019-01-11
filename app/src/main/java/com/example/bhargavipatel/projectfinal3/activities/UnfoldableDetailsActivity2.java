package com.example.bhargavipatel.projectfinal3.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alexvasilkov.android.commons.texts.SpannableBuilder;
import com.alexvasilkov.android.commons.utils.Views;
import com.bumptech.glide.Glide;
import com.example.bhargavipatel.projectfinal3.Myapplication;
import com.example.bhargavipatel.projectfinal3.R;
import com.example.bhargavipatel.projectfinal3.confirmbooking;
import com.example.bhargavipatel.projectfinal3.items.Painting;
import com.example.bhargavipatel.projectfinal3.items.PaintingsAdapter;
import com.example.library.UnfoldableView;
import com.example.library.shading.GlanceFoldShading;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;
public class UnfoldableDetailsActivity2 extends BaseActivity
{

    private View listTouchInterceptor;
    private View detailsLayout;
    private UnfoldableView unfoldableView;
    PaintingsAdapter p;
    String seats,reguser;
    FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unfoldable_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        p=new PaintingsAdapter(this);
        ListView listView = Views.find(this, R.id.list_view);
        listView.setAdapter(p);
        fm=getSupportFragmentManager();


        listTouchInterceptor = Views.find(this, R.id.touch_interceptor_view);
        listTouchInterceptor.setClickable(false);

        detailsLayout = Views.find(this, R.id.details_layout);
        detailsLayout.setVisibility(View.INVISIBLE);

        unfoldableView = Views.find(this, R.id.unfoldable_view);

        Bitmap glance = BitmapFactory.decodeResource(getResources(), R.drawable.unfold_glance);
        unfoldableView.setFoldShading(new GlanceFoldShading(glance));

        unfoldableView.setOnFoldingListener(new UnfoldableView.SimpleFoldingListener() {
            @Override
            public void onUnfolding(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(true);
                detailsLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onUnfolded(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(false);
            }

            @Override
            public void onFoldingBack(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(true);
            }

            @Override
            public void onFoldedBack(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(false);
                detailsLayout.setVisibility(View.INVISIBLE);
            }
        });



        setCars();

    }




    void setCars()
    {
        if(Myapplication.allcars.size()>0){
            Myapplication.allcars.clear();
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("CARS");
        DatabaseReference inref=myRef.child(Myapplication.carcity)
                .child(Myapplication.cararea).child(Myapplication.carname)
                .child(Myapplication.cartype).child("Petrol");
        inref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // Map<String,Object> recdata=(Map<String, Object>)dataSnapshot.getValue();
               // Toast.makeText(Myapplication.mycont," "+dataSnapshot.getKey(), Toast.LENGTH_LONG).show();
               // Toast.makeText(Myapplication.mycont," "+dataSnapshot.getValue(), Toast.LENGTH_LONG).show();

                Map<String,Object> cardetails=(Map<String, Object>)dataSnapshot.getValue();
                //String status=cardetails.get("Status").toString();

                if(cardetails.get("Status").toString().equals("available")) {
                    Myapplication.allcars.add(new Painting(cardetails.get("imgurl") + "", dataSnapshot.getKey() + "",
                            cardetails.get("No_of_seats")
                                    + "", cardetails.get("Car_registerd_user") + ""));
                   // Toast.makeText(Myapplication.mycont," "+dataSnapshot.getValue(), Toast.LENGTH_LONG).show();

                    seats = cardetails.get("No_of_seats").toString();
                    reguser = cardetails.get("Car_registerd_user").toString();
                    Myapplication.cartype2 = "Diesel";
                }
                p.notifyDataSetChanged();







            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });







    }
    // public void Book(View v) {
    //     UnfoldableDetailsActivity itemToRemove = (UnfoldableDetailsActivity) v.getTag();
    //    p.;
    //  }


    @Override
    public void onBackPressed() {
        if (unfoldableView != null
                && (unfoldableView.isUnfolded() || unfoldableView.isUnfolding())) {
            unfoldableView.foldBack();
        } else {
            super.onBackPressed();
        }
    }

    public void openDetails(View coverView, Painting painting) {
        final ImageView image = Views.find(detailsLayout, R.id.details_image);
        final TextView title = Views.find(detailsLayout, R.id.details_title);
        final TextView description = Views.find(detailsLayout, R.id.details_text);
        Button b1=Views.find(detailsLayout,R.id.b1);
        Glide.with(image.getContext()).load(painting.getImageId())
                .override(600, 400)
                .fitCenter()
                .into(image);

        //  GlideHelper.loadPaintingImage(image, painting);
        title.setText(painting.getTitle());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Clicked : "+title.getText().toString(),Toast.LENGTH_LONG).show();
                Myapplication.carnum=title.getText().toString();
                Myapplication.carseat=seats;
                Myapplication.caruser=reguser;

                //fm.beginTransaction().replace(R.id.mycont,new confirm_booking()).commit();

                Intent i = new Intent(UnfoldableDetailsActivity2.this, confirmbooking.class);
                startActivity(i);
            }
        });

        SpannableBuilder builder = new SpannableBuilder(this);
        builder
                .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                .append("No Of Seats").append(": ")
                .clearStyle()
                .append(painting.getYear()).append("\n")
                .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                .append("Car Registered Username").append(": ")
                .clearStyle()
                .append(painting.getLocation());
        description.setText(builder.build());

        unfoldableView.unfold(coverView, detailsLayout);
    }


}
