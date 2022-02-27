package es.rgmf.misnotas.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import es.rgmf.misnotas.R;
import es.rgmf.misnotas.ui.fragments.AdditionFragment;
import es.rgmf.misnotas.ui.fragments.AverageFragment;
import es.rgmf.misnotas.ui.fragments.GradesFragment;
import es.rgmf.misnotas.ui.fragments.MaxMinFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{
            R.string.tab_grades,
            R.string.tab_add,
            R.string.tab_avg,
            R.string.tab_max_min
    };
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1: return new AdditionFragment();
            case 2: return new AverageFragment();
            case 3: return new MaxMinFragment();
            default: return new GradesFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}