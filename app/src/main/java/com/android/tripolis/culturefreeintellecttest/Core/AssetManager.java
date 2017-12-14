package com.android.tripolis.culturefreeintellecttest.Core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tripo on 12/14/2017.
 */

public class AssetManager {

    private HashMap<String, Bitmap> assets;
    private final Context context;

    private final String packageName;
    private final Resources res;

    public AssetManager(Context context) {
        this.context = context;
        assets = new HashMap<>();

        packageName = context.getPackageName();
        res = context.getResources();
    }

    public Bitmap getAsset(String assetName) {
        return assets.containsKey(assetName) ? assets.get(assetName) : createAsset(assetName);
    }

    public Bitmap createAsset(String assetName) {
        if (assets.containsKey(assetName))
            return assets.get(assetName);

        Bitmap asset =  BitmapFactory.decodeResource(res, res.getIdentifier(assetName, "drawable", packageName));
        assets.put(assetName, asset);
        return asset;
    }

}
