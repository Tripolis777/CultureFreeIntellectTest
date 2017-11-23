package com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample;

import android.content.Context;
import android.content.res.Resources;

import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.DescriptionEntry;

/**
 * Created by v.karyagin on 20.11.2017.
 */

public class SimpleExample  implements Example {
    protected DescriptionEntry.DescriptionType type;
    protected String title;

    public SimpleExample(ExampleEntry entry, final Context context) {
        final Resources res = context.getResources();
        final String packageName = context.getPackageName();

        this.type = entry.getType();
        int res_id = res.getIdentifier(entry.textTitleKey, "string", packageName);
        this.title = res.getString(res_id);
    }

    @Override
    public DescriptionEntry.DescriptionType getType() {
        return type;
    }

    @Override
    public String getTitle() {
        return title;
    }

}
