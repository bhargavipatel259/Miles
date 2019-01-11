package com.example.bhargavipatel.projectfinal3;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Add_car.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Add_car#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Add_car extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RadioGroup radioGroup, radioGroup2;
    private RadioButton radioButton, radioButton2, radioButton21, radioButton22;
    private Button browse;
    private Button b;
    FirebaseDatabase database;
    private Bitmap bitmap;
    private int PICK_IMAGE_REQUEST = 1;
    //ProgressDialog pd;
    private Uri file,filepath;
    int selectedId;
    Spinner spinner,spinner2,spinner3,spinner4;
    EditText reg,regname,em,pass;
    String myEmail,myPass, ac_nonac,petrol_diesel,reg1,regname1,email,email2,password;
    int flag=0;


    public Add_car() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Add_car.
     */
    // TODO: Rename and change types and number of parameters
    public static Add_car newInstance(String param1, String param2) {
        Add_car fragment = new Add_car();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_car, container, false);
        //View view1 = inflater.inflate(R.layout.activity_login2, container, false);

        MainActivity activity = (MainActivity) getActivity();
        myEmail = activity.getMyEmail();

        myPass = activity.getMyPass();

        spinner = (Spinner)view.findViewById(R.id.spinner);
        spinner2 = (Spinner)view.findViewById(R.id.spinner2);
        spinner3 = (Spinner)view.findViewById(R.id.spinner3);
        spinner4 = (Spinner)view.findViewById(R.id.spinner4);


        b = (Button)view.findViewById(R.id.button2);
        database = FirebaseDatabase.getInstance();
        reg = (EditText)view.findViewById(R.id.reg);
        regname = (EditText)view.findViewById(R.id.regname);
        browse = (Button)view.findViewById(R.id.browse);

        //   em = (EditText) view1.findViewById(R.id.email);
        // pass = (EditText)view1.findViewById(R.id.pass);

        //email = em.getText().toString();
        //password = pass.getText().toString();
        //email2=email.replace(".","");



        // SPINNER FOR CITY
        // Spinner click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Vadodara");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


//SPINNER FOR AREA
        // Spinner click listener
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner Drop down elements
        List<String> categories2 = new ArrayList<String>();
        categories2.add("Manjalpur");
        categories2.add("Tarsali");
        categories2.add("Karelibaugh");
        categories2.add("Alkapuri");
        categories2.add("Sayajigunj");
        categories2.add("Fatehgunj");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories2);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner2.setAdapter(dataAdapter2);


//SPINNER FOR CARS
// Spinner click listener
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner Drop down elements
        List<String> categories3 = new ArrayList<String>();
        categories3.add("Wagon R");
        categories3.add("Amaze");
        categories3.add("Zest");
        categories3.add("Honda City");
        categories3.add("Cruze");
        categories3.add("Innova");
        categories3.add("Audi R8");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories3);

        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner3.setAdapter(dataAdapter3);


        //SPINNER FOR NO OF SEATS
// Spinner click listener
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Spinner Drop down elements
        List<String> categories4 = new ArrayList<String>();
        categories4.add("2");
        categories4.add("5");
        categories4.add("7");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories4);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner4.setAdapter(dataAdapter4);


        //radio group for petrol diesel
        radioGroup = (RadioGroup)view.findViewById(R.id.radioGroup);

        radioButton = (RadioButton)view.findViewById(R.id.radioButton);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton)getActivity().findViewById(selectedId);
                Toast.makeText(getActivity(), "Selected: " + radioButton.getText(), Toast.LENGTH_LONG).show();
                petrol_diesel = radioButton.getText().toString();
            }
        });
        radioButton2 = (RadioButton) view.findViewById(R.id.radioButton2);

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton2 = (RadioButton)getActivity().findViewById(selectedId);
                Toast.makeText(getActivity(), "Selected: " + radioButton2.getText(), Toast.LENGTH_LONG).show();
                petrol_diesel = radioButton2.getText().toString();
            }
        });


