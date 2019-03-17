package com.wuujcik.prg14;

import android.app.Activity;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    //TODO dodać możliwość stron internetowych

    public PlaceAdapter (Activity context, ArrayList<Place> place){
        super(context, 0, place);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Place currentPlace = getItem(position);

        TextView titleTextView = listItemView.findViewById(R.id.element_title);
        titleTextView.setText(currentPlace.getmTitle());


        TextView addressTextView = listItemView.findViewById(R.id.element_address);
        addressTextView.setText(currentPlace.getmAddress());

        TextView websiteTextView = listItemView.findViewById(R.id.element_website);
        websiteTextView.setText(currentPlace.getmWebsite());

        if (currentPlace.hasImage()) {
            ImageView iconView = (ImageView) listItemView.findViewById(R.id.element_icon);
            iconView.setImageResource(currentPlace.getmIcon());
        } else {
            ImageView iconView = (ImageView) listItemView.findViewById(R.id.element_icon);
            iconView.setVisibility(View.GONE);
        }





    return listItemView;
    }

}