package com.android.tripolis.culturefreeintellecttest.Core.Tools;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.HashMap;

/**
 * Created by tripo on 11/4/2017.
 */

public class ImageCutter {

    private Bitmap sourceImage;
    private int rowsCnt;
    private int columnCnt;

    private int sourceWidth;
    private int sourceHeight;
    private int pieceWidth;
    private int pieceHeight;

    private HashMap<Integer, Bitmap[]> packs;

    public ImageCutter(@NonNull Bitmap sourceImage, int rowsCnt, int columnsCnt) {
        this.sourceImage = sourceImage;
        this.rowsCnt = rowsCnt;
        this.columnCnt = columnsCnt;

        sourceWidth = sourceImage.getWidth();
        sourceHeight = sourceImage.getHeight();
        pieceWidth = sourceWidth / columnsCnt;
        pieceHeight = sourceHeight / rowsCnt;

        packs = new HashMap<>();
    }

     @Nullable
     public Bitmap[] getPack(int packSize, int packCnt) {
         if (packs.containsKey(packCnt)) {
             Bitmap[] imgs = packs.get(packCnt);
             if (imgs.length == packSize)
                 return imgs;
         }

         int endIdx = packCnt * packSize;
         int startIdx = endIdx - packSize;

         if (rowsCnt * columnCnt < endIdx) {
             return null; // TODO: create own exception
         }

         int startRow = startIdx / columnCnt;
         int startColumn = startIdx % columnCnt;

         Bitmap[] imgs = new Bitmap[packSize];
         for (int i = 0; i < packSize; i++) {
             imgs[i] = Bitmap.createBitmap(sourceImage, startColumn * pieceWidth, startRow * pieceHeight, pieceWidth, pieceHeight);
             startColumn++;

             if (startColumn % columnCnt == 0) {
                 startRow++;
                 startColumn = 0;
             }
         }

         packs.put(packCnt, imgs);

         return imgs;
     }

}
