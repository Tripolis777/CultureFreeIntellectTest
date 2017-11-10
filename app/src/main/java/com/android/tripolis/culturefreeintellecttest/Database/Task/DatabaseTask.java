package com.android.tripolis.culturefreeintellecttest.Database.Task;

import android.os.AsyncTask;

import com.android.tripolis.culturefreeintellecttest.Database.TaskListener;

/**
 * Created by v.karyagin on 10.11.2017.
 */

public abstract class DatabaseTask<T, G, P> extends AsyncTask<T, G, P> {

    protected final TaskListener<P> taskListener;

    public DatabaseTask(TaskListener<P> taskListener) {
        super();

        this.taskListener = taskListener;
    }

    @Override
    protected void onPostExecute(P result) {
        if (result == null) {
            taskListener.onError();
        } else {
            taskListener.onSuccess(result);
        }
    }

}
