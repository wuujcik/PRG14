package com.wuujcik.prg14.neighbourhood;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.wuujcik.prg14.MainActivity;
import com.wuujcik.prg14.R;

import java.util.ArrayList;
import java.util.List;

public class NeighbourPost extends MainActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<Marker> markers = new ArrayList<>();
    private Marker markerPrg14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //support map view
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_neighbour);
        mapFragment.getMapAsync(this);


        /**
         * Handling buttons with the directions to markers
         */
        //sets the visibility to 1st button
        final FrameLayout object1 = findViewById(R.id.object1);
        object1.setVisibility(View.VISIBLE);
        final Button button1 = findViewById(R.id.neighbour_button1);
        button1.setText(getString(R.string.post1a));
        //sets the on click listener to 1st button
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                markerPrg14.showInfoWindow();
                markers.get(0).showInfoWindow();
                markers.get(1).hideInfoWindow();
            }
        });
        //sets on click listener to the directions image
        final ImageView go_to_object1 = findViewById(R.id.go_to_object1);
        go_to_object1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send intent to show the directions between PRG14 and the object1 in googlemaps
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.direction_post1)));
                startActivity(intent);
            }
        });

        //sets the visibility to 2nd button
        final FrameLayout object2 = findViewById(R.id.object2);
        object2.setVisibility(View.VISIBLE);
        final Button button2 = findViewById(R.id.neighbour_button2);
        button2.setText(getString(R.string.post2a));
        //sets the on click listener to 2nd button
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                markers.get(0).hideInfoWindow();
                markers.get(1).showInfoWindow();
            }
        });
        //sets on click listener to the directions image
        final ImageView go_to_object2 = findViewById(R.id.go_to_object2);
        go_to_object2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send intent to show the directions between PRG14 and the object2 in googlemaps
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.direction_post2)));
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:

                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // The list of LatLng for markers
        LatLng prg14 = new LatLng(50.098420,14.465882);
        LatLng post1 = new LatLng(50.102851,14.476698);
        LatLng post2 = new LatLng(50.093113,14.448234);



        //adds marker of PRG14 and moves camera
        markerPrg14 = mMap.addMarker(new MarkerOptions()
                .position(prg14)
                .title("PRG14")
                .snippet(getString(R.string.marker_address_prg14))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(prg14));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(prg14, 13.5f));
        markerPrg14.showInfoWindow();

        //adds markers of ATMs
        Marker marker0 = mMap.addMarker(new MarkerOptions()
                .position(post1)
                .title(getString(R.string.post1))
                .snippet("Sokolovská 260/143")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));



        Marker marker1 = mMap.addMarker(new MarkerOptions()
                .position(post2)
                .title(getString(R.string.post2))
                .snippet("Karlínské nám. 145/1")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


        markers.add(marker0);
        markers.add(marker1);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
