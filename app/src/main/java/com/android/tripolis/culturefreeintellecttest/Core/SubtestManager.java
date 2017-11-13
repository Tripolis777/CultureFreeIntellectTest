package com.android.tripolis.culturefreeintellecttest.Core;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.tripolis.culturefreeintellecttest.Database.Entries.DescriptionEntry;
import com.android.tripolis.culturefreeintellecttest.Database.Entries.QuestionEntry;
import com.android.tripolis.culturefreeintellecttest.Database.Query.Condition.WhereCondition;
import com.android.tripolis.culturefreeintellecttest.Database.Query.SimpleSelectQuery;
import com.android.tripolis.culturefreeintellecttest.Database.Response.DescriptionSelectResponse;
import com.android.tripolis.culturefreeintellecttest.Database.Response.DescriptionSelectResponseFactory;
import com.android.tripolis.culturefreeintellecttest.Database.Response.SelectResponse;
import com.android.tripolis.culturefreeintellecttest.Database.Task.DatabaseSelectTask;
import com.android.tripolis.culturefreeintellecttest.Database.TaskListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Created by v.karyagin on 10.11.2017.
 */

public class SubtestManager {

    public static interface SubtestCreateListener {
        void onSuccess(Subtest subtest);
        void onError();
    }

    private final Context context;
    private final int subtestIdx;
    private String testName;

    private DatabaseSelectTask descriptionSelectTask;
    private DatabaseSelectTask questionsSelectTask;
    private SubtestCreateListener createListener;

    private DescriptionEntry descriptionEntry;
    private ArrayList<QuestionEntry> questionEntries;

    public SubtestManager(@NonNull final Context context, @NonNull int subtestIdx) {
        this.context = context;
        this.subtestIdx = subtestIdx;

    }

    public void setSubtestCreateListener(SubtestCreateListener listener) {
        this.createListener = listener;
    }

    public void startCreate() {
        this.descriptionSelectTask = getDescriptionSelectTask(context);
        descriptionSelectTask.execute(getDescriptionSelectQuery(subtestIdx));
    }

    public void onDestroy() {
        if (descriptionSelectTask != null)
            descriptionSelectTask.cancel(true);

        if (questionsSelectTask != null)
            questionsSelectTask.cancel(true);
    }

    private void tryCreateSubtest() {
        if (!isFinish()) return;
    }

    private boolean isFinish() {
        return descriptionSelectTask.isCancelled();
    }

    private DatabaseSelectTask getDescriptionSelectTask(final Context context) {
        return new DatabaseSelectTask(context, new TaskListener<SelectResponse>() {
            @Override
            public void onSuccess(SelectResponse result) {
                ArrayList<DescriptionEntry> descriptions = result.getAll();
                if (descriptions.isEmpty()) {
                    Log.w("[SELECT DESCRIPTION]", "Select description return empty row!");
                    return;
                }

                SubtestManager.this.descriptionEntry = descriptions.get(0);
                SubtestManager.this.tryCreateSubtest();
            }

            @Override
            public void onError() {
                Log.e("[SELECT DESCRIPTION]", "Something went wrong. Cant get description. Interrupt!");
                SubtestManager.this.onDestroy();
                createListener.onError();
            }
        }, new DescriptionSelectResponseFactory());
    }

    private SimpleSelectQuery getDescriptionSelectQuery(final int subtestIdx) {
        SimpleSelectQuery selectQuery = new SimpleSelectQuery(DescriptionEntry.DescriptionSchema.TABLE_NAME);
        selectQuery.setWhereCondition(new WhereCondition<String>() {
            @Override
            public String getWhereSQL() {
                return String.format(
                        "%s = %d",
                        DescriptionEntry.DescriptionSchema.COLUMN_NAME_SUBTEST, subtestIdx);
            }
        });

        return selectQuery;
    }
}
