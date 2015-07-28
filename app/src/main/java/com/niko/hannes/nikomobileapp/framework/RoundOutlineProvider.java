package com.niko.hannes.nikomobileapp.framework;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/**
 * Created by Gebruiker on 28/07/2015.
 */
public class RoundOutlineProvider extends ViewOutlineProvider {

    private final int mSize;

    public RoundOutlineProvider(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("size needs to be > 0. Actually was " + size);
        }
        mSize = size;
    }

    @Override
    public final void getOutline(View view, Outline outline) {
        outline.setOval(0, 0, mSize, mSize);
    }

}
