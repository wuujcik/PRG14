package com.wuujcik.prg14;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wuujcik.prg14.fragments.BusinessesFragment;
import com.wuujcik.prg14.fragments.EveningsFragment;
import com.wuujcik.prg14.fragments.FoodFragment;
import com.wuujcik.prg14.fragments.LocationFragment;
import com.wuujcik.prg14.fragments.NeighbourhoodFragment;
import com.wuujcik.prg14.fragments.TransportFragment;
import com.wuujcik.prg14.fragments.TransportationFragment;


public class SimplePagerAdapter extends FragmentPagerAdapter {

    public SimplePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new LocationFragment();
            case 1: return new FoodFragment();
            case 2: return new NeighbourhoodFragment();
            case 3: return new EveningsFragment();
            case 4: return new TransportationFragment();
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
            case 1: return "Food";
            case 2: return "Neighbourhood";
            case 3: return "Evenings";
            case 4: return "Transport";
            case 5: return "what we do";
        }return null;
    }
}
