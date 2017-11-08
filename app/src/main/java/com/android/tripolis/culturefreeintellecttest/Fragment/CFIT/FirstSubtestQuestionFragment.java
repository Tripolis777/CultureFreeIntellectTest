package com.android.tripolis.culturefreeintellecttest.Fragment.CFIT;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.tripolis.culturefreeintellecttest.R;

/**
 * Created by tripo on 11/5/2017.
 */

public class FirstSubtestQuestionFragment extends Fragment {

    public static final String TAG = "CIFT_FirstSubtestQuestionFragment";

    private static final int QUESTION_IMAGE_COUNT = 3;
    private static final int ANSWER_IMAGE_COUNT = 5;

    //private FragmentManager fragmentManager;

    private ImageView questionImageViews[];
    private ImageView answerImageViews[];

    public static FirstSubtestQuestionFragment newInstance() {
        Bundle args = new Bundle();

        FirstSubtestQuestionFragment fragment = new FirstSubtestQuestionFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fisrt_subtest_template_fragment, container, false);

        //fragmentManager = this.getActivity().getSupportFragmentManager();
        questionImageViews = new ImageView[QUESTION_IMAGE_COUNT];
        questionImageViews[0] = (ImageView) rootView.findViewById(R.id.subtestFirstImage1);
        questionImageViews[1] = (ImageView) rootView.findViewById(R.id.subtestFirstImage2);
        questionImageViews[2] = (ImageView) rootView.findViewById(R.id.subtestFirstImage3);

        answerImageViews = new ImageView[ANSWER_IMAGE_COUNT];
        answerImageViews[0] = (ImageView) rootView.findViewById(R.id.subtestFirstImageAnswer1);
        answerImageViews[1] = (ImageView) rootView.findViewById(R.id.subtestFirstImageAnswer2);
        answerImageViews[2] = (ImageView) rootView.findViewById(R.id.subtestFirstImageAnswer3);
        answerImageViews[3] = (ImageView) rootView.findViewById(R.id.subtestFirstImageAnswer4);
        answerImageViews[4] = (ImageView) rootView.findViewById(R.id.subtestFirstImageAnswer5);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