//radio group for ac non ac
        radioGroup2 = (RadioGroup)view.findViewById(R.id.radioGroup2);
        radioButton21 = (RadioButton)view.findViewById(R.id.radioButton21);

        // btnDisplay=(Button)findViewById(R.id.button);

        radioButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup2.getCheckedRadioButtonId();
                radioButton21 = (RadioButton)getActivity().findViewById(selectedId);
                Toast.makeText(getActivity(), "Selected: " + radioButton21.getText(), Toast.LENGTH_LONG).show();
                ac_nonac = radioButton21.getText().toString();
            }
        });

        radioButton22 = (RadioButton)view.findViewById(R.id.radioButton22);
        radioButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup2.getCheckedRadioButtonId();
                radioButton22 = (RadioButton)getActivity().findViewById(selectedId);
                Toast.makeText(getActivity(), "Selected: " + radioButton22.getText(), Toast.LENGTH_LONG).show();
                ac_nonac = radioButton22.getText().toString();
            }
        });


        b.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View v) {

                if (reg.getText().toString().length() == 0) {

                    reg.setError("Car id is required");
                    flag = 1;
                }
                if (regname.getText().toString().length() == 0) {

                    regname.setError("Registered user is required");
                    flag = 1;
                }

                reg1 = reg.getText().toString().toUpperCase();
                regname1 = regname.getText().toString().toLowerCase();

                if (flag == 0) {



                    uploadImage();


                    /*inref1.setValue(data1).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            loading.dismiss();
                            Toast.makeText(getActivity(), "Thank You for waiting", Toast.LENGTH_SHORT).show();

                            // Intent i = new Intent(getActivity(), MainActivity.class);
                            //getActivity().startActivity(i);
                            //getActivity().finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), "Try again later", Toast.LENGTH_SHORT).show();

                        }

                    });*/

                }


            }
        });

        browse.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View v) {
                showFileChooser();
            }


        });




        // Inflate the layout for this fragment
        return view;
    }


    private void uploadImage() {
        if(file!=null)
        {
            FirebaseStorage storage= FirebaseStorage.getInstance();
            StorageReference reference=storage.getReferenceFromUrl("gs://projectfinal3-226b7.appspot.com");
            final StorageReference imagesRef=reference.child("images/"+reg.getText().toString());
            final UploadTask uploadTask = imagesRef.putFile(file);
            StorageTask<UploadTask.TaskSnapshot> taskSnapshotStorageTask = uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    //pd.dismiss();
                    Toast.makeText(getActivity(), "Error : " + e.toString(), Toast.LENGTH_SHORT).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    //pd.dismiss();FirebaseDatabase database = FirebaseDatabase.getInstance();
                    final ProgressDialog loading;
                    loading = new ProgressDialog(getActivity());
                    loading.setCancelable(false);
                    loading.setTitle("Please Wait....");
                    Uri imgurl = uploadTask.getSnapshot().getMetadata().getDownloadUrl();
                   // Toast.makeText(getActivity(),"Url : "+imgurl,Toast.LENGTH_LONG).show();
                    loading.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
                    loading.show();

                    DatabaseReference myRef = database.getReference("CARS");
                    DatabaseReference inref = myRef.child(spinner.getSelectedItem().toString())
                            .child(spinner2.getSelectedItem().toString())
                            .child(spinner3.getSelectedItem().toString())
                            .child(ac_nonac).child(petrol_diesel).child(reg1);
                    Map<String, Object> data = new LinkedHashMap<>();
                    data.put("Car_registerd_user", regname1);
                    data.put("No_of_seats", spinner4.getSelectedItem().toString());
                    data.put("imgurl",imgurl+"");
                    data.put("Status","available");


                    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
                    DatabaseReference myRef1 = database1.getReference("Users");
                    final DatabaseReference inref1 = myRef1.child(Myapplication.uid + "_" + Myapplication.upass).child("cars");
                    final Map<String, Object> data1 = new LinkedHashMap<>();
                    data1.put("Car_registerd_user", regname1);
                    data1.put("No_of_seats", spinner4.getSelectedItem().toString());
                    data1.put("Status","available");
                    data1.put("imgurl",imgurl+"");
                    data1.put("City",spinner.getSelectedItem().toString());
                    data1.put("Area",spinner2.getSelectedItem().toString());
                    data1.put("CarName",spinner3.getSelectedItem().toString());
                    data1.put("CarType1",ac_nonac);
                    data1.put("CarType2",petrol_diesel);


                    inref.setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            inref1.child(reg1).setValue(data1);
                            loading.dismiss();
                            Toast.makeText(getActivity(), "Successfully Registered", Toast.LENGTH_SHORT).show();

                            // Intent i = new Intent(getActivity(), MainActivity.class);
                            //getActivity().startActivity(i);
                            //getActivity().finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), "Try again later", Toast.LENGTH_SHORT).show();

                        }

                    });

                    //pd=new ProgressDialog(this);
                    //pd.setCancelable(false);
                    //pd.show();

                    Toast.makeText(getActivity(), "Uploading Done!!!", Toast.LENGTH_SHORT).show();


                }
            });
        }
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == getActivity().RESULT_OK && data != null && data.getData() != null)
        {
            file = data.getData();

            try {
                //Getting the Bitmap from Gallery
                startCropImageActivity(file);
               //Setting the Bitmap to ImageView
                //imageView.setImageBitmap(bitmap);
                //imageView.setImageURI(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(getActivity(), "Cropping successful, Sample: ", Toast.LENGTH_LONG).show();

            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == getActivity().RESULT_OK) {
                // ((ImageView) findViewById(R.id.quick_start_cropped_image)).setImageURI(result.getUri());
                try {
                    filepath = result.getUri();
                    bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filepath);


                    Toast.makeText(getActivity(), "Cropping "+filepath, Toast.LENGTH_LONG).show();


                }
                catch(Exception e)
                {
                    Toast.makeText(getActivity(), "Error\nTry again :"+e.getMessage(), Toast.LENGTH_LONG).show();

                }
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Toast.makeText(getActivity(), "Cropping failed\nTry again", Toast.LENGTH_LONG).show();
            }
        }

    }
    private void startCropImageActivity(Uri imageUri) {
        CropImage.activity(imageUri)
                .setActivityTitle("Set Size")
                .setBorderCornerColor(Color.RED)
                .setBorderCornerLength(50)
                .setBorderCornerThickness(5)
                .setAspectRatio(1,1)
                .setGuidelinesColor(Color.parseColor("#00000000"))
                .setBackgroundColor(Color.parseColor("#7f000000"))
                .setCropShape(CropImageView.CropShape.RECTANGLE)
                .setGuidelines(CropImageView.Guidelines.ON)
                .setMultiTouchEnabled(true)
                .start(getActivity());


    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
