package com.android.tripolis.culturefreeintellecttest.Fragment.CFIT;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.tripolis.culturefreeintellecttest.Core.Question;
import com.android.tripolis.culturefreeintellecttest.Fragment.CFITFragment;
import com.android.tripolis.culturefreeintellecttest.R;
import com.android.tripolis.culturefreeintellecttest.View.SelectableImageView;

/**
 * Created by tripo on 11/5/2017.
 */

public class FirstSubtestQuestionFragment extends CFITFragment {

    public static final String TAG = "CIFT_FirstSubtestQuestionFragment";

    private static final int QUESTION_IMAGE_COUNT = 3;
    private static final int ANSWER_IMAGE_COUNT = 5;

    //private FragmentManager fragmentManager;
    private Question question;

    private ImageView questionImageViews[];
    private SelectableImageView answerImageViews[];

    private boolean answerSelected = false;

    public static FirstSubtestQuestionFragment newInstance(Question question) {
        Bundle args = new Bundle();

        FirstSubtestQuestionFragment fragment = new FirstSubtestQuestionFragment();
        fragment.setArguments(args);
        fragment.setQuestion(question);

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

        answerImageViews = new SelectableImageView[ANSWER_IMAGE_COUNT];
        answerImageViews[0] = (SelectableImageView) rootView.findViewById(R.id.subtestFirstImageAnswer1);
        answerImageViews[1] = (SelectableImageView) rootView.findViewById(R.id.subtestFirstImageAnswer2);
        answerImageViews[2] = (SelectableImageView) rootView.findViewById(R.id.subtestFirstImageAnswer3);
        answerImageViews[3] = (SelectableImageView) rootView.findViewById(R.id.subtestFirstImageAnswer4);
        answerImageViews[4] = (SelectableImageView) rootView.findViewById(R.id.subtestFirstImageAnswer5);

        final Resources res = getResources();
        Drawable questionDrawable = res.getDrawable(R.drawable.question);


        for (ImageView image : questionImageViews) {
            image.setImageDrawable(questionDrawable);
        }

        for (final SelectableImageView image : answerImageViews) {
            image.setImageDrawable(questionDrawable);;
            image.setSelectResource(R.drawable.active_answer_border);
            image.setSelectListener(new SelectableImageView.OnImageSelectListener() {
                @Override
                public void onSelect(View v) {
                    answerSelected = true;
                    for (SelectableImageView image : answerImageViews) {
                        if (image.equals(v)) continue;
                        image.setSelectEnabled(false);
                    }
                }

                @Override
                public void onUnselect(View v) {
                    answerSelected = false;
                    for (SelectableImageView image : answerImageViews) {
                        if (image.equals(v)) continue;
                        image.setSelectEnabled(true);
                    }
                }
            });
        }

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
