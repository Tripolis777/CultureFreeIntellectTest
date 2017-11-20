package com.android.tripolis.culturefreeintellecttest.Fragment.CFIT;

import android.graphics.drawable.Drawable;
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

    public static class DescriptionWithImage {
        public String imageName;
        public String imageDescription;
        public Drawable imageQuestion;
        public Drawable imageAnswer;
    }

    private DescriptionWithImage descriptionWithImage;
    private boolean created = false;

    private TextView subtestInfoImageName;
    private TextView subtestInfoImageDescription;
    private ImageView subtestInfoImageQuestion;
    private ImageView subtestInfoImageAnswer;

    public static DescriptionWithImageFragment newInstance(DescriptionWithImage descriptionWithImage) {
        Bundle args = new Bundle();

        DescriptionWithImageFragment fragment = new DescriptionWithImageFragment();
        fragment.setArguments(args);
        fragment.setDescriptionWithImage(descriptionWithImage);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.subtest_description_with_image, container, false);

        subtestInfoImageDescription = (TextView) rootView.findViewById(R.id.subtestInfoImageDescription);
        subtestInfoImageName = (TextView) rootView.findViewById(R.id.subtestInfoImageName);
        subtestInfoImageQuestion = (ImageView) rootView.findViewById(R.id.subtestInfoImageQuestion);
        subtestInfoImageAnswer = (ImageView) rootView.findViewById(R.id.subtestInfoImageAnswer);

        created = true;
        this.init();

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void init() {
        if (descriptionWithImage == null || !created)
            return;

        subtestInfoImageName.setText(descriptionWithImage.imageName);
        subtestInfoImageDescription.setText(descriptionWithImage.imageDescription);
        subtestInfoImageQuestion.setImageDrawable(descriptionWithImage.imageQuestion);
        subtestInfoImageAnswer.setImageDrawable(descriptionWithImage.imageAnswer);
    }

    public void setDescriptionWithImage(DescriptionWithImage descriptionWithImage) {
        this.descriptionWithImage = descriptionWithImage;
    }

}
