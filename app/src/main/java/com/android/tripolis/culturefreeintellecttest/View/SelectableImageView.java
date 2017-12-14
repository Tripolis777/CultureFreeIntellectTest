package com.android.tripolis.culturefreeintellecttest.View;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.android.tripolis.culturefreeintellecttest.R;

import java.nio.channels.SelectableChannel;

/**
 * Created by v.karyagin on 12/10/17.
 */

public class SelectableImageView extends AppCompatImageView {

    public interface OnImageSelectListener {
        void onSelect(View v);
        void onUnselect(View v);
    }

    private boolean selected;
    private OnImageSelectListener selectListener;
    private @DrawableRes int selectResource;

    private boolean selectEnabled;


    public SelectableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        selectResource = 0;
        selected = false;
        selectEnabled = true;

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selectEnabled) return;

                SelectableImageView.this.setBackgroundResource(selected ? R.drawable.answer_image_border : selectResource);

                if (selectListener != null) {
                    if (selected)
                        selectListener.onUnselect(SelectableImageView.this);
                    else
                        selectListener.onSelect(SelectableImageView.this);
                }

                selected = !selected;
            }
        });
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelectResource(@DrawableRes int selectResource) {
        this.selectResource = selectResource;
    }

    public void setSelectListener(OnImageSelectListener selectListener) {
        this.selectListener = selectListener;
    }

    public void setSelectEnabled(boolean selectEnabled) {
        this.selectEnabled = selectEnabled;
    }

    public boolean isSelectEnabled() {
        return selectEnabled;
    }

}
