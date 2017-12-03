package com.android.tripolis.culturefreeintellecttest.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.tripolis.culturefreeintellecttest.Adapter.DescriptionPagerAdapter;
import com.android.tripolis.culturefreeintellecttest.Adapter.QuestionPagerAdapter;
import com.android.tripolis.culturefreeintellecttest.Core.Subtest;
import com.android.tripolis.culturefreeintellecttest.R;

/**
 * Created by tripo on 11/4/2017.
 */

public class SubtestFragment extends CFITFragment {

    public static final String TAG = "subtest_fragment";

//    private FrameLayout fragmentPlaceholder;
    private ViewPager viewPager;
    private FragmentManager fragmentManager;
    private DescriptionPagerAdapter descriptionPagerAdapter;
    private QuestionPagerAdapter questionPagerAdapter;


    private Button nextSubtestButton;
    private Button cancelSubtestButton;
    private TextView subtestTime;
    private ProgressBar subtestProgressBar;

    private Subtest subtest;

    private int currentQuestion;


//    private class NextButtonClickListener implements View.OnClickListener {
//        @Override
//        public void onClick(View view) {
//            if (subtest == null) return;
//            switch (subtest.getState()) {
//                case DESCRIPTION:
//                    startTest();
//                    break;
//                case TESTING:
//                    createNextQuestion();
//                    break;
//                default0:
//                    return;
//            }
//        }
//    }
//
//    private class BackButtonClickListener implements View.OnClickListener {
//        @Override
//        public void onClick(View view) {
//            if (subtest == null) return;
//            switch (subtest.getState()) {
//                case TESTING:
//                    createLastQuestion();
//                    break;
//                default:
//                    return;
//            }
//        }
//    }

    public static SubtestFragment newInstance(Subtest subtest) {
        Bundle args = new Bundle();

        SubtestFragment fragment = new SubtestFragment();
        fragment.setSubtest(subtest);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.subtest_fragment, container, false);

        fragmentManager = this.getActivity().getSupportFragmentManager();
        descriptionPagerAdapter = new DescriptionPagerAdapter(fragmentManager, subtest.getDescription(), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setAdapter(questionPagerAdapter);
            }
        });
        questionPagerAdapter = new QuestionPagerAdapter(fragmentManager, subtest.getQuestionManager());

//        if (savedInstanceState == null) {
//            fragmentManager = this.getActivity().getSupportFragmentManager();
//            fragmentManager.beginTransaction()
//                    .add(R.id.subtestFragmentPlaceholder, createDescriptionFragment(subtest.getDescription()), "subtest_description")
//                    .commit();
//        }

        nextSubtestButton = (Button) rootView.findViewById(R.id.finishSubtestButton);
       cancelSubtestButton = (Button) rootView.findViewById(R.id.cancelSubtestButton);
        viewPager = (ViewPager) rootView.findViewById(R.id.subtestFragmentPlaceholder);
        subtestTime = (TextView) rootView.findViewById(R.id.subtestTimeTextView);
        subtestProgressBar = (ProgressBar) rootView.findViewById(R.id.subtestProgressBar);

        viewPager.setAdapter(descriptionPagerAdapter);

        //nextButton.setOnClickListener(new NextButtonClickListener());
        //backButton.setOnClickListener(new BackButtonClickListener());

        //this.checkButtonsEnable();

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


//    private Fragment createDescriptionFragment(Description description) {
//        return null;
//    }

//    private Fragment createQuestionFragment(int questionNum) {
//        QuestionManager questionManager = subtest.getQuestionManager();
//        Question question = questionManager.getQuestion(questionNum);
//        return questionManager.getFragmentFactory().createQuestionFragment(question);
//    }
//
//    private void startTest() {
//        this.currentQuestion = subtest.getStartQuestionNum();
//    }
//
//    private void createNextQuestion() {
//        if (this.currentQuestion >= subtest.getQuestionsCount())
//            return;
//
//        currentQuestion++;
//        fragmentManager.beginTransaction()
//                .replace(R.id.subtestFragmentPlaceholder, this.createQuestionFragment(currentQuestion))
//                .addToBackStack(null)
//                .commit();
//    }

    private void setSubtest(Subtest subtest) {
        this.subtest = subtest;
    }

//    private void checkButtonsEnable() {
//        switch (subtest.getState()) {
//            case TESTING:
//                int questionNum = subtest.getQuestionNum();
//                backButton.setEnabled(questionNum > 1);
//                nextButton.setEnabled(questionNum < subtest.getQuestionsCount());
//            default:
//                backButton.setEnabled(false);
//                nextButton.setEnabled(false);
//        }
//    }


}
