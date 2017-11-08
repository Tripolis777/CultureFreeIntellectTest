package com.android.tripolis.culturefreeintellecttest.Fragment.CFIT;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tripolis.culturefreeintellecttest.R;

import org.w3c.dom.Text;

/**
 * Created by tripo on 11/5/2017.
 */

public class DescriptionWithImageFragment extends Fragment {

    public static final String TAG = "CIFT_DescriptionWithImageFragment";

    private TextView subtestNameTextView;
    private TextView subtestInfoTextView;
    //private TextView subtestIfoImageNameTextView;
    // private ViewPager examplePagers.


    public static DescriptionWithImageFragment newInstance() {
        Bundle args = new Bundle();

        DescriptionWithImageFragment fragment = new DescriptionWithImageFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.subtest_info_fragment, container, false);


        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
