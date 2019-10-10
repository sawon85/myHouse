package com.example.myhouse.House;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {


    private int tabCount;

    public TabPagerAdapter(FragmentManager fragmentManager, int tabCount)
    {
        super(fragmentManager);
        this.tabCount = tabCount;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                ClassDetailIntroduction classDetailIntroduction = new ClassDetailIntroduction();
              /*  Bundle bundle = new Bundle();
                bundle.putString("desc",);
                classDetailIntroduction.setArguments(bundle);*/
                return classDetailIntroduction;
            case 1:
                ClassDetailReview classDetailReview = new ClassDetailReview();
                return classDetailReview;

                default :
                    return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
