package com.wuujcik.prg14;


import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wuujcik.prg14.transport.BuyingTickets;
import com.wuujcik.prg14.transport.Litacka;
import com.wuujcik.prg14.transport.Taxi;
import com.wuujcik.prg14.transport.TicketPrices;
import com.wuujcik.prg14.transport.TransportOverview;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void link_to_maps_app(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.link_to_google_maps_app)));
        startActivity(intent);
    }


    /**The below are onclick handlers for buttons within TransportFragment */

    public void button_transport_overview(View view) {
        // Create a new intent to open the {@link TransportOverview}
        Intent transportIntent = new Intent(MainActivity.this, TransportOverview.class);
        startActivity(transportIntent);
    }

    public void button_transport_ticket_prices(View view) {
        // Create a new intent to open the {@link TicketPrices}
        Intent transportIntent = new Intent(MainActivity.this, TicketPrices.class);
        startActivity(transportIntent);
    }

    public void button_transport_buying_tickets(View view) {
        // Create a new intent to open the {@link BuyingTickets}
        Intent transportIntent = new Intent(MainActivity.this, BuyingTickets.class);
        startActivity(transportIntent);
    }

    public void button_transport_litacka(View view) {
        // Create a new intent to open the {@link Litacka}
        Intent transportIntent = new Intent(MainActivity.this, Litacka.class);
        startActivity(transportIntent);
    }

    public void button_transport_taxi(View view) {
        // Create a new intent to open the {@link Taxi}
        Intent transportIntent = new Intent(MainActivity.this, Taxi.class);
        startActivity(transportIntent);
    }
}



