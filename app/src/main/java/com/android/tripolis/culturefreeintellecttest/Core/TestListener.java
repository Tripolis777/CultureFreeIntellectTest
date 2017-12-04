package com.android.tripolis.culturefreeintellecttest.Core;

import com.android.tripolis.culturefreeintellecttest.Fragment.CFITFragment;

/**
 * Created by tripo on 12/4/2017.
 */

public interface TestListener{

    void onFragmentCreated(CFITFragment fragment);
    void onTestStart();
    void onSubtestStart();
    void onTestCancel();
    void onTestFinish();

}
