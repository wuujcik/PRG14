package com.wuujcik.prg14.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.wuujcik.prg14.Place;
import com.wuujcik.prg14.PlaceAdapter;
import com.wuujcik.prg14.R;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusinessesFragment extends Fragment {


    public BusinessesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        //the list of all businesses that should be shown on the app
        final ArrayList<Place> businessPlace = new ArrayList<>();
        businessPlace.add(new Place(getString(R.string.name_hrs), getString(R.string.description_loremipsum)));
        businessPlace.add(new Place(getString(R.string.name_trms), getString(R.string.description_loremipsum)));
        businessPlace.add(new Place(getString(R.string.name_roc), getString(R.string.description_loremipsum)));
        businessPlace.add(new Place(getString(R.string.name_it), getString(R.string.description_loremipsum)));
        businessPlace.add(new Place(getString(R.string.name_learning), getString(R.string.description_loremipsum)));
        businessPlace.add(new Place(getString(R.string.name_es_tech), getString(R.string.description_loremipsum)));


        //sets the layout to use PlaceAdapter
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), businessPlace);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        listView.setAdapter(adapter);

        return rootView;
    }
}
