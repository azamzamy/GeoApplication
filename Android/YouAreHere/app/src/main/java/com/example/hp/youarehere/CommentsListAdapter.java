package com.example.hp.youarehere;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by zamzamy on 12/1/15.
 */
public class CommentsListAdapter extends ArrayAdapter<String>{


    private Activity context;
    private ArrayList<String> friendName = new ArrayList<String>();
    private ArrayList<Integer> friendImage = new ArrayList<Integer>();
    private ArrayList<String> tempItemname;
    private ArrayList<Integer> tempImgid;
    private ArrayList<String> comments = new ArrayList<String>();

    public ArrayList<String> getItemName() {
        return friendName;
    }

    public void setItemName(ArrayList<String> itemName) {
        this.friendName = itemName;
    }

    public ArrayList<Integer> getImgId() {
        return friendImage;
    }

    public void setImgId(ArrayList<Integer> imgId) {
        this.friendImage = imgId;
    }

    public CommentsListAdapter(Activity context, ArrayList<String> itemName, ArrayList<Integer> imgId, ArrayList<String> comment) {
        super(context, R.layout.comment, itemName);
        this.context = context;
        this.friendName = itemName;
        this.friendImage = imgId;
        tempImgid = new ArrayList<Integer>();
        tempItemname = new ArrayList<String>();
        tempImgid.addAll(imgId);
        comments.addAll(comment);
        tempItemname.addAll(itemName);
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.comment, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.friendname);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.friendimage);
        TextView comm = (TextView) rowView.findViewById(R.id.comment);

        txtTitle.setText(friendName.get(position));
        imageView.setImageResource(friendImage.get(position));
        comm.setText(comments.get(position));

        return rowView;
    }

    /**
     * Filter the list of rooms (itemName) matching a certain word
     *
     * @param charText string to filter with
     */

    public void filter(String charText) {

        charText = charText.toLowerCase(Locale.getDefault());
        friendName.clear();
        friendImage.clear();

        for (int pos = 0; pos < tempItemname.size(); pos++) {
            String name = tempItemname.get(pos).toLowerCase();
            if (name.startsWith(charText) || name.contains(" " + charText)) {
                friendName.add(tempItemname.get(pos));
                friendImage.add(tempImgid.get(pos));
            }
        }
        notifyDataSetChanged();
    }

}
