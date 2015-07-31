package com.niko.hannes.nikomobileapp.ui.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.niko.hannes.nikomobileapp.R;
import com.niko.hannes.nikomobileapp.framework.IListItemClickListener;
import com.niko.hannes.nikomobileapp.model.Avatar;

import java.util.List;

/**
 * Created by Hannes on 28/07/2015.
 */
public class MenuListAdapter extends RecyclerView.Adapter<MenuItemVH> {

    List<MenuItemVM> mVms;
    private Context mContext;
    private IListItemClickListener mItemClickListener;

    public MenuListAdapter(Context context, List<MenuItemVM> vms) {

        if(vms == null) throw new IllegalArgumentException("vms can not be null");
        if(context == null) throw new IllegalArgumentException("context can not be null");

        mContext = context;
        mVms = vms;
    }

    @Override
    public MenuItemVH onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_1i2l, viewGroup, false);

        return new MenuItemVH(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(MenuItemVH menuItemVH, int i) {

        MenuItemVM vmToBind =  mVms.get(i);

        //vmToBind.

        menuItemVH.title.setText(vmToBind.title);
        menuItemVH.description.setText(vmToBind.description);
        menuItemVH.avatar.setImageDrawable(mContext.getDrawable(vmToBind.avatar.getDrawableId()));
    }

    @Override
    public int getItemCount() {
        return mVms.size();
    }

    public void setOnItemClickListener(final IListItemClickListener listener) {

        if(listener == null) throw new IllegalArgumentException("listener can not be null.");

        this.mItemClickListener = listener;
    }
}
