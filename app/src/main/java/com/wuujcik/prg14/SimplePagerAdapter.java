package com.wuujcik.prg14;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class SimplePagerAdapter extends FragmentPagerAdapter {

    public SimplePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new LocationFragment();
            case 1: return new TransportFragment();
            case 2: return new FoodFragment();
            case 3: return new NeighbourhoodFragment();
            case 4: return new EveningsFragment();
            case 5: return new BusinessesFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 6;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Location";
            case 1: return "Transport";
            case 2: return "Food";
            case 3: return "Neighbourhood";
            case 4: return "Evenings";
            case 5: return "what we do";
        }return null;
    }
}
