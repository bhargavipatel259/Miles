package com.example.bhargavipatel.projectfinal3;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bhargavipatel.projectfinal3.sirdemopetrolFragment.OnListFragmentInteractionListener;
import com.example.bhargavipatel.projectfinal3.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MysirdemopetrolRecyclerViewAdapter extends RecyclerView.Adapter<MysirdemopetrolRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MysirdemopetrolRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_sirdemopetrol, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);
        holder.mContentView1.setText(mValues.get(position).content1);

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
    }

    void setImage(ImageView iv,String url)
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
        public  View mView;
        public  TextView mIdView;
        public  TextView mContentView;
        public  TextView mContentView1;
        public  ImageView mlist_imageview;
        public DummyItem mItem;
        CardView cv;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            cv = (CardView)itemView.findViewById(R.id.cv);
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            mContentView1 = (TextView) view.findViewById(R.id.content1);
            mlist_imageview = (ImageView)view.findViewById(R.id.list_imageview);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'"+ mContentView1.getText() + "'"+mlist_imageview.getDrawable();
        }
    }
}
