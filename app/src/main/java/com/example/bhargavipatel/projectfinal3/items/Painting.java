package com.example.bhargavipatel.projectfinal3.items;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.widget.Toast;

import com.example.bhargavipatel.projectfinal3.Myapplication;
import com.example.bhargavipatel.projectfinal3.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Painting {

    private final String imageId;
    private final String title;
    private final String year;
    private final String location;
    public static PaintingsAdapter  adpter;
    public static int i=1,j=0;
 //  public static String[] titles,years,locations,imgurl;
  //  public static Painting paintings[];


    public Painting(String imageId, String title, String year, String location) {
        this.imageId = imageId;
        this.title = title;
        this.year = year;
        this.location = location;
    }

    public String getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getLocation() {
        return location;
    }


    public static  Painting[] getAllPaintings(final Resources res) {
      FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("CARS");
        DatabaseReference inref=myRef.child(Myapplication.carcity)
                .child(Myapplication.cararea).child(Myapplication.carname)
                .child(Myapplication.cartype).child("Diesel");

            inref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    //Toast.makeText(Myapplication.mycont,"Value : "+dataSnapshot,Toast.LENGTH_LONG).show();

                    Map<String,Object> all=(Map<String, Object>)dataSnapshot.getValue();
                    List<String> allkeys=new ArrayList<String>();
                    allkeys.addAll(all.keySet());
                    List<String> tit=new ArrayList<String>();
                    for(int i=0;i<allkeys.size();i++)
                    {
                        Map<String, Object> cardetails = (Map<String, Object>) all.get(allkeys.get(i));
                      //  titles[i]=dataSnapshot.getKey().toString();
                       // years[i]=cardetails.get("No_of_seats").toString();
                       // locations[i]=cardetails.get("Car_registerd_user").toString();
                        //imgurl[i]=cardetails.get("imgurl").toString();
                        tit.add(allkeys.get(i));

                        Toast.makeText(Myapplication.mycont,"Value : "+cardetails,Toast.LENGTH_LONG).show();

                    }
}

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    return ;
                }
            });

        String[] titles = res.getStringArray(R.array.paintings_titles);
        String[] years = res.getStringArray(R.array.paintings_years);
        String[] locations = res.getStringArray(R.array.paintings_locations);
        TypedArray images = res.obtainTypedArray(R.array.paintings_images);

        int size = titles.length;
        Painting[] paintings = new Painting[size];

        for (int i = 0; i < size; i++) {

         //   final int imageId = images.getResourceId(i, -1);
           // paintings[i] = new Painting(imageId, titles[i], years[i], locations[i]);
            // paintings[i] = new Painting(imgurl[i], titles[i], years[i], locations[i]);
        }
        images.recycle();

        return paintings;

        /*inref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // Map<String,Object> recdata=(Map<String, Object>)dataSnapshot.getValue();
              //  Toast.makeText(this," " + dataSnapshot.getKey(), Toast.LENGTH_LONG).show();
                // Toast.makeText(, " " + dataSnapshot.getValue(), Toast.LENGTH_LONG).show();
               // Toast.makeText(this,""+dataSnapshot.getKey(),Toast.LENGTH_LONG).show();

                Map<String, Object> cardetails = (Map<String, Object>) dataSnapshot.getValue();
                titles[i]=dataSnapshot.getKey().toString();
                years[i]=cardetails.get("No_of_seats").toString();
                locations[i]=cardetails.get("Car_registerd_user").toString();
                imgurl[i]=cardetails.get("imgurl").toString();

               // paintings[i] = new Painting(imgurl, titles, years, locations);

                //String status=cardetails.get("Status").toString();

                // DummyContent.addItem(new DummyContent.DummyItem(dataSnapshot.getKey() + "", cardetails.get("No_of_seats") + "", cardetails.get("Car_registerd_user") + "", cardetails.get("imgurl") + ""));

                i=i+1;
               // adpter.notifyDataSetChanged();

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
            });*/


       // imgurl.recycle();*/

    }

}
