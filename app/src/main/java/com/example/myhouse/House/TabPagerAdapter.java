package com.example.myhouse.House;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class TabPagerAdapter extends FragmentStatePagerAdapter {


    ArrayList<Fragment> fList;


    public TabPagerAdapter(FragmentManager fragmentManager, ArrayList<Fragment> fList)
    {
        super(fragmentManager);
        this.fList = fList;
    }


    @Override
    public Fragment getItem(int position) {
        return fList.get(position);
    }

    @Override
    public int getCount() {
        return fList.size();
    }
}
