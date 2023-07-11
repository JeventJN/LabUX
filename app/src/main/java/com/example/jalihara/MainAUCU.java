package com.example.jalihara;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainAUCU extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_aucu);

        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new AUCUPagerAdapter(this));

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position) {
                    case 0: {
                        tab.setIcon(R.drawable.aboutemptyhitam);
                        break;
                    }
                    default: {
                        tab.setIcon(R.drawable.contactemptyhitam);
                        break;
                    }
                }
            }
        }
        );
        tabLayoutMediator.attach();
    }
}