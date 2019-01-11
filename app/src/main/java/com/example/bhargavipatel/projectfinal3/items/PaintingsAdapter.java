package com.example.bhargavipatel.projectfinal3.items;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexvasilkov.android.commons.adapters.ItemsAdapter;
import com.alexvasilkov.android.commons.utils.Views;
import com.bumptech.glide.Glide;
import com.example.bhargavipatel.projectfinal3.Myapplication;
import com.example.bhargavipatel.projectfinal3.R;
import com.example.bhargavipatel.projectfinal3.activities.UnfoldableDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class PaintingsAdapter extends ItemsAdapter<Painting> implements View.OnClickListener {

    public PaintingsAdapter(Context context) {
        super(context);
        List<Painting> ss=new ArrayList<>();
        //setItemsList(Arrays.asList(Painting.getAllPaintings(context.getResources())));
        setItemsList(Myapplication.allcars);
    }

    @Override
    protected View createView(Painting item, int pos, ViewGroup parent, LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder();
        vh.image = Views.find(view, R.id.list_item_image);
        vh.image.setOnClickListener(this);
        vh.title = Views.find(view, R.id.list_item_title);
        view.setTag(vh);


        return view;
    }



    @Override
    protected void bindView(Painting item, int pos, View convertView) {
        ViewHolder vh = (ViewHolder) convertView.getTag();

        vh.image.setTag(R.id.list_item_image, item);
      //  GlideHelper.loadPaintingImage(vh.image, item);



        Glide.with(vh.image.getContext()).load(item.getImageId())
                .override(600, 400)
                .fitCenter()
                .into(vh.image);


        vh.title.setText(item.getTitle());
    }

    @Override
    public void onClick(View view) {
        Painting item = (Painting) view.getTag(R.id.list_item_image);
        if (view.getContext() instanceof UnfoldableDetailsActivity) {
            ((UnfoldableDetailsActivity) view.getContext()).openDetails(view, item);
        } /*else if (view.getContext() instanceof FoldableListActivity) {
            Toast.makeText(view.getContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }*/
    }

    private static class ViewHolder {
        ImageView image;
        TextView title;
    }

}
