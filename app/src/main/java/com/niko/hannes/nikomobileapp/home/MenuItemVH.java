package com.niko.hannes.nikomobileapp.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.niko.hannes.nikomobileapp.R;

/**
 * Created by Hannes on 28/07/2015.
 */

public class MenuItemVH extends RecyclerView.ViewHolder{
    public TextView title;
    public TextView description;

    public MenuItemVH(View view) {
        super(view);

        title = view.findViewById(R.id.);


    }

    public MenuItemVH(TextView title, TextView description) {
        this.title = title;
        this.description = description;
    }
}
