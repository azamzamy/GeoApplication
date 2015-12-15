package com.example.hp.youarehere.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hp.youarehere.CommentsListAdapter;
import com.example.hp.youarehere.R;
import com.example.hp.youarehere.models.CommentResponse;
import com.example.hp.youarehere.models.PhotosResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {

    ArrayList<CommentResponse> items;
    Context context;
    int version;
    final Activity activity;

    public CommentsAdapter(ArrayList<CommentResponse> items, Context context, Activity activity) {
        this.items = items;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_recycler_view_content, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(final CommentViewHolder holder, int position) {

        holder.userName.setText(items.get(position).user_id+"");
        holder.comment.setText(items.get(position).content);


    }

    class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView comment;
        public CommentViewHolder(final View itemview) {
            super(itemview);
            userName = (TextView) itemview.findViewById(R.id.comment_user_name);
            comment = (TextView) itemview.findViewById(R.id.comment_content);
        }
    }
}
