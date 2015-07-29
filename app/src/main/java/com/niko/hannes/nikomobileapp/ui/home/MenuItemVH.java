package com.niko.hannes.nikomobileapp.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.niko.hannes.nikomobileapp.R;
import com.niko.hannes.nikomobileapp.widget.AvatarView;

/**
 * Created by Hannes on 28/07/2015.
 */

public class MenuItemVH extends RecyclerView.ViewHolder{
    public TextView title;
    public TextView description;
    public AvatarView avatar;

    public MenuItemVH(View view) {
        super(view);

        title = (TextView) view.findViewById(R.id.home_menu_item_title);
        description = (TextView) view.findViewById(R.id.home_menu_item_description);
        avatar = (AvatarView) view.findViewById(R.id.home_menu_item_avatar);
    }
}
