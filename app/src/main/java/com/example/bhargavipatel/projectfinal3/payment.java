package com.example.bhargavipatel.projectfinal3;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link payment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class payment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button b,b1;
    EditText editText2,editText4,editText3;
    int flag=0;
    FragmentManager fm;
    AlertDialog.Builder ab;
    private OnFragmentInteractionListener mListener;

    public payment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static payment newInstance(String param1, String param2) {
        payment fragment = new payment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment, container, false);

        editText2=(EditText)view.findViewById(R.id.editText2);
        editText4=(EditText)view.findViewById(R.id.editText4);
        editText3=(EditText)view.findViewById(R.id.editText3);
        b = (Button) view.findViewById(R.id.button);
        b1=(Button) view.findViewById(R.id.button2);

        fm=getFragmentManager();
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (editText2.getText().toString().length() !=16) {
                    flag = 1;
                    editText2.setError("It should be of 16 digits");
                }

                if (editText4.getText().toString().length()!=3) {
                    flag = 1;
                    editText4.setError("It should be of 3 digits");
                }
                if (editText3.getText().toString().length()!=7)
                {
                    flag = 1;
                    editText3.setError("It should be in mm/yyyy format");
                }

                if(flag==0) {



                            final ProgressDialog loading;
                            loading = new ProgressDialog(getActivity());
                            loading.setCancelable(false);
                            loading.setTitle("Please Wait....");

                            // Toast.makeText(getActivity(),"Url : "+imgurl,Toast.LENGTH_LONG).show();
                            loading.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
                            loading.show();

                            Toast.makeText(getActivity(), "ok", Toast.LENGTH_SHORT).show();
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("Users");
                            DatabaseReference inref = myRef.child(Myapplication.uid + "_" + Myapplication.upass).child("cars").child(Myapplication.carnum);
                            final Map<String, Object> data = new LinkedHashMap<>();
                            data.put("Status","unavailable");


                            FirebaseDatabase database1 = FirebaseDatabase.getInstance();
                            DatabaseReference myRef1 = database1.getReference("CARS");
                            final DatabaseReference inref1=myRef1.child(Myapplication.carcity)
                                    .child(Myapplication.cararea).child(Myapplication.carname)
                                    .child(Myapplication.cartype).child(Myapplication.cartype2).child(Myapplication.carnum);
                            final Map<String, Object> data1 = new LinkedHashMap<>();
                            data1.put("Status","unavailable");

                            inref.setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    inref1.setValue(data1);
                                    loading.dismiss();
                                    Intent a=new Intent(getContext(),final_msg.class);
                                    startActivity(a);


                                    Toast.makeText(getActivity(), "Successfully Registered", Toast.LENGTH_SHORT).show();


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity(), "Try again later", Toast.LENGTH_SHORT).show();

                                }

                            });

                        }
                    }
        });






        // TODO: Rename method, update argument and hook method into UI event
        return view;
    }

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

