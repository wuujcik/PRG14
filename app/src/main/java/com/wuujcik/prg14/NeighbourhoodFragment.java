package com.wuujcik.prg14;


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
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NeighbourhoodFragment extends Fragment {


    public NeighbourhoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        //the list of all restaurants that should be shown on the app
        final ArrayList<Place> neighbours = new ArrayList<>();
        neighbours.add(new Place("ATM1", "ATM1 address"));
        neighbours.add(new Place("post office", "post office address"));
        neighbours.add(new Place("fitness1", "fitness1 address"));

        //sets the layout to use PlaceAdapter
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), neighbours);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        listView.setAdapter(adapter);

        //When the user clicks on the list_item on the list view, it opens the website linked to the object
        // or shows a toast message if no website
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Place place = neighbours.get(position);
                if (place.getmWebsite() != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(place.getmWebsite()));
                    startActivity(intent);
                } else {
                    //Shows TOAST message "Sorry, no website!" in the place doesn't have the URL added to the Place object
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
