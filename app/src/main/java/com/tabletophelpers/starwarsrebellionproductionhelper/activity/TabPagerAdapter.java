package com.tabletophelpers.starwarsrebellionproductionhelper.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.tabletophelpers.starwarsrebellionproductionhelper.domain.GameSession;

/**
 * Created by tblackwe on 7/5/16.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"Systems", "Production"};
    private Context context;
    GameSession gameSession = new GameSession();
    private ProductionFragment productionFragment;
    private PlanetarySystemFragment planetarySystemFragment;

    public TabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 1:
                productionFragment = ProductionFragment.newInstance(gameSession);
                return productionFragment;
            case 0:
            default:
                planetarySystemFragment = PlanetarySystemFragment.newInstance(gameSession);
                return planetarySystemFragment;

        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

    @Override
    public void startUpdate(ViewGroup container) {
        super.startUpdate(container);
        if (null != productionFragment) {
            productionFragment.update();
        }

//        if (null != planetarySystemFragment) {
//            planetarySystemFragment.update();
//        }

    }
}
