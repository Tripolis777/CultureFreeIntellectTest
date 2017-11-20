package com.android.tripolis.culturefreeintellecttest.Core.DescriptionExample;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntry;
import com.android.tripolis.culturefreeintellecttest.Realm.Description.ExampleEntryImage;

/**
 * Created by v.karyagin on 20.11.2017.
 */

public class ExampleImage extends SimpleExample {

    protected String imageName;
    protected String imageInfo;
    protected Drawable image;

    public ExampleImage(ExampleEntryImage entry, final Context context) {
        super(entry, context);

        final Resources res = context.getResources();
        final String packageName = context.getPackageName();

        this.imageName = res.getString(res.getIdentifier(entry.textImageNameKey, "string", packageName));
        this.imageInfo = res.getString(res.getIdentifier(entry.textImageInfoKey, "string", packageName));
        this.image = res.getDrawable(res.getIdentifier(entry.imageKey, "drawable", packageName));
    }

    public Drawable getImage() {
        return image;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImageInfo() {
        return imageInfo;
    }
}
