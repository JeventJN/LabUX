package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainAUCU extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        String flag = getIntent().getStringExtra("flag");
        String aboutus = "aboutus";
        String contactus = "contactus";
        setContentView(R.layout.activity_main_aucu);
        TextView pagetitle = findViewById(R.id.pagetitle);
        pagetitle.setText("About Us");

        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        if(aboutus.equals(flag)){
            viewPager2.setAdapter(new AUCUPagerAdapter(this));
        }

        if(contactus.equals(flag)){
            viewPager2.setAdapter(new AUCUPagerAdapter1(this));
        }

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(aboutus.equals(flag)){
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
                if(contactus.equals(flag)){
                    ConstraintLayout aboutusheader = findViewById(R.id.aboutusheader);
                    ConstraintLayout directiontab = findViewById(R.id.direction);
                    directiontab.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                    aboutusheader.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

                    switch (position) {
                        case 0: {
                            tab.setIcon(R.drawable.contactemptyhitam);
                            break;
                        }
                        default: {
                            tab.setIcon(R.drawable.aboutemptyhitam);
                            break;
                        }
                    }
                }
            }
        });
        tabLayoutMediator.attach();
        LinearLayout navbar = findViewById(R.id.navbar);
        LinearLayout navbarsub = findViewById(R.id.navbarsub);
        LinearLayout headerbar = findViewById(R.id.headerbar);
        ViewPager2 aboutuscontent = findViewById(R.id.viewPager);
        navbar.setVisibility(View.GONE);
        navbarsub.setVisibility(View.GONE);

        FrameLayout closenavigation = findViewById(R.id.closenavigation);
        ImageView imagemenu = findViewById(R.id.imagemenu);
        closenavigation.setVisibility(View.GONE);

        imagemenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (closenavigation.getVisibility() == View.VISIBLE) {
                    closenavigation.setVisibility(View.GONE);
                    navbar.setVisibility(View.GONE);
                    navbarsub.setVisibility(View.GONE);
                    aboutuscontent.setAlpha(1f);
                    headerbar.setAlpha(1f);
                } else {
                    navbar.setVisibility(View.VISIBLE);
                    closenavigation.setVisibility(View.VISIBLE);
                    aboutuscontent.setAlpha(0.1f);
                    headerbar.setAlpha(0.1f);
                }
            }
        });

        closenavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (closenavigation.getVisibility() == View.VISIBLE) {
                    closenavigation.setVisibility(View.GONE);
                    navbar.setVisibility(View.GONE);
                    navbarsub.setVisibility(View.GONE);
                    aboutuscontent.setAlpha(1f);
                    headerbar.setAlpha(1f);
                }
            }
        });

        headerbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (closenavigation.getVisibility() == View.VISIBLE) {
                    closenavigation.setVisibility(View.GONE);
                    navbar.setVisibility(View.GONE);
                    navbarsub.setVisibility(View.GONE);
                    aboutuscontent.setAlpha(1f);
                    headerbar.setAlpha(1f);
                }
//                ticketcontent.performClick(); ini kehitung klik 2x, klik headerbar terus klik ticketcontent
            }
        });

        NavigationView navigationShow = findViewById(R.id.navigationShow);
        navigationShow.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    Intent intent = new Intent(MainAUCU.this, Home.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.aboutus) {
                    if (navbarsub.getVisibility() == View.VISIBLE) {
                        navbarsub.setVisibility(View.GONE);
                    } else {
                        navbarsub.setVisibility(View.VISIBLE);
                    }
                    return true;
                } else if (itemId == R.id.ticket) {
                    Intent intent = new Intent(MainAUCU.this, ViewTicket.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.logout) {
                    Intent intent = new Intent(MainAUCU.this, Login.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });

        NavigationView navigationsubshow = findViewById(R.id.navigationsubshow);
        navigationsubshow.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.aboutus1) {
                    Intent intent = new Intent(MainAUCU.this, MainAUCU.class);
                    intent.putExtra("flag", "aboutus");
                    startActivity(intent);
                    return true;
                }
                else if (itemId == R.id.aboutus2) {
                    Intent intent = new Intent(MainAUCU.this, MainAUCU.class);
                    intent.putExtra("flag", "contactus");
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }

}