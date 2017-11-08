package com.android.tripolis.culturefreeintellecttest.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.tripolis.culturefreeintellecttest.Core.Description;

/**
 * Created by tripo on 11/5/2017.
 */

public class ExamplePagerAdapter extends FragmentPagerAdapter {
    private final Description description;

    public ExamplePagerAdapter(FragmentManager fm, Description description) {
        super(fm);
        this.description = description;
    }

    @Override
    public Fragment getItem(int position) {
        return description.getPageFragment(position);
    }

    @Override
    public int getCount() {
        return description.getPagesCount();
    }
}
