package com.example.hp.youarehere.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.youarehere.R;
import com.example.hp.youarehere.utilities.Post;

import org.w3c.dom.Text;

/**
 * Created by ahmedtarek on 11/30/15.
 */
public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    Post[] items;
    Context context;

    public LocationAdapter(Post[] items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_recycler_view_item, parent, false);

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
        if (position == 0) holder.image.setImageResource(R.drawable.test0);
        else if (position == 1) holder.image.setImageResource(R.drawable.test1);
        else if (position == 2) holder.image.setImageResource(R.drawable.test2);
        else if (position == 3) holder.image.setImageResource(R.drawable.test3);

        holder.location.setText("Rome");
        holder.userName.setText("Ahmed Tarek");
    }

    class LocationViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView userName, location;

        public LocationViewHolder(View itemview) {
            super(itemview);
            image = (ImageView) itemview.findViewById(R.id.image_post);
            userName = (TextView) itemview.findViewById(R.id.user_name);
            location = (TextView) itemview.findViewById(R.id.location);
        }
    }
}
