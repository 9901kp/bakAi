package com.example.project_app_android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.android.material.tabs.TabLayout;

public class Home_Fragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ImageView blurredBackground;

    public Home_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_, container, false);

        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
        blurredBackground = view.findViewById(R.id.blurredBackground);

        // Create a blurred background
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.me); // Replace with your image resource
        Bitmap blurredBitmap = BlurBuilder.blur(getContext(), originalBitmap);
        blurredBackground.setImageBitmap(blurredBitmap);

        viewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private static class MyPagerAdapter extends FragmentPagerAdapter {
        MyPagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CardFragment();
                case 1:
                    return new AccountsFragment();
                case 2:
                    return new DepositsFragment();
                case 3:
                    return new LoansFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Cards";
                case 1:
                    return "Accounts";
                case 2:
                    return "Deposits";
                case 3:
                    return "Loans";
                default:
                    return null;
            }
        }
    }
}
