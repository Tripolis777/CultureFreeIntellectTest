package com.android.tripolis.culturefreeintellecttest.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.android.tripolis.culturefreeintellecttest.Core.Description;

/**
 * Created by tripo on 11/4/2017.
 */

public class DescriptionPagerAdapter extends FragmentPagerAdapter {

    private final Description description;
    private View.OnClickListener onAcceptButtonClickListener;

    public DescriptionPagerAdapter(FragmentManager fm, Description description, View.OnClickListener onAcceptButtonClickListener) {
        super(fm);
        this.description = description;
        this.onAcceptButtonClickListener = onAcceptButtonClickListener;
    }

    @Override
    public Fragment getItem(int position) {
        return description.getPageFragment(position);
    }

    @Override
    public int getCount() {
        return description.getPagesCount();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return description.getExample(position).getTitle();
    }
}
