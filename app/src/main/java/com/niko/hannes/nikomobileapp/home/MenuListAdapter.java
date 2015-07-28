package com.niko.hannes.nikomobileapp.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.niko.hannes.nikomobileapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannes on 28/07/2015.
 */
public class MenuListAdapter extends RecyclerView.Adapter<MenuItemVH> {

    List<MenuItemVM> vms;

    public MenuListAdapter(List<MenuItemVM> vms) {

        if(vms == null) throw new IllegalArgumentException("vms can not be null");

        this.vms = vms;
    }

    @Override
    public MenuItemVH onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_menu_item, viewGroup, false);

        return new MenuItemVH(view);
    }

    @Override
    public void onBindViewHolder(MenuItemVH menuItemVH, int i) {

        MenuItemVM vmToBind =  vms.get(i);

        menuItemVH.title.setText(vmToBind.title);
        menuItemVH.description.setText(vmToBind.description);

    }

    @Override
    public int getItemCount() {
        return vms.size();
    }
}
