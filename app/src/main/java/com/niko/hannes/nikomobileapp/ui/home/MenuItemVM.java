package com.niko.hannes.nikomobileapp.ui.home;

import com.niko.hannes.nikomobileapp.model.Avatar;

import java.util.UUID;

/**
 * Created by Hannes on 28/07/2015.
 */
public class MenuItemVM {

    public String title;
    public String description;
    public Avatar avatar;
    public UUID id;

    public MenuItemVM(String title, String description, Avatar avatar) {
        this.id = java.util.UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.avatar = avatar;
    }
}
