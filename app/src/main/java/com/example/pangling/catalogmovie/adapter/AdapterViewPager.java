package com.example.pangling.catalogmovie.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.pangling.catalogmovie.fragment.NowPlayingFragment;
import com.example.pangling.catalogmovie.fragment.UpcomingFragment;

public class AdapterViewPager extends FragmentPagerAdapter {
    int numm;

    public AdapterViewPager(FragmentManager fm, int numm) {
        super(fm);
        this.numm = numm;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                NowPlayingFragment tab1 = new NowPlayingFragment();
                return tab1;
            case 1:
                UpcomingFragment tab2 = new UpcomingFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numm;
    }
}
