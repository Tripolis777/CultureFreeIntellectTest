package com.android.tripolis.culturefreeintellecttest.Realm;

import com.android.tripolis.culturefreeintellecttest.Core.Description;

import io.realm.annotations.RealmModule;

/**
 * Created by tripo on 11/14/2017.
 */

@RealmModule(classes = {
        AnswerEntry.class,
        DescriptionEntry.class,
        ImageAssetEntry.class,
        QuestionEntry.class,
        TestEntry.class
})
public class CFITModule {
}
