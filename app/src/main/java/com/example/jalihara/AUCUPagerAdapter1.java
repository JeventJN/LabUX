package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AUCUPagerAdapter1 extends FragmentStateAdapter {

    public AUCUPagerAdapter1(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new ContactUsFragment();
            default:
                return new AboutUsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
