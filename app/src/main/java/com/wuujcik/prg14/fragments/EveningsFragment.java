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
import android.widget.Toast;

import com.wuujcik.prg14.Place;
import com.wuujcik.prg14.PlaceAdapter;
import com.wuujcik.prg14.R;

import java.util.ArrayList;

public class EveningsFragment extends Fragment {

    public EveningsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        //the list of all evenings activities that should be shown on the app
        final ArrayList<Place> evenings = new ArrayList<>();
        evenings.add(new Place("Aero cinema", "Biskupcova 31",R.drawable.icon_kino_aero, "https://www.kinoaero.cz/en"));
        evenings.add(new Place("Summer cinema Regina", "Hybešova 10", R.drawable.icon_summer_cinema,"http://www.karlinske-filmove-leto.cz/"));
        evenings.add(new Place("Atlas cinema", "Sokolovská 1", R.drawable.icon_kino_atlas, "http://www.kinoatlas.cz/klient-181/kino-52/jazyk-en_GB"));
        evenings.add(new Place("Forum Karlin", "Pernerova 51", R.drawable.icon_forum_karlin, "https://www.forumkarlin.cz/Events/en"));

        //sets the layout to use PlaceAdapter
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), evenings);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        listView.setAdapter(adapter);

        //When the user clicks on the list_item on the list view, it opens the website linked to the object
        // or shows a toast message if no website
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Place evening = evenings.get(position);
                if (evening.getmWebsite() != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(evening.getmWebsite()));
                    startActivity(intent);
                } else {
                    //Shows TOAST message "Sorry, no website!" in the restaurant doesn't have the URL added to the Place object
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
