package com.android.tripolis.culturefreeintellecttest.Database;

/**
 * Created by v.karyagin on 10.11.2017.
 */

public interface TaskListener<T> {

    void onSuccess(T result);
    void onError();

}
