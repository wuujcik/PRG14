package com.wuujcik.prg14.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.wuujcik.prg14.R;


public class LocationFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    MapView mMapView;
    View rootView;
    ScrollView scrollView;


    public LocationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_location, container, false);
        scrollView = (ScrollView) rootView.findViewById(R.id.fragment_find);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle GoogleMapOptions) {
        super.onViewCreated(view, GoogleMapOptions);

        mMapView = (MapView) rootView.findViewById(R.id.map);
        if (mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

        LatLng prg14 = new LatLng(50.098420, 14.465882);
        Marker markerPrg14 = mGoogleMap.addMarker(new MarkerOptions()
                .position(prg14)
                .title("PRG14")
                .snippet(getString(R.string.marker_address_prg14))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(prg14));
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(prg14, 15.0f));
        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
        markerPrg14.showInfoWindow();

        GoogleMapOptions options = new GoogleMapOptions();
        options.rotateGesturesEnabled(true)
                .tiltGesturesEnabled(true)
                .mapToolbarEnabled(true)
                .scrollGesturesEnabled(true);
    }


}
