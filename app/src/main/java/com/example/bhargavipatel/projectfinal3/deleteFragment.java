package com.example.bhargavipatel.projectfinal3;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bhargavipatel.projectfinal3.dummy.DummyContent2;
import com.example.bhargavipatel.projectfinal3.dummy.DummyContent2.DummyItem;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class deleteFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    MydeleteRecyclerViewAdapter adapter;
    Button b;
    FragmentManager fm;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public deleteFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static deleteFragment newInstance(int columnCount) {
        deleteFragment fragment = new deleteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete_list, container, false);

        adapter=new MydeleteRecyclerViewAdapter(DummyContent2.ITEMS, mListener);
        fm=getFragmentManager();


        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(adapter);
        }
        displayCars();


        return view;
    }

    void displayCars()
    {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");
        DatabaseReference inref = myRef.child(Myapplication.uid + "_" + Myapplication.upass).child("cars");
        inref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // Map<String,Object> recdata=(Map<String, Object>)dataSnapshot.getValue();
               // Toast.makeText(getActivity(), " " + dataSnapshot.getKey(), Toast.LENGTH_LONG).show();
               // Toast.makeText(getActivity(), " " + dataSnapshot.getValue(), Toast.LENGTH_LONG).show();

                Map<String, Object> cardetails = (Map<String, Object>) dataSnapshot.getValue();
                //String status=cardetails.get("Status").toString();
                Myapplication.cararea=cardetails.get("Area") + "";
                Myapplication.carname=cardetails.get("CarName") + "";
                Myapplication.cartype1=cardetails.get("CarType1") + "";
                Myapplication.cartype2=cardetails.get("CarType2") + "";
                Myapplication.car_registered_user=cardetails.get("Car_registerd_user") + "";
                Myapplication.carcity=cardetails.get("City") + "";
                Myapplication.no_of_seats=cardetails.get("No_of_seats") + "";
                Myapplication.carno=dataSnapshot.getKey() + "";
                Myapplication.children_count=dataSnapshot.getChildrenCount();


                DummyContent2.addItem(new DummyItem(dataSnapshot.getKey() + "",
                        cardetails.get("Area") + "",
                        cardetails.get("CarName") + "", cardetails.get("CarType1") + "",
                        cardetails.get("CarType2") + "",
                        cardetails.get("Car_registerd_user") + "", cardetails.get("City") + "",
                        cardetails.get("No_of_seats") + "", cardetails.get("imgurl") + ""));
                /*Myapplication.delcars.add(new deletecar(cardetails.get("imgurl") + "",dataSnapshot.getKey() + "",
                        cardetails.get("No_of_seats") + "", cardetails.get("Car_registerd_user") + "",
                        cardetails.get("Area") + "", cardetails.get("CarType1") + "",
                        cardetails.get("CarType2") + "", cardetails.get("City") + "",
                        cardetails.get("Car_name") + ""));*/

                adapter.notifyDataSetChanged();
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



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }

}


