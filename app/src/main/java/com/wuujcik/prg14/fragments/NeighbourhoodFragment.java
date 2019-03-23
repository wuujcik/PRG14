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
        View rootView = inflater.inflate(R.layout.fragment_neighbourhood, container, false);


        return rootView;
    }

}