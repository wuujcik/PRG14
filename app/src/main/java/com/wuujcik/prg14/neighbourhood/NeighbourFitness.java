package com.wuujcik.prg14.neighbourhood;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

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

public class NeighbourFitness extends MainActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<Marker> markers = new ArrayList<>();
    private Marker markerPrg14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_fitness);
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
        button1.setText(getString(R.string.gym1));
        //sets the on click listener to 1st button
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                markerPrg14.showInfoWindow();
                markers.get(0).showInfoWindow();
                markers.get(1).hideInfoWindow();
                markers.get(2).hideInfoWindow();

            }
        });
        //sets on click listener to the directions image
        final LinearLayout go_to_object1 = findViewById(R.id.go_to_object1);
        go_to_object1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send intent to open website
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.web_yogaKarlin)));
                startActivity(intent);
            }
        });

        //sets the visibility to 2nd button
        final FrameLayout object2 = findViewById(R.id.object2);
        object2.setVisibility(View.GONE);
        final Button button2 = findViewById(R.id.neighbour_button2);
        button2.setText(getString(R.string.atm2));
        //sets the on click listener to 2nd button
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                markers.get(0).hideInfoWindow();
                markers.get(1).showInfoWindow();
                markers.get(2).hideInfoWindow();
            }
        });
        //sets on click listener to the directions image
        final ImageView go_to_object2 = findViewById(R.id.go_to_object2);
        go_to_object2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO set intent for on click listener for button
                //send intent to show the directions between PRG14 and the object2 in googlemaps
//                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                        Uri.parse(getString(R.string.direction_atm2)));
//                startActivity(intent);
            }
        });


        //sets the visibility to 3rd button
        final FrameLayout object3 = findViewById(R.id.object3);
        object3.setVisibility(View.GONE);
        final Button button3 = findViewById(R.id.neighbour_button3);
        button3.setText(R.string.atm3);
        //sets the on click listener to 3rd button
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                markers.get(0).hideInfoWindow();
                markers.get(1).hideInfoWindow();
                markers.get(2).showInfoWindow();
            }
        });
        //sets on click listener to the directions image
        final ImageView go_to_object3 = findViewById(R.id.go_to_object3);
        go_to_object3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO set intent for on click listener for button
                //send intent to show the directions between PRG14 and the object3 in googlemaps
//                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                        Uri.parse(getString(R.string.direction_atm3)));
//                startActivity(intent);
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
        LatLng prg14 = new LatLng(50.098420, 14.465882);
        LatLng gym1 = new LatLng(50.093030, 14.456598);
        LatLng gym2 = new LatLng(50.098470, 14.468330);
        LatLng gym3 = new LatLng(50.096610, 14.464170);


        //adds marker of PRG14 and moves camera
        markerPrg14 = mMap.addMarker(new MarkerOptions()
                .position(prg14)
                .title("PRG14")
                .snippet(getString(R.string.marker_address_prg14))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(prg14));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(prg14, 13.5f));
        markerPrg14.showInfoWindow();

        //adds markers of gyms and fitnesses
        Marker marker0 = mMap.addMarker(new MarkerOptions()
                .position(gym1)
                .title(getString(R.string.gym1))
                .snippet("Březinova 13")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


//TODO add markers for more gyms
//        Marker marker1 = mMap.addMarker(new MarkerOptions()
//                .position(gym2)
//                .title(getString(R.string.atm2))
//                .snippet("Sokolovská 615/138")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
//
//        Marker marker2 =  mMap.addMarker(new MarkerOptions()
//                .position(gym3)
//                .title(getString(R.string.atm3))
//                .snippet("Sokolovská 663/136")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        markers.add(marker0);
//        markers.add(marker1);
//        markers.add(marker2);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
