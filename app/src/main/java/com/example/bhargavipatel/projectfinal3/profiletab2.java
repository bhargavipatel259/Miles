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

public class profiletab2 extends Fragment {

    FragmentManager fm;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_profiletab2, container, false);

        TabLayout tabLayout = (TabLayout) inflatedView.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("PERSONAL"));
        tabLayout.addTab(tabLayout.newTab().setText("CARS"));
        fm=getActivity().getSupportFragmentManager();

        final ViewPager viewPager = (ViewPager) inflatedView.findViewById(R.id.viewpager);

        //tabLayout.setupWithViewPager(viewPager);
        //tabLayout.getTabAt(0).setText("PERSONAL");
        //tabLayout.getTabAt(1).setText("CARS");
        viewPager.setAdapter(new PagerAdapter
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
                    profile tab1 = new profile();
                    return tab1;
                case 1:
                    profileCarfragFragment tab2 = new profileCarfragFragment();
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
    public void onBackPressed() {
        fm.beginTransaction().replace(R.id.mycont,new Search()).commit();
    }



}