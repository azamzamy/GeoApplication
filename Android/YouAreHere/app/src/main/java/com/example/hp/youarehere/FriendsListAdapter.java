package com.example.hp.youarehere;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.youarehere.models.Friendship;
import com.example.hp.youarehere.utilities.RetroFitController;
import com.example.hp.youarehere.utilities.RetrofitSingleton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by zamzamy on 12/1/15.
 */
public class FriendsListAdapter extends ArrayAdapter<String>{


    private Activity context;
    private ArrayList<String> friendName;
    private ArrayList<String> friendImage;
    private ArrayList<Integer> friendIds;
    private ArrayList<String> tempItemname;
    private ArrayList<String> tempImgid;
    private int version;

    public ArrayList<String> getItemName() {
        return friendName;
    }

    public void setItemName(ArrayList<String> itemName) {
        this.friendName = itemName;
    }

    public ArrayList<String> getImgId() {
        return friendImage;
    }

    public void setImgId(ArrayList<String> imgId) {
        this.friendImage = imgId;
    }

    public FriendsListAdapter(Activity context, ArrayList<String> itemName, ArrayList<String> imgId, ArrayList<Integer> fid, int version) {
        super(context, R.layout.mylist, itemName);
        this.context = context;
        this.friendName = itemName;
        this.friendImage = imgId;
        tempImgid = new ArrayList<String>();
        tempItemname = new ArrayList<String>();
        tempImgid.addAll(imgId);
        tempItemname.addAll(itemName);
        this.friendIds = fid ;
        this.version = version;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);
        if(version == 1){ rowView = inflater.inflate(R.layout.mylist, null, true); }
        if(version == 2){rowView = inflater.inflate(R.layout.mylist2, null, true); }
        TextView txtTitle = (TextView) rowView.findViewById(R.id.friendname);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.friendimage);

        txtTitle.setText(friendName.get(position));
        Picasso.with(context).load(friendImage.get(position)).into(imageView);

        LinearLayout layout = (LinearLayout) rowView.findViewById(R.id.mylistlayout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Profile.class);

                // ListView Clicked item value
                String  itemValue    = (String) friendName.get(position);

                intent.putExtra("friend", itemValue);
                context.startActivity(intent);

            }
        });
        if(version == 1) {
            ImageView Unfriend = (ImageView) rowView.findViewById(R.id.unfriend);

            Unfriend.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {

                    new AlertDialog.Builder(context)
                            .setTitle("Unfriend")
                            .setMessage("Are you sure you want to unfollow " + friendName.get(position) + "?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    RetroFitController.RemoveFriend remfr = RetrofitSingleton.getInstance().create(RetroFitController.RemoveFriend.class);
                                    remfr.removeFriend(1 + "", friendIds.get(position) + "", new Callback<Boolean>() {

                                        @Override
                                        public void success(Boolean aBoolean, Response response) {
                                            Log.d("WEEEEEEEEEEHAAAAAAAAA", friendIds.get(position) + "");
                                            notifyDataSetChanged();
                                        }

                                        @Override
                                        public void failure(RetrofitError error) {

                                        }
                                    });

                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }

            });
        }
        else if(version == 2){

            ImageView addfriend = (ImageView) rowView.findViewById(R.id.add);

            addfriend.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {

                    new AlertDialog.Builder(context)
                            .setTitle("Add Friend")
                            .setMessage("Are you sure you want to Add " + friendName.get(position) + "?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    RetroFitController.AddFriend adder = RetrofitSingleton.getInstance().create(RetroFitController.AddFriend.class);
                                    adder.addFriend(1+"", friendIds.get(position) + "", true, new Callback<Friendship>() {

                                        @Override
                                        public void success(Friendship fr, Response response) {
                                            Toast.makeText(context, "Friend Added", Toast.LENGTH_SHORT).show();
                                            notifyDataSetChanged();
                                        }

                                        @Override
                                        public void failure(RetrofitError error) {
                                            Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
                                        }
                                    });

                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }

            });

        }

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
