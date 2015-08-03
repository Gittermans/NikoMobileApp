package com.niko.hannes.nikomobileapp.ui.home.edit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.niko.hannes.nikomobileapp.R;
import com.niko.hannes.nikomobileapp.model.Avatar;
import com.niko.hannes.nikomobileapp.ui.home.MenuItemVM;
import com.niko.hannes.nikomobileapp.widget.AvatarView;

import java.util.List;

/**
 * Created by Gebruiker on 3/08/2015.
 */
public class AvatarAdapter extends BaseAdapter{

    private List<MenuItemVM> mList;
    LayoutInflater mLayoutInflater;

    public AvatarAdapter(Context context, List<MenuItemVM> list) {
        mLayoutInflater = LayoutInflater.from(context);
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
            convertView = mLayoutInflater.inflate(R.layout.home_edit_avatar_grid_item,parent, false);

        Avatar tobind = mList.get(position).avatar;

        AvatarView av = (AvatarView) convertView.findViewById(R.id.avatar);
        av.setImageResource(tobind.getDrawableId());
        return convertView;
    }
}
