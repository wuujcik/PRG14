package com.wuujcik.prg14;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_restaurants, container, false);

        final ArrayList<Place> restaurant = new ArrayList<>();
        restaurant.add(new Place(getString(R.string.name_sushiTime), getString(R.string.address_sushiTime), R.drawable.icon_sushi, getString(R.string.website_sushiTime)));
        restaurant.add(new Place(getString(R.string.name_fastGood), getString(R.string.address_fastGood), R.drawable.icon_fast_good, getString(R.string.website_fastGood)));
        restaurant.add(new Place(getString(R.string.name_kebabMardin), getString(R.string.address_kebabMardin), R.drawable.icon_blank));
        restaurant.add(new Place(getString(R.string.name_greenFactory), getString(R.string.address_green_factory), R.drawable.icon_green_factory, getString(R.string.website_greenFactory)));
        restaurant.add(new Place(getString(R.string.name_cafe_le_noble), getString(R.string.address_cafe_le_noble), R.drawable.icon_cafe_le_noble, getString(R.string.website_cafe_le_noble)));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), restaurant);
        ListView listView = (ListView) rootView.findViewById(R.id.layout_restautants);

        listView.setAdapter(adapter);





        return rootView;
    }
}
