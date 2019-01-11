package com.example.bhargavipatel.projectfinal3;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bhargavipatel on 4/7/17.
 */

    public class bookedtab extends Fragment {


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View inflatedView = inflater.inflate(R.layout.fragment_bookedtab, container, false);

            TabLayout tabLayout = (TabLayout) inflatedView.findViewById(R.id.tabLayout);
            tabLayout.addTab(tabLayout.newTab().setText("PETROL"));
            tabLayout.addTab(tabLayout.newTab().setText("DIESEL"));

            final ViewPager viewPager = (ViewPager) inflatedView.findViewById(R.id.viewpager);

            //tabLayout.setupWithViewPager(viewPager);
            //tabLayout.getTabAt(0).setText("PERSONAL");
            //tabLayout.getTabAt(1).setText("CARS");
            viewPager.setAdapter(new com.example.bhargavipatel.projectfinal3.bookedtab.PagerAdapter
                    (getFragmentManager(), tabLayout.getTabCount()));
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

            return inflatedView;
        }

        public class PagerAdapter extends FragmentStatePagerAdapter {
            int mNumOfTabs;

            public PagerAdapter(FragmentManager fm, int NumOfTabs) {
                super(fm);
                this.mNumOfTabs = NumOfTabs;
            }

            @Override
            public Fragment getItem(int position) {

                switch (position) {
                    case 0:
                        sirdemopetrolFragment tab1 = new sirdemopetrolFragment();
                        return tab1;
                    case 1:
                        sirdemoFragment tab2 = new sirdemoFragment();
                        return tab2;
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return mNumOfTabs;
            }
        }
    }
