package com.wuujcik.prg14.neighbourhood;

import android.os.Bundle;
import android.view.MenuItem;
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

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_atm);
        mapFragment.getMapAsync(this);
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
                .title("Česká spořitelna - ATM")
                .snippet("Molákova 578/36")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mMap.addMarker(new MarkerOptions()
                .position(atm2)
                .title("Euronet Services - ATM")
                .snippet("Sokolovská 615/138")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mMap.addMarker(new MarkerOptions()
                .position(atm3)
                .title("ČSOB - ATM")
                .snippet("Sokolovská 663/136")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
