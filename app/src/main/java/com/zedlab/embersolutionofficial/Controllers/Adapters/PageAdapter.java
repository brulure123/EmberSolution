package com.zedlab.embersolutionofficial.Controllers.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zedlab.embersolutionofficial.Controllers.Fragments.HomeFragment;
import com.zedlab.embersolutionofficial.Controllers.Fragments.OrderFragment;
import com.zedlab.embersolutionofficial.Controllers.Fragments.OthersFragment;

public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(FragmentManager fragmentManager){
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return HomeFragment.newInstance();
            case 1:
                return OrderFragment.newInstance();
            default:
                return OthersFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return (3);
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Dashboard";
            case 1:
                return "Commandes";
            case 2:
                return "Paramètres";
            default:
                return null;
        }
    }
}
