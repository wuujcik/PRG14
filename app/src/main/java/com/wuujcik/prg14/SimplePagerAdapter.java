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
            case 0: return new FindFragment();
            case 1: return new RestaurantsFragment();
            case 2: return new ShopsFragment();
            case 3: return new AttractionsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Find it!";
            case 1: return "Restaurants";
            case 2: return "Shops";
            case 3: return "Attractions";
        }return null;
    }
}
