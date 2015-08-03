package com.niko.hannes.nikomobileapp.dataService;

import com.niko.hannes.nikomobileapp.model.Avatar;
import com.niko.hannes.nikomobileapp.ui.home.MenuItemVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gebruiker on 3/08/2015.
 */
public class AvatarDataService {

    private static AvatarDataService mAvatarDataService;
    private List<MenuItemVM> mAvatars;
    public static AvatarDataService getInstance(){

        if(mAvatarDataService == null)
            mAvatarDataService = new AvatarDataService();
        return mAvatarDataService;
    }

    private AvatarDataService() {
        mAvatars = new ArrayList<MenuItemVM>();
        mAvatars.add(new MenuItemVM("Hannes", "Senior software developer", Avatar.ONE));
        mAvatars.add(new MenuItemVM("Kenneth", "Senior software developer", Avatar.TWO));
        mAvatars.add(new MenuItemVM("Bjorn", "Senior software developer", Avatar.THREE));
        mAvatars.add(new MenuItemVM("Peter", "Senior software developer", Avatar.FOUR));
        mAvatars.add(new MenuItemVM("Tony", "Software tester", Avatar.FIVE));
        mAvatars.add(new MenuItemVM("Erik", "Software manager", Avatar.SIX));
        mAvatars.add(new MenuItemVM("Koen", "SoftwareMaster Architect", Avatar.SEVEN));
        mAvatars.add(new MenuItemVM("Christope", "Mobile Architect", Avatar.EIGHT));
        mAvatars.add(new MenuItemVM("Joris", "Hardware Architect", Avatar.NINE));
        mAvatars.add(new MenuItemVM("Luc", "Lead Designer", Avatar.TEN));
        mAvatars.add(new MenuItemVM("Johan", "Customer support engineer", Avatar.ELEVEN));
        mAvatars.add(new MenuItemVM("Niels", "Customer support engineer", Avatar.TWELVE));
        mAvatars.add(new MenuItemVM("Blowser", "A chinese browser", Avatar.THIRTEEN));
        mAvatars.add(new MenuItemVM("Toad", "Just a nice guy", Avatar.FOURTEEN));
        mAvatars.add(new MenuItemVM("Wim", "Integration test expert", Avatar.FIFTEEN));
        mAvatars.add(new MenuItemVM("Mario", "Super high jumper", Avatar.TWELVE));
    }

    public List<MenuItemVM> get(){
        return mAvatars;
    }

    public void save(MenuItemVM avatar){
        MenuItemVM found = null;

        for(int i=0;i<mAvatars.size();i++){
            if(mAvatars.get(i).id == avatar.id){
                mAvatars.set(i, avatar); /*update*/
              return;
            }
        }
        mAvatars.add(avatar); /*add*/
        return;
    }






}
