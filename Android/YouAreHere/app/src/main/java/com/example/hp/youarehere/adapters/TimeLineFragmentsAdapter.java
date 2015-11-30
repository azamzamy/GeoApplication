package com.example.hp.youarehere.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.hp.youarehere.fragments.LocationBasedFragment;

/**
 * Created by ahmedtarek on 11/29/15.
 */
public class TimeLineFragmentsAdapter extends FragmentStatePagerAdapter {

    int count;
    private String tabTitles[] = new String[] {"Home", "Friends"};

    public TimeLineFragmentsAdapter(android.support.v4.app.FragmentManager fm, int count, Context context) {
        super(fm);
        this.count = count;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return count;
    }

    @Override
    public Fragment getItem(int arg0) {

        //return new PlanDetailsPageFragment(data.get(arg0).getFirst(),data.get(arg0).getSecond(),arg0, app, arg0, planPager);
        return new LocationBasedFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
