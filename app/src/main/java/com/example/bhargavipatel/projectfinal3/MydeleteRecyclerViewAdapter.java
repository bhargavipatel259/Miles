package com.example.bhargavipatel.projectfinal3;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bhargavipatel.projectfinal3.deleteFragment.OnListFragmentInteractionListener;
import com.example.bhargavipatel.projectfinal3.dummy.DummyContent2.DummyItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MydeleteRecyclerViewAdapter extends RecyclerView.Adapter<MydeleteRecyclerViewAdapter.ViewHolder>
{

    Context context;
    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MydeleteRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
            mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_delete, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mid.setText(mValues.get(position).id);
        holder.mContentView1.setText(mValues.get(position).content1);
        holder.mContentView2.setText(mValues.get(position).content2);
        holder.mContentView3.setText(mValues.get(position).content3);
        holder.mContentView4.setText(mValues.get(position).content4);
        holder.mContentView5.setText(mValues.get(position).content5);
        holder.mContentView6.setText(mValues.get(position).content6);
        holder.mContentView7.setText(mValues.get(position).content7);

        setImage(holder.mlist_imageview,mValues.get(position).list_imageview);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });

        /*holder.b.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click
                    }
                })
        );*/
        //holder.b.setTag(position);
        holder.b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Users");
                DatabaseReference inref = myRef.child(Myapplication.uid + "_" + Myapplication.upass);

                inref.child("cars").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        for(DataSnapshot dataSnapshot :  snapshot.getChildren())
                        {
                                if(dataSnapshot.getKey().equals(Myapplication.carno) ) {
                                    dataSnapshot.getRef().removeValue();
                                }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                FirebaseDatabase database1 = FirebaseDatabase.getInstance();
                DatabaseReference myRef1 = database1.getReference("CARS");
                DatabaseReference inref1 = myRef1.child("Vadodara").child(Myapplication.cararea)
                        .child(Myapplication.carname).child(Myapplication.cartype1);

                inref1.child(Myapplication.cartype2).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        for(DataSnapshot dataSnapshot :  snapshot.getChildren())
                        {
                            if(dataSnapshot.getKey().equals(Myapplication.carno)) {
                                dataSnapshot.getRef().removeValue();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });
            }
        });
    }

    void setImage(ImageView iv, String url)
    {

        Glide.with(iv.getContext()).load(url)
                .override(100, 100)
                .fitCenter()
                .into(iv);

    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public  TextView mContentView1;
        public  TextView mContentView2;
        public  TextView mContentView3;
        public  TextView mContentView4;
        public  TextView mContentView5;
        public  TextView mContentView6;
        public  TextView mContentView7;
        public TextView mid;
        public  ImageView mlist_imageview;
        public DummyItem mItem;
        Button b;

       // FragmentManager fm;
        CardView cv;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            cv = (CardView)itemView.findViewById(R.id.cv);
            mid=(TextView)view.findViewById(R.id.id);

            mContentView1 = (TextView) view.findViewById(R.id.content1);
            mContentView2 = (TextView) view.findViewById(R.id.content2);
            mContentView3 = (TextView) view.findViewById(R.id.content3);
            mContentView4 = (TextView) view.findViewById(R.id.content4);
            mContentView5 = (TextView) view.findViewById(R.id.content5);
            mContentView6 = (TextView) view.findViewById(R.id.content6);
            mContentView7 = (TextView) view.findViewById(R.id.content7);

            b=(Button)view.findViewById(R.id.del);

            mlist_imageview = (ImageView)view.findViewById(R.id.list_imageview);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView1.getText() + "'"+ mContentView2.getText()
                    + "'"+ mContentView3.getText() + "'"+ mContentView4.getText() + "'"
                    + mContentView5.getText()
                    + "'"+ mContentView6.getText() + "'"+ mContentView7.getText();
        }
    }
}
