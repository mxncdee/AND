package com.univaq.mwt.headlines.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.univaq.mwt.headlines.R;

import java.util.ArrayList;
import java.util.List;

import static com.univaq.mwt.headlines.NewsyApplication.getAppContext;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<String> fragmentTitleList = new ArrayList<>();
    private final List<Fragment> fragmentList = new ArrayList<>();

    ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    @NonNull
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (fragmentTitleList.get(position).equals(getAppContext().getString(R.string.category_general)))
            return getAppContext().getString(R.string.title_headlines);
        return fragmentTitleList.get(position);
    }

    void addFragment(Fragment fragment, String title) {
        this.fragmentList.add(fragment);
        this.fragmentTitleList.add(title);
    }
}
