package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AUCUPagerAdapter extends FragmentStateAdapter {

    public AUCUPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new AboutUsFragment();
            default:
                return new ContactUsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
