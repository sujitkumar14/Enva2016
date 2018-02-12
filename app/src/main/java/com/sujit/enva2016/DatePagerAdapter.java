package com.sujit.enva2016;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by Rajkumar on 01-19-2016.
 */
public class DatePagerAdapter extends FragmentPagerAdapter{


    public DatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:return new DayTwo();
            case 1:return new DayThree();
            case 2:return new DayFour();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position)
        {
            case 1:return "3 Feb 2016";
            case 2:return "4 Feb 2016";
            case 0:return "Online Event";
        }

        return null;
    }
}
