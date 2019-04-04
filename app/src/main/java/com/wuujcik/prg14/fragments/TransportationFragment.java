package com.wuujcik.prg14.fragments;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wuujcik.prg14.Place;
import com.wuujcik.prg14.PlaceAdapter;
import com.wuujcik.prg14.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransportationFragment extends Fragment {


    public TransportationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.list_view, container, false);

        //the list of all transport elements that should be shown on the app
        final ArrayList<Place> transportPlace = new ArrayList<>();
        transportPlace.add(new Place(getString(R.string.name_transportOverview), getString(R.string.description_transportOverview)));
        transportPlace.add(new Place(getString(R.string.name_ticketPrices), getString(R.string.description_ticketPrices), getString(R.string.website_ticketPrices)));
        transportPlace.add(new Place(getString(R.string.name_WhereToBuyTickets), getString(R.string.description_WhereToBuyTickets), getString(R.string.website_WhereToBuyTickets)));
        transportPlace.add(new Place(getString(R.string.name_litackaApp), getString(R.string.description_litackaApp), getString(R.string.website_litackaApp)));
        transportPlace.add(new Place(getString(R.string.name_litackaCard), getString(R.string.description_litackaCard), getString(R.string.website_litackaCard)));
        transportPlace.add(new Place(getString(R.string.name_taxi), getString(R.string.description_taxi)));


        //sets the layout to use PlaceAdapter
                PlaceAdapter adapter = new PlaceAdapter(getActivity(), transportPlace);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        listView.setAdapter(adapter);

        //When the user clicks on the list_item on the list view, it opens the website linked to the object
        // or shows a toast message if no website
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Place transport = transportPlace.get(position);
                if (transport.getmWebsite() != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(transport.getmWebsite()));
                    startActivity(intent);
                } else {
                    //Shows TOAST message "Sorry, no website!" in the category doesn't have the URL added to the Place object
                    Context context = getActivity().getApplicationContext();
                    CharSequence text = getString(R.string.no_website);
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        return rootView;
    }
}
