package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;
import com.example.jalihara.databinding.ViewticketBinding;

import java.util.ArrayList;
import java.util.List;

public class ViewTicket extends AppCompatActivity {
    ViewticketBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListTicket> dataArrayList = new ArrayList<>();
    ListTicket listTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ViewticketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LinearLayout navbar = findViewById(R.id.navbar);
        LinearLayout navbarsub = findViewById(R.id.navbarsub);
        ConstraintLayout ticketcontent = findViewById(R.id.tikcetcontent);
        LinearLayout headerbar = findViewById(R.id.headerbar);
        navbar.setVisibility(View.GONE);
        navbarsub.setVisibility(View.GONE);
        //    binding = ActivityMainBinding.inflate(getLayoutInflater());
//    setContentView(binding.getRoot());
        String[] artNameList = {"Pasta", "Maggi", "Cake", "Pancake", "Pizza","Burgers", "Fries"};
        String[] artDateList = {"21 Jun 2023", "12 Mar 2023", "05 Sep 2023", "28 Dec 2023", "17 Aug 2023"};
        Double[] artPriceList = {Double.valueOf("350000"),Double.valueOf("400000"),Double.valueOf("500000"),Double.valueOf("400000"),Double.valueOf("250000")};
        int[] artImageList = {R.drawable.ramayana, R.drawable.hamlet, R.drawable.romeojuliet, R.drawable.tempest, R.drawable.artofwar};
        for (int i = 0; i < artPriceList.length; i++) {
            listTicket = new ListTicket(artNameList[i], artDateList[i], artPriceList[i], artImageList[i]);
            dataArrayList.add(listTicket);
        }
        listAdapter = new ListAdapter(ViewTicket.this, dataArrayList);
        binding.artlist.setAdapter(listAdapter);
        binding.artlist.setClickable(true);

        ImageView imagemenu = findViewById(R.id.imagemenu);
        imagemenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (navbar.getVisibility() == View.VISIBLE) {
                    navbar.setVisibility(View.GONE);
                    navbarsub.setVisibility(View.GONE);
                    ticketcontent.setAlpha(1f);
                    headerbar.setAlpha(1f);
                } else {
                    navbar.setVisibility(View.VISIBLE);
                    ticketcontent.setAlpha(0.1f);
                    headerbar.setAlpha(0.1f);
                }
            }
        });
        ticketcontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (navbar.getVisibility() == View.VISIBLE) {
                    navbar.setVisibility(View.GONE);
                    navbarsub.setVisibility(View.GONE);
                    ticketcontent.setAlpha(1f);
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
                    ticketcontent.setAlpha(1f);
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
                    Intent intent = new Intent(ViewTicket.this, Home.class);
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
//                    Intent intent = new Intent(ViewTickets.this, MainActivity.class);
//                    startActivity(intent);
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