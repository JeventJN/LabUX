package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.jalihara.databinding.HomeBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Home extends AppCompatActivity {
    private ViewPager2 viewPager;
    private List<Integer> imageList;
    ArrayList<ListTicket> dataArrayListPopular = new ArrayList<>();
    ListTicket listTicketPopular;
    ListAdapterPopular listAdapterPopular;
    HomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeBinding binding = HomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ImageView hand = findViewById(R.id.hand);
        LinearLayout welcome = findViewById(R.id.welcome);
        ValueAnimator rotationAnimator = ValueAnimator.ofFloat(0f, -30f, 0f);
        rotationAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotationAnimator.setDuration(1000);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        TextView welcomeTextView = findViewById(R.id.welcomeuser);
        String welcomeMessage = "Welcome, " + username + "!";
        welcomeTextView.setText(welcomeMessage);

        String[] PopularNameList = {"ADWADAD", "Hamlet", "Romeo & Juliet", "The Tempest", "The Art of War"};
        String[] PopularDateList = {"21 Jun 2023", "12 Mar 2023", "05 Sep 2023", "28 Dec 2023", "17 Aug 2023"};
        Double[] PopularPriceList = {Double.valueOf("350000"),Double.valueOf("400000"),Double.valueOf("500000"),Double.valueOf("400000"),Double.valueOf("250000")};
        int[] PopularImageList = {R.drawable.ramayana, R.drawable.hamlet, R.drawable.romeojuliet, R.drawable.tempest, R.drawable.artofwar};
        for (int i = 0; i < PopularPriceList.length; i++) {
            listTicketPopular = new ListTicket(PopularNameList[i], PopularDateList[i], PopularPriceList[i], PopularImageList[i]);
            dataArrayListPopular.add(listTicketPopular);
        }
        listAdapterPopular = new ListAdapterPopular(Home.this, dataArrayListPopular);
        binding.horizontalpopularitem.setAdapter(listAdapterPopular);
        binding.horizontalpopularitem.setClickable(true);
        rotationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float rotation = (float) animation.getAnimatedValue();
                hand.setRotation(rotation);
            }
        });

        binding.horizontalpopularitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Home.this, TicketForm.class);
                intent.putExtra("passimage", PopularImageList[i]);
                intent.putExtra("passimage", PopularImageList[i]);
                intent.putExtra("passname", PopularNameList[i]);
                intent.putExtra("passprice", PopularPriceList[i]);
                startActivity(intent);
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
        imageList.add(R.drawable.banner1);
        imageList.add(R.drawable.banner2);
        imageList.add(R.drawable.banner3);

        CarouselAdapter imageAdapter = new CarouselAdapter(this, imageList);
        viewPager.setAdapter(imageAdapter);
        viewPager.setCurrentItem(0, false);

        final int NUM_PAGES = imageList.size();
        final long DELAY_MS = 3000;
        final long PERIOD_MS = 5000;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            private int currentPage = 0;

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setCurrentItem(currentPage, true);
                        currentPage++;
                        if (currentPage == NUM_PAGES) {
                            currentPage = 0;
                        }
                    }
                });
            }
        }, DELAY_MS, PERIOD_MS);
//        Versi pakai github
//        ImageSlider carousel = findViewById(R.id.carousel);
//        List<SlideModel> slideModels=new ArrayList<>();
//        slideModels.add(new SlideModel(R.drawable.banner1));
//        slideModels.add(new SlideModel(R.drawable.banner2));
//        slideModels.add(new SlideModel(R.drawable.banner3));
//        carousel.setImageList(slideModels, true);

        LinearLayout navbar = findViewById(R.id.navbar);
        LinearLayout navbarsub = findViewById(R.id.navbarsub);
        LinearLayout homebanner = findViewById(R.id.homebanner);
        ScrollView homecontent = findViewById(R.id.homecontent);
        ListView horizontalpopularitem = findViewById(R.id.horizontalpopularitem);
        LinearLayout headerbar = findViewById(R.id.headerbar);
        navbar.setVisibility(View.GONE);
        navbarsub.setVisibility(View.GONE);

        horizontalpopularitem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Disable scrolling of the ScrollView when the cursor enters the ListView
                        homecontent.requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // Re-enable scrolling of the ScrollView when the cursor leaves the ListView
                        homecontent.requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });
        homebanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, ViewTicket.class);
                startActivity(intent);
            }
        });
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
                    Intent intent = new Intent(Home.this, Home.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.aboutus) {
                    if (navbarsub.getVisibility() == View.VISIBLE) {
                        navbarsub.setVisibility(View.GONE);
                    } else {
                        navbarsub.setVisibility(View.VISIBLE);
                    }
                    return true;
                } else if (itemId == R.id.aboutus1) {
                    return true;
                } else if (itemId == R.id.aboutus2) {
                    return true;
                } else if (itemId == R.id.ticket) {
                    Intent intent = new Intent(Home.this, ViewTicket.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.logout) {
                    Intent intent = new Intent(Home.this, Login.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
    }
}