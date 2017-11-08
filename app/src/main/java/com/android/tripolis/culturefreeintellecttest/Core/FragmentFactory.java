package com.android.tripolis.culturefreeintellecttest.Core;

import android.support.v4.app.Fragment;

/**
 * Created by tripo on 11/4/2017.
 */

public interface FragmentFactory<T> {

    Fragment createFragment(T dataObject);

}
