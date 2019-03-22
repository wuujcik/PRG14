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


public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.list_view, container, false);

        //the list of all restaurants that should be shown on the app
        final ArrayList<Place> restaurants = new ArrayList<>();
        restaurants.add(new Place(getString(R.string.name_sushiTime), getString(R.string.address_sushiTime), R.drawable.icon_sushi, getString(R.string.website_sushiTime)));
        restaurants.add(new Place(getString(R.string.name_fastGood), getString(R.string.address_fastGood), R.drawable.icon_fast_good, getString(R.string.website_fastGood)));
        restaurants.add(new Place(getString(R.string.name_kebabMardin), getString(R.string.address_kebabMardin), R.drawable.icon_blank));
        restaurants.add(new Place(getString(R.string.name_greenFactory), getString(R.string.address_green_factory), R.drawable.icon_green_factory, getString(R.string.website_greenFactory)));
        restaurants.add(new Place(getString(R.string.name_cafe_le_noble), getString(R.string.address_cafe_le_noble), R.drawable.icon_cafe_le_noble, getString(R.string.website_cafe_le_noble)));
        restaurants.add(new Place(getString(R.string.name_liliova_cajovna), getString(R.string.address_liliova_cajovna), R.drawable.icon_liliova_cajovna,getString(R.string.website_liliova_cajovna)));
        restaurants.add(new Place(getString(R.string.name_dame_jidlo), getString(R.string.address_dame_jidlo), R.drawable.icon_dame_jidlo, getString(R.string.website_dame_jidlo)));
        restaurants.add(new Place(getString(R.string.name_albert), getString(R.string.address_albert), R.drawable.icon_albert, getString(R.string.website_albert)));

        //sets the layout to use PlaceAdapter
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), restaurants);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        listView.setAdapter(adapter);

        //When the user clicks on the list_item on the list view, it opens the website linked to the object
        // or shows a toast message if no website
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Place restaurant = restaurants.get(position);
                if (restaurant.getmWebsite() != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(restaurant.getmWebsite()));
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
