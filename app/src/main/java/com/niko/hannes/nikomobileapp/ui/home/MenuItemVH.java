package com.niko.hannes.nikomobileapp.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.niko.hannes.nikomobileapp.R;
import com.niko.hannes.nikomobileapp.framework.IListItemClickListener;
import com.niko.hannes.nikomobileapp.framework.Logger;
import com.niko.hannes.nikomobileapp.widget.AvatarView;

/**
 * Created by Hannes on 28/07/2015.
 */

public class MenuItemVH extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final Logger mLogger;
    public TextView title;
    public TextView description;
    public AvatarView avatar;
    private IListItemClickListener mItemClickListener;

    public MenuItemVH(View view, IListItemClickListener itemClickListener) {
        super(view);

        mLogger = new Logger(MenuItemVH.class.getSimpleName());
        mLogger.Debug("Created");

        mItemClickListener = itemClickListener;
        view.setOnClickListener(this);

        title = (TextView) view.findViewById(R.id.home_menu_item_title);
        description = (TextView) view.findViewById(R.id.home_menu_item_description);
        avatar = (AvatarView) view.findViewById(R.id.home_menu_item_avatar);
    }

    @Override
    public void onClick(View view) {

        mLogger.Debug("clicked, position: "+ getAdapterPosition());

        if(mItemClickListener != null)
            mItemClickListener.onListItemClick(view, getAdapterPosition());
    }
}
