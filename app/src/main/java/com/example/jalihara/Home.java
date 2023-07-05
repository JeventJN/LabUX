package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private ViewPager2 viewPager;
    private List<Integer> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        ImageView hand = findViewById(R.id.hand);
        LinearLayout welcome = findViewById(R.id.welcome);
        ValueAnimator rotationAnimator = ValueAnimator.ofFloat(0f, -30f, 0f);
        rotationAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotationAnimator.setDuration(1000); // Adjust the duration as needed

        rotationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float rotation = (float) animation.getAnimatedValue();
                hand.setRotation(rotation);
            }
        });

        rotationAnimator.start();

        hand.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        v.setBackgroundResource(R.drawable.homewavehover);
                        v.setScaleX(0.9f);
                        v.setScaleY(0.9f);
                        if (welcome.getVisibility() == View.VISIBLE) {
                            Animation slideRight = new TranslateAnimation(0, -welcome.getWidth(), 0, 0);
                            slideRight.setDuration(500);
                            welcome.startAnimation(slideRight);
                            welcome.setVisibility(View.INVISIBLE);
                        } else {
                            Animation slideLeft = new TranslateAnimation(-welcome.getWidth(), 0, 0, 0);
                            slideLeft.setDuration(500);
                            welcome.startAnimation(slideLeft);
                            welcome.setVisibility(View.VISIBLE);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        v.setBackgroundResource(0);
                        v.setScaleX(1.0f);
                        v.setScaleY(1.0f);
                        break;
                }
                return true; // Return true to indicate that the event is handled
            }
        });

//        Versi manual pakai viewpager
        viewPager = findViewById(R.id.viewPager);

        imageList = new ArrayList<>();
        imageList.add(R.drawable.ramayana);
        imageList.add(R.drawable.romeojuliet);
        imageList.add(R.drawable.hamlet);

        CarouselAdapter imageAdapter = new CarouselAdapter(imageList);
        viewPager.setAdapter(imageAdapter);
        viewPager.setCurrentItem(0, false);

//        Versi pakai github
        ImageSlider carousel = findViewById(R.id.carousel);
        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.banner1));
        slideModels.add(new SlideModel(R.drawable.banner2));
        slideModels.add(new SlideModel(R.drawable.banner3));
        carousel.setImageList(slideModels, true);

//        carousel.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onItemSelected(int position) {
//                // Handle click event for the selected item in slideModels
//                Intent intent = new Intent(Home.this, ViewTicket.class);
//                startActivity(intent);
//            }
//        });
//        carousel.setImageList(slideModels, true);

        LinearLayout navbar = findViewById(R.id.navbar);
        LinearLayout navbarsub = findViewById(R.id.navbarsub);
        LinearLayout homecontent = findViewById(R.id.homecontent);
        LinearLayout headerbar = findViewById(R.id.headerbar);
        navbar.setVisibility(View.GONE);
        navbarsub.setVisibility(View.GONE);

        ImageView imagemenu = findViewById(R.id.imagemenu);
        imagemenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (navbar.getVisibility() == View.VISIBLE) {
                    navbar.setVisibility(View.GONE);
                    navbarsub.setVisibility(View.GONE);
                    homecontent.setAlpha(1f);
                    headerbar.setAlpha(1f);
                } else {
                    navbar.setVisibility(View.VISIBLE);
                    homecontent.setAlpha(0.1f);
                    headerbar.setAlpha(0.1f);
                }
            }
        });
        homecontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (navbar.getVisibility() == View.VISIBLE) {
                    navbar.setVisibility(View.GONE);
                    navbarsub.setVisibility(View.GONE);
                    homecontent.setAlpha(1f);
                    headerbar.setAlpha(1f);
                }
            }
        });
        headerbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (navbar.getVisibility() == View.VISIBLE) {
                    navbar.setVisibility(View.GONE);
                    navbarsub.setVisibility(View.GONE);
                    homecontent.setAlpha(1f);
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
                    // Handle Home click
                    // Perform the desired action or navigate to the Home screen/activity
                    return true;
                } else if (itemId == R.id.aboutus) {
                    if (navbarsub.getVisibility() == View.VISIBLE) {
                        navbarsub.setVisibility(View.GONE);
                    } else {
                        navbarsub.setVisibility(View.VISIBLE);
                    }
                    return true;
                } else if (itemId == R.id.aboutus1) {
                    // Handle About Us 1 click
                    // Perform the desired action or navigate to the About Us 1 screen/activity
                    return true;
                } else if (itemId == R.id.aboutus2) {
                    // Handle About Us 2 click
                    // Perform the desired action or navigate to the About Us 2 screen/activity
                    return true;
                } else if (itemId == R.id.ticket) {
                    // Handle View Tickets click
                    // Start the ViewTicketsActivity to display the viewticket.xml layout
                    Intent intent = new Intent(Home.this, ViewTicket.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.logout) {
                    // Handle Logout click
                    // Perform the desired action or navigate to the Logout screen/activity
                    return true;
                }

                return false;
            }
        });
    }
}