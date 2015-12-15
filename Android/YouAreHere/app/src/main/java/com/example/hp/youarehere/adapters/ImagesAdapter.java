package com.example.hp.youarehere.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hp.youarehere.CommentsListAdapter;
import com.example.hp.youarehere.FriendsListAdapter;
import com.example.hp.youarehere.R;
import com.example.hp.youarehere.Timeline;
import com.example.hp.youarehere.utilities.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ahmedtarek on 11/30/15.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.LocationViewHolder> {

    Post[] items;
    Context context;
    int version;
    final Activity activity;

    ListView commentsList;
    private CommentsListAdapter adapter;
    private int[] images = new int[]{R.drawable.ahmedtarek, R.drawable.hend};
    private String [] names = {"Ahmed Tarek", "Hend Hesham"};
    private String [] commentValues = {"Awesome", "7ilw awi bgd"};
    public ArrayList<String> friendNames;
    public ArrayList<Integer> friendImages;
    public ArrayList<String> comments;


    public ImagesAdapter(Post[] items, Context context, int version, Activity activity) {
        this.version = version;
        this.items = items;
        this.context = context;
        this.activity = activity;
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
    public void onBindViewHolder(final LocationViewHolder holder, int position) {


        friendNames = new ArrayList<String>();

        friendImages = new ArrayList<Integer>();
        comments = new ArrayList<String>();

        int i = names.length-1;
        while (i >= 0) {
            friendNames.add(names[i]);
            friendImages.add(images[i]);
            comments.add(commentValues[i]);
            i--;
        }


        final CommentsListAdapter adapter2 = new CommentsListAdapter(activity, friendNames, friendImages, comments);

        holder.commentsList.setAdapter(adapter2);

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
            holder.postButton.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {

                    comments.add(holder.post.getText().toString());
                    friendNames.add("Zamzamy");
                    friendImages.add(R.drawable.zamzamy);

                    CommentsListAdapter adapter2 = new CommentsListAdapter(activity, friendNames, friendImages, comments);

                    holder.commentsList.setAdapter(adapter2);
                    adapter2.notifyDataSetChanged();

                }
            });
        }








    }

    class LocationViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView userName, location;
        ListView commentsList;
        EditText post;
        final Button postButton;
        public LocationViewHolder(final View itemview) {
            super(itemview);

            post = (EditText) itemview.findViewById(R.id.post);
            postButton = (Button)  itemview.findViewById(R.id.postbutton);

            image = (ImageView) itemview.findViewById(R.id.image_post);
            userName = (TextView) itemview.findViewById(R.id.user_name);
            location = (TextView) itemview.findViewById(R.id.location);
            commentsList = (ListView) itemview.findViewById(R.id.commentsList);

            if (version ==0) {
                userName.setTypeface(Typeface.createFromAsset(context.getAssets(), "Raleway-Medium.ttf"));
                location.setTypeface(Typeface.createFromAsset(context.getAssets(), "Raleway-Medium.ttf"));
            }





        }
    }
}
