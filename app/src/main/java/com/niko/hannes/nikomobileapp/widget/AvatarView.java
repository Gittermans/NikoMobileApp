package com.niko.hannes.nikomobileapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;

import com.niko.hannes.nikomobileapp.framework.RoundOutlineProvider;

/**
 * Created by Gebruiker on 28/07/2015.
 */
public class AvatarView extends ImageView  {

    public AvatarView(Context context) {
        this(context, null);
    }

    public AvatarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AvatarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setClipToOutline(true);
    }



    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w > 0 && h > 0) {
            setOutlineProvider(new RoundOutlineProvider(Math.min(w, h)));
        }
    }

}

