package com.android.tripolis.culturefreeintellecttest.Fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.tripolis.culturefreeintellecttest.Adapter.ExamplePagerAdapter;
import com.android.tripolis.culturefreeintellecttest.Core.Description;
import com.android.tripolis.culturefreeintellecttest.R;

/**
 * Created by tripo on 11/5/2017.
 */

public class SubtestInfoFragment extends Fragment {
    public static final String TAG = "subtest_info_fragment";

    private TextView subtestNameTextView;
    private TextView subtestInfoTextView;
    private ViewPager exampleViewPager;
    private TabLayout exampleTabLayout;

    private ExamplePagerAdapter examplePagerAdapter;

    private Description description;


    public static SubtestInfoFragment newInstance(Description description) {
        Bundle args = new Bundle();

        SubtestInfoFragment fragment = new SubtestInfoFragment();
        fragment.setArguments(args);
        fragment.setDescription(description);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.subtest_info_fragment, container, false);

        subtestNameTextView = (TextView) rootView.findViewById(R.id.subtestInfoName);
        subtestInfoTextView = (TextView) rootView.findViewById(R.id.subtestInfoTopText);
        exampleTabLayout = (TabLayout) rootView.findViewById(R.id.exampleTabLayout);
        exampleViewPager = (ViewPager) rootView.findViewById(R.id.examleViewPager);

        subtestNameTextView.setText(description.getTestName());
        subtestInfoTextView.setText(description.getTestDescription());

        examplePagerAdapter = new ExamplePagerAdapter(
                this.getActivity().getSupportFragmentManager(), description);

        for (int i = 0; i < description.getPagesCount(); i++) {
            exampleTabLayout.addTab(exampleTabLayout.newTab().setText(description.getExample(i).getTitle()));
        }
        exampleTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        exampleViewPager.setAdapter(examplePagerAdapter);
        exampleViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(exampleTabLayout));
        exampleTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                exampleViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void setDescription(Description description) {
        this.description = description;
    }

}
