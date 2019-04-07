package com.wuujcik.prg14.neighbourhood;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.wuujcik.prg14.MainActivity;
import com.wuujcik.prg14.R;


public class NeighbourAtm extends MainActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_atm);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //support map view
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_atm);
        mapFragment.getMapAsync(this);

        //sets the visibility to 1st button
        final FrameLayout object1 = findViewById(R.id.object1);
        object1.setVisibility(View.VISIBLE);
        final Button button1 = findViewById(R.id.neighbour_button1);
        button1.setText(getString(R.string.atm1));
        //sets the on click listener to 1st button
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
           //     google.maps.event.trigger(marker, 'click');

              /**
                //send intent to show the directions between PRG14 and the object1 in googlemaps
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/dir/Amazon+PRG14,+Sokolovsk%C3%A1,+Praga+8-Invalidovna/%C4%8Cesk%C3%A1+spo%C5%99itelna,+a.s.+-+ATM,+ALBERT,+Mol%C3%A1kova+578%2F36,+186+00+Praha+8-Invalidovna/@50.0977123,14.4629938,17z/am=t/data=!4m14!4m13!1m5!1m1!1s0x470b9357cb3279c3:0x44b87dbe980ba8a!2m2!1d14.4657318!2d50.0984322!1m5!1m1!1s0x470b9357e1f96acd:0xa8ee19ec594319c4!2m2!1d14.4649385!2d50.0973692!3e2"));
                startActivity(intent);
               */
            }
        });

        //sets the visibility and on click listener to 2nd button
        final FrameLayout object2 = findViewById(R.id.object2);
        object2.setVisibility(View.VISIBLE);
        final Button button2 = findViewById(R.id.neighbour_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //send intent to show the directions between PRG14 and the object1 in googlemaps
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/dir/Amazon+PRG14,+Sokolovsk%C3%A1,+Praga+8-Invalidovna/Euronet+Services,+spol.+s+r.o.,+Sokolovsk%C3%A1+615%2F138,+186+00+Praha+8-Invalidovna/@50.0985586,14.4648408,17z/am=t/data=!4m14!4m13!1m5!1m1!1s0x470b9357cb3279c3:0x44b87dbe980ba8a!2m2!1d14.4657318!2d50.0984322!1m5!1m1!1s0x470b9357ad6bbc31:0x49b41fdf7315cfe4!2m2!1d14.4683271!2d50.0984669!3e2"));
                startActivity(intent);
            }
        });

        //sets the visibility and on click listener to 3rd button
        final FrameLayout object3 = findViewById(R.id.object3);
        object3.setVisibility(View.VISIBLE);
        final Button button3 = findViewById(R.id.neighbour_button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //send intent to show the directions between PRG14 and the object1 in googlemaps
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/dir/Amazon+PRG14,+Sokolovsk%C3%A1,+Praga+8-Invalidovna/%C4%8CSOB+bankomat,+Unnamed+Road,+186+00,+Invalidovna,+186+00+Praha+8/@50.0976266,14.4634441,18z/am=t/data=!4m14!4m13!1m5!1m1!1s0x470b9357cb3279c3:0x44b87dbe980ba8a!2m2!1d14.4657318!2d50.0984322!1m5!1m1!1s0x470b95c51bc6dad1:0x207b603edbb959be!2m2!1d14.4631635!2d50.0968176!3e2"));
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

        // The list of markers
        LatLng prg14 = new LatLng(50.098420, 14.465882);
        LatLng atm1 = new LatLng(50.097370, 14.464940);
        LatLng atm2 = new LatLng(50.098470, 14.468330);
        LatLng atm3 = new LatLng(50.096610, 14.464170);

        //adds marker of PRG14 and moves camera
        mMap.addMarker(new MarkerOptions()
                .position(prg14)
                .title("PRG14")
                .snippet("Sokolovská 268/115")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(prg14));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(prg14, 16.0f));

        //adds markers of ATMs
        mMap.addMarker(new MarkerOptions()
                .position(atm1)
                .title(getString(R.string.atm1))
                .snippet("Molákova 578/36")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mMap.addMarker(new MarkerOptions()
                .position(atm2)
                .title(getString(R.string.atm2))
                .snippet("Sokolovská 615/138")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mMap.addMarker(new MarkerOptions()
                .position(atm3)
                .title(getString(R.string.atm3))
                .snippet("Sokolovská 663/136")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
