package com.example.bhargavipatel.projectfinal3;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bhargavipatel.projectfinal3.activities.UnfoldableDetailsActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Search.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Search#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Search extends Fragment implements DatePickerDialog.OnDateSetListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RadioGroup radioGroup,radioGroup2;
    private RadioButton radioButton,radioButton2,radioButton21,radioButton22;
    private Button btnDisplay,btnDisplay2;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private DatePicker datePicker2;
    private Calendar calendar2;
    private TextView dateView2;
    Date date1,date2,date3;
    int flag=1,flag1=1,flag2,flag3;
    String curdate,stdate,eddate,date;
    private int year2, month2, day2;
    FragmentManager fm;

    private OnFragmentInteractionListener mListener;

    public Search() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Search.
     */
    // TODO: Rename and change types and number of parameters
    public static Search newInstance(String param1, String param2) {
        Search fragment = new Search();
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
        View view=inflater.inflate(R.layout.fragment_search, container, false);
        fm=getFragmentManager();

                final Spinner spinner = (Spinner)view.findViewById(R.id.spinner);
        final Spinner spinner2 = (Spinner)view. findViewById(R.id.spinner2);
        final Spinner spinner3 = (Spinner)view. findViewById(R.id.spinner3);

        curdate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

       // dateView = (TextView)view. findViewById(R.id.textView3);
        btnDisplay=(Button)view.findViewById(R.id.textView3);
        btnDisplay2=(Button)view.findViewById(R.id.textView32);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        //showDate(year, month+1, day);

      //  dateView2 = (TextView)view. findViewById(R.id.textView32);
        calendar2 = Calendar.getInstance();
        year2 = calendar2.get(Calendar.YEAR);

        month2 = calendar2.get(Calendar.MONTH);
        day2 = calendar2.get(Calendar.DAY_OF_MONTH);
       // showDate2(year2, month2+1, day2);
         date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        btnDisplay.setText(date);
        btnDisplay2.setText(date);



        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        btnDisplay2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showDatePicker2();
            }
        });






// SPINNER FOR CITY


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Vadodara");
        //categories.add("Ahmedabad");
        //categories.add("Computers");
        //categories.add("Education");
        //categories.add("Personal");
        //categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        // Spinner click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Myapplication.carcity=spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







//SPINNER FOR AREA


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

        // Spinner click listener
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Myapplication.cararea=spinner2.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






//SPINNER FOR CARS
// Spinner click listener

        // Spinner Drop down elements
        List<String> categories3 = new ArrayList<String>();
        categories3.add("Wagon R");
        categories3.add("Amaze");
        categories3.add("Zest");
        categories3.add("Honda City");
        categories3.add("Cruze");
        categories3.add("Audi R8");
        categories3.add("Innova");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories3);

        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner3.setAdapter(dataAdapter3);



        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Myapplication.carname=spinner3.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //radio group for petrol diesel
        radioGroup=(RadioGroup)view.findViewById(R.id.radioGroup);

        radioButton = (RadioButton)view. findViewById(R.id.radioButton);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton)getActivity().findViewById(selectedId);
                Toast.makeText(getActivity(),"Selected: "+  radioButton.getText(), Toast.LENGTH_LONG).show();
                Myapplication.cartype2=radioButton.getText().toString();

            }
        });
        radioButton2 = (RadioButton)view.findViewById(R.id.radioButton2);

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton2 = (RadioButton)getActivity().findViewById(selectedId);
                Toast.makeText(getActivity(),"Selected: "+  radioButton2.getText(), Toast.LENGTH_LONG).show();
                Myapplication.cartype2=radioButton2.getText().toString();

            }
        });


