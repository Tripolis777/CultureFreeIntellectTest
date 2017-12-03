package com.android.tripolis.culturefreeintellecttest.Fragment;

import android.support.v4.app.Fragment;

/**
 * Created by v.karyagin on 12/2/17.
 */

public abstract class CFITFragment extends Fragment {

    protected String tag;

    public void setFragmentTag(String tag) {
        this.tag = tag;
    }

    public String getFragmentTag() {
        return tag;
    }
}
