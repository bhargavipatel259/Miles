package com.example.bhargavipatel.projectfinal3;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivityMap extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = MainActivityMap.class.getName();
    private static final String REQUESTTAG = "string request first";
    static String longi, lati;
    Button req, food, point_of_interest, museum;
    Spinner spinner;
    String hour;

    StringRequest stringRequest;


    GoogleApiClient mGoogleApiClient;
    Button ss;
    TextView textView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_map);
        spinner = (Spinner) findViewById(R.id.spinner);

        List<String> categories = new ArrayList<String>();
        categories.add("1 Hour");
        categories.add("2 Hours");
        categories.add("3 Hours");
        categories.add("4 Hours");
        categories.add("5 Hours");
        //cat Hoursegorting adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(MainActivityMap.this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        // Spinner click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                hour = spinner.getSelectedItem().toString();

                Toast.makeText(MainActivityMap.this, hour,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        point_of_interest = (Button) findViewById(R.id.point_of_interest);
        point_of_interest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (hour.equals("1 Hour")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=1000&type=point_of_interest&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }

                if (hour.equals("2 Hours")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=2000&type=point_of_interest&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }
                if (hour.equals("3 Hours")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=3000&type=point_of_interest&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }
                if (hour.equals("4 Hours")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=4000&type=point_of_interest&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }
                if (hour.equals("5 Hours")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=5000&type=point_of_interest&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }

                sendrequestandprint(url);

            }
        });

        food = (Button) findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (hour.equals("1 Hour")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=1000&type=food&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }
                if (hour.equals("2 Hours")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=2000&type=food&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }
                if (hour.equals("3 Hours")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=3000&type=food&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }
                if (hour.equals("4 Hours")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=4000&type=food&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }
                if (hour.equals("5 Hours")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=5000&type=food&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }

                sendrequestandprint(url);
            }
        });


        museum = (Button) findViewById(R.id.museum);
        museum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (hour.equals("1 Hour"))

                {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=10000&type=museum&keyword=garden&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }


                if (hour.equals("2 Hours"))

                {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=10000&type=museum&keyword=garden&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }

                if (hour.equals("3 Hours"))

                {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=10000&type=museum&keyword=garden&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }

                if (hour.equals("4 Hours"))

                {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=10000&type=museum&keyword=garden&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }

                if (hour.equals("5 Hours"))

                {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=10000&type=museum&keyword=garden&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";
                }
                sendrequestandprint(url);

            }
        });
        textView = (TextView) findViewById(R.id.textView2);
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }


        ss = (Button) findViewById(R.id.sss);
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (hour.equals("1 Hour")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=1000&type=atm&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";

                }

                if (hour.equals("2 Hours")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=2000&type=atm&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";

                }

                if (hour.equals("3 Hours")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=3000&type=atm&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";

                }

                if (hour.equals("4 Hours")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=4000&type=atm&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";

                }

                if (hour.equals("5 Hours")) {

                    url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + lati + "," + longi + "&radius=5000&type=atm&key=AIzaSyAXCN_bdylFQtene9kbuP9Ce2E-grxqf0s";

                }

                sendrequestandprint(url);


            }
        });


    }

    private void sendrequestandprint(String url) {
        if (Myapplication.allloc.size() > 0) {
            Myapplication.allloc.clear();
            Myapplication.allres.clear();
        }

        RequestQueue mRequestqeue;
        mRequestqeue = Volley.newRequestQueue(this);
        StringRequest stringrequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "Response =" + response.toString());
                try {
                    JSONObject r = new JSONObject(response);
                    JSONArray results = r.getJSONArray("results");

                    ArrayList<Result1> resultsList = new ArrayList<Result1>();

                    for (int i = 0; i < results.length(); i++) {
                        JSONObject thisResult = results.getJSONObject(i);
                        String name = thisResult.getString("name");
                        String vicinity = thisResult.getString("vicinity");
                        JSONObject geometry = thisResult.getJSONObject("geometry");
                        JSONObject location = geometry.getJSONObject("location");
                        double latitude = location.getDouble("lat");
                        double longitude = location.getDouble("lng");
                        Result1 result = new Result1(name, latitude, longitude, vicinity);
                        Myapplication.allloc.add(name);
                        Myapplication.allres.put(name, result);
                        resultsList.add(result);
                        resultsList.add(result);

                    }
                    Intent ii = new Intent(getApplication(), Main2Activity.class);
                    startActivity(ii);
                    for (int i = 0; i < resultsList.size(); i++) {
                        Log.v(TAG, "Result1 #" + (i + 1) + ": " + resultsList.get(i).toString());
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Something went wrong while parsing the JSON response.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "Error =" + error.toString());
            }
        });
        stringrequest.setTag(REQUESTTAG);
        mRequestqeue.add(stringrequest);

    }

    @Override
    protected void onStop() {
        super.onStop();
      /*  if (mRequestqeue!=null)
        {
            mRequestqeue.cancelAll(REQUESTTAG);
        }*/
    }

    @Override
    public void onConnected(Bundle bundle) {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
            lati=String.valueOf(mLastLocation.getLatitude());
            longi=String.valueOf(mLastLocation.getLongitude());
            Toast.makeText(getApplicationContext(),"Find : "+String.valueOf(mLastLocation.getLatitude())+" - "+String.valueOf(mLastLocation.getLongitude()),Toast.LENGTH_LONG).show();
            getAddressFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(),
                    getApplicationContext(), new GeocoderHandler());
        }
    }
    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            textView.setText(locationAddress);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }


    public static void getAddressFromLocation(final double latitude, final double longitude,
                                              final Context context, final Handler handler) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                String result = null;
                try {
                    List<Address> addressList = geocoder.getFromLocation(
                            latitude, longitude, 1);
                    if (addressList != null && addressList.size() > 0) {
                        Address address = addressList.get(0);
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                            sb.append(address.getAddressLine(i)).append("\n");
                        }
                        sb.append(address.getLocality()).append("\n");
                        sb.append(address.getPostalCode()).append("\n");
                        sb.append(address.getCountryName());
                        result = sb.toString();
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Unable connect to Geocoder", e);
                } finally {
                    Message message = Message.obtain();
                    message.setTarget(handler);
                    if (result != null) {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        result = "Latitude: " + latitude + " Longitude: " + longitude +
                                "\n\nAddress:\n" + result;
                        bundle.putString("address", result);
                        message.setData(bundle);
                    } else {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        result = "Latitude: " + latitude + " Longitude: " + longitude +
                                "\n Unable to get address for this lat-long.";
                        bundle.putString("address", result);
                        message.setData(bundle);
                    }
                    message.sendToTarget();
                }
            }
        };
        thread.start();
    }
}
