package com.android.tripolis.culturefreeintellecttest.Core;

import android.content.Context;
import android.support.annotation.NonNull;

import com.android.tripolis.culturefreeintellecttest.Realm.SubtestEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.TestEntry;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by v.karyagin on 10.11.2017.
 */

public class SubtestManager {

    public static interface SubtestCreateListener {
        void onSuccess(Subtest subtest);
        void onError();
    }

    private final Context context;
    private String subtestIdent;

    private TestEntry testEntry;
    private ArrayList<Subtest> subtestList;

    public SubtestManager(@NonNull final Context context, @NonNull TestEntry testEntry) {
        this.testEntry = testEntry;
        this.context = context;

        init();
    }

    public SubtestManager(@NonNull final Context context, @NonNull String subtestIdent) {
        final Realm realm = Realm.getDefaultInstance();
        TestEntry testEntry = realm.where(TestEntry.class)
                .equalTo("name", subtestIdent)
                .findFirst();

        this.context = context;
        this.testEntry = testEntry;

        init();
    }

    public Subtest getSubtest(int index) {
        return subtestList.get(index);
    }

    public void onDestroy() {

    }

    private void init() {
        this.subtestList = new ArrayList<>();
        for (SubtestEntry entry : testEntry.getSubtestList()) {
            subtestList.add(new Subtest(context, entry));
        }
    }

}
