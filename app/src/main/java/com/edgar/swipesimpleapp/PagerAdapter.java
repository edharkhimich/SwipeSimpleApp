package com.edgar.swipesimpleapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


public class PagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> frags;

    public PagerAdapter(FragmentManager fm, List<Fragment> frags) {
        super(fm);
        this.frags = frags;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return frags.get(0);
            case 1:
                return frags.get(1);
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
