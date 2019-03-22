package com.wuujcik.prg14;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * The adapter for the ArrayList of the Place objects
 */

public class PlaceAdapter extends ArrayAdapter<Place> {


    public PlaceAdapter(Activity context, ArrayList<Place> place) {
        super(context, 0, place);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
           listItemView.setClipToOutline(true);
        }

        Place currentPlace = getItem(position);

        // Get the name of the place from the current Place object and
        // set this text on the element_title TextView
        TextView titleTextView = listItemView.findViewById(R.id.element_title);
        titleTextView.setText(currentPlace.getmTitle());


        // Get the physical address of the place from the current Place object and
        // set this text on the element_address TextView
        TextView addressTextView = listItemView.findViewById(R.id.element_address);
        addressTextView.setText(currentPlace.getmAddress());

        //checks if there is an image that should be shown on the ListView
        // and makes it disappear if not
        if (currentPlace.hasImage()) {
            ImageView iconView = (ImageView) listItemView.findViewById(R.id.element_icon);
            iconView.setImageResource(currentPlace.getmIcon());
        } else {
            ImageView iconView = (ImageView) listItemView.findViewById(R.id.element_icon);
            iconView.setVisibility(View.GONE);
        }

        //checks if there is an website attached to the Place object
        //if yes - shows the icon_click_xml to suggest user that s/he can click on the item
        //if no - makes the icon_click_xml disappear since it's not clickable
        if (currentPlace.getmWebsite() != null) {
            ImageView iconClick = (ImageView) listItemView.findViewById(R.id.element_www);
            iconClick.setVisibility(View.VISIBLE);
        } else {
            ImageView iconClick = (ImageView) listItemView.findViewById(R.id.element_www);
            iconClick.setVisibility(View.GONE);

        }


        return listItemView;
    }

}