//radio group for ac non ac
        radioGroup2=(RadioGroup)view.findViewById(R.id.radioGroup2);
        radioButton21 = (RadioButton)view.findViewById(R.id.radioButton21);

        // btnDisplay=(Button)findViewById(R.id.button);

        radioButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=radioGroup2.getCheckedRadioButtonId();
                radioButton21=(RadioButton)getActivity().findViewById(selectedId);
                Toast.makeText(getActivity(),"Selected: "+ radioButton21.getText(),Toast.LENGTH_LONG).show();
                Myapplication.cartype=radioButton21.getText().toString();

            }
        });

        radioButton22 = (RadioButton)view. findViewById(R.id.radioButton22);
        radioButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=radioGroup2.getCheckedRadioButtonId();
                radioButton22=(RadioButton)getActivity().findViewById(selectedId);
                Toast.makeText(getActivity(),"Selected: "+ radioButton22.getText(),Toast.LENGTH_LONG).show();
                Myapplication.cartype=radioButton22.getText().toString();

            }
        });

        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0 && flag1==0 ) {
                    Intent i = new Intent(getActivity(), UnfoldableDetailsActivity.class);
                    startActivity(i);
                }

                    else
                {

                   Toast.makeText(getContext(),"you have not searched properly ",Toast.LENGTH_SHORT).show();;
                }

                //fm.beginTransaction().replace(R.id.mycont,new bookedtab()).commit();

            }
        });




        return view;
    }



    private void showDatePicker() {
        DatePickerFragment date = new DatePickerFragment();
        /**
         * Set Up Current Date Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH));
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        date.setCallBack(ondate);
        date.show(getActivity().getSupportFragmentManager(), "Date Picker");
    }

    DatePickerDialog.OnDateSetListener ondate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            Toast.makeText(
                    getActivity(),
                    String.valueOf(year) + "-" + String.valueOf(monthOfYear)
                            + "-" + String.valueOf(dayOfMonth),
                    Toast.LENGTH_LONG).show();
             stdate=
                    String.valueOf(dayOfMonth)+"/"+String.valueOf(monthOfYear+1)+"/"+String.valueOf(year);
          //  btnDisplay.setText(date);

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                date1 = format.parse(curdate);
                date2=format.parse(stdate);

            } catch (ParseException e) {
                // TODO Auto-generated catch block
            }


                    if(date2.after(date1))
                    {
                        flag=0;
                        btnDisplay.setTextColor(Color.BLACK);
                        btnDisplay.setText(stdate);
                        Myapplication.sdate = stdate;
                    }
            else
            {
                flag=1;
                btnDisplay.setTextColor(Color.RED);
                btnDisplay.setText("Wrong Date");
            }
        }
    };


    private void showDatePicker2() {
        DatePickerFragment2 date = new DatePickerFragment2();
        /**
         * Set Up Current Date Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH));
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        date.setCallBack(ondate2);
        date.show(getActivity().getSupportFragmentManager(), "Date Picker");
    }

    DatePickerDialog.OnDateSetListener ondate2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            Toast.makeText(
                    getActivity(),
                    String.valueOf(year) + "-" + String.valueOf(monthOfYear+1)
                            + "-" + String.valueOf(dayOfMonth),
                    Toast.LENGTH_LONG).show();
             eddate=
                     String.valueOf(dayOfMonth)+"/"+String.valueOf(monthOfYear+1)+"/"+String.valueOf(year);

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {

                date3=format.parse(eddate);

            } catch (ParseException e) {
                // TODO Auto-generated catch block
            }

            if(date3.after(date2))
            {
                flag1=0;
                btnDisplay2.setTextColor(Color.BLACK);
                btnDisplay2.setText(eddate);
                Myapplication.edate = eddate;
            }
           else
           {
               flag1=1;
               btnDisplay2.setTextColor(Color.RED);
               btnDisplay2.setText("wrong date!");

           }
        }
    };



/*
    //datepicker
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        getActivity().showDialog(999);
        Toast.makeText(getActivity().getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
        Myapplication.sdate=getActivity().getApplicationContext().toString();
    }

    @SuppressWarnings("deprecation")
    public void setDate2(View view) {
        getActivity().showDialog(998);
        Toast.makeText(getActivity().getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
        Myapplication.edate=getActivity().getApplicationContext().toString();
    }

    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(getActivity(),
                    myDateListener, year, month, day);
        } else if (id == 998) {
            return new DatePickerDialog(getActivity(),
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
    }
*/

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



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
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
