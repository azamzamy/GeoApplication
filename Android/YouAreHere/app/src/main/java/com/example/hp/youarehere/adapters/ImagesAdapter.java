package com.example.hp.youarehere.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.youarehere.R;
import com.example.hp.youarehere.utilities.Post;
import com.squareup.picasso.Picasso;

/**
 * Created by ahmedtarek on 11/30/15.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.LocationViewHolder> {

    Post[] items;
    Context context;
    int version;

    public ImagesAdapter(Post[] items, Context context, int version) {
        this.version = version;
        this.items = items;
        this.context = context;
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (version == 0)                                       // timeline views
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_recycler_view_item, parent, false);
        else                                                    // profile views
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_recycler_view_item, parent, false);
        return new LocationViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {

        if (position >3 ) {
            holder.image.setImageResource(R.drawable.background);
        }

        else if (position == 0) Picasso.with(context).load(R.drawable.test0).into(holder.image);
        else if (position == 1) Picasso.with(context).load(R.drawable.test1).into(holder.image);
        else if (position == 2) Picasso.with(context).load(R.drawable.test2).into(holder.image);
        else if (position == 3) Picasso.with(context).load(R.drawable.test3).into(holder.image);

        if (version == 0) {
            holder.location.setText("Rome");
            holder.userName.setText("by Ahmed Tarek");
        }


    }

    class LocationViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView userName, location;

        public LocationViewHolder(View itemview) {
            super(itemview);
            image = (ImageView) itemview.findViewById(R.id.image_post);
            userName = (TextView) itemview.findViewById(R.id.user_name);
            location = (TextView) itemview.findViewById(R.id.location);

            if (version ==0) {
                userName.setTypeface(Typeface.createFromAsset(context.getAssets(), "Raleway-Medium.ttf"));
                location.setTypeface(Typeface.createFromAsset(context.getAssets(), "Raleway-Medium.ttf"));
            }

        }
    }
}
