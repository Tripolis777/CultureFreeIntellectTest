package com.android.tripolis.culturefreeintellecttest.Fragment.CFIT;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample.ExampleImage;
import com.android.tripolis.culturefreeintellecttest.R;

/**
 * Created by tripo on 11/5/2017.
 */

public class DescriptionWithImageFragment extends Fragment {

    public static final String TAG = "CIFT_DescriptionWithImageFragment";

    private ExampleImage exampleImage;
    private boolean created = false;

    private TextView subtestInfoImageName;
    private TextView subtestInfoImageDescription;
    private ImageView subtestInfoImage;

    public static DescriptionWithImageFragment newInstance(ExampleImage exampleImage) {
        Bundle args = new Bundle();

        DescriptionWithImageFragment fragment = new DescriptionWithImageFragment();
        fragment.setArguments(args);
        fragment.setExampleImage(exampleImage);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.subtest_description_with_image, container, false);

        subtestInfoImageDescription = (TextView) rootView.findViewById(R.id.subtestInfoImageDescription);
        subtestInfoImageName = (TextView) rootView.findViewById(R.id.subtestInfoImageName);
        subtestInfoImage = (ImageView) rootView.findViewById(R.id.subtestInfoImage);

        created = true;
        this.init();

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void init() {
        if (exampleImage == null || !created)
            return;

        subtestInfoImageName.setText(exampleImage.getImageName());
        subtestInfoImageDescription.setText(exampleImage.getImageInfo());
        subtestInfoImage.setImageDrawable(exampleImage.getImage());
    }

    public void setExampleImage(ExampleImage exampleImage) {
        this.exampleImage = exampleImage;
    }

}
