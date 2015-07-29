package com.niko.hannes.nikomobileapp.ui.home;

import com.niko.hannes.nikomobileapp.model.Avatar;

/**
 * Created by Hannes on 28/07/2015.
 */
public class MenuItemVM {

    public String title;
    public String description;
    public Avatar avatar;

    public MenuItemVM(String title, String description, Avatar avatar) {
        this.title = title;
        this.description = description;
        this.avatar = avatar;
    }
}
