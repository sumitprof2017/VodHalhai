package com.sumit.vodhalhai.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sumit.vodhalhai.Fragments.Gallery;
import com.sumit.vodhalhai.Fragments.ProfileFragment;

/**
 * Created by MR.Cutevil on 11/30/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int numberOfTab;

    public ViewPagerAdapter(FragmentManager fm, int numberOfTab) {
        super(fm);
        this.numberOfTab = numberOfTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                MainFragment mainFragment=new MainFragment();
                return mainFragment;
            case 1:
                ProfileFragment profileFragment=new ProfileFragment();
                return  profileFragment;
            case 2:
                Gallery galleryfragment=new Gallery();
                return galleryfragment;
            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
