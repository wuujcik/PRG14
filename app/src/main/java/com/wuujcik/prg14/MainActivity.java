package com.wuujcik.prg14;


import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.wuujcik.prg14.neighbourhood.NeighbourAtm;
import com.wuujcik.prg14.neighbourhood.NeighbourCurrency;
import com.wuujcik.prg14.neighbourhood.NeighbourFitness;
import com.wuujcik.prg14.neighbourhood.NeighbourMedical;
import com.wuujcik.prg14.neighbourhood.NeighbourParks;
import com.wuujcik.prg14.neighbourhood.NeighbourPost;



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

        /**

        // Set the collapsing toolbar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*/
    }

    public void link_to_maps_app(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.link_to_google_maps_app)));
        startActivity(intent);
    }



    /**The below are onclick handlers for buttons within NeighbourhoodFragment */

    public void button_neighbour_atm(View view) {
        // Create a new intent to open the {@link NeighbourAtm}
        Intent intent = new Intent(MainActivity.this, NeighbourAtm.class);
        startActivity(intent);
    }

    public void button_button_neighbour_post_office(View view) {
        // Create a new intent to open the {@link NeighbourPost}
        Intent intent = new Intent(MainActivity.this, NeighbourPost.class);
        startActivity(intent);
    }

    public void button_neighbour_fittness(View view) {
        // Create a new intent to open the {@link NeighbourFitness}
        Intent intent = new Intent(MainActivity.this, NeighbourFitness.class);
        startActivity(intent);
    }

    public void button_neighbour_medical(View view) {
        // Create a new intent to open the {@link NeighbourMedical}
        Intent intent = new Intent(MainActivity.this, NeighbourMedical.class);
        startActivity(intent);
    }

    public void button_neighbour_parks(View view) {
        // Create a new intent to open the {@link NeighbourParks}
        Intent intent = new Intent(MainActivity.this, NeighbourParks.class);
        startActivity(intent);
    }

    public void button_neighbour_currency(View view) {
        // Create a new intent to open the {@link NeighbourCurrency}
        Intent intent = new Intent(MainActivity.this, NeighbourCurrency.class);
        startActivity(intent);
    }
}



