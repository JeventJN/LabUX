package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

public class ViewTicket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewticket);
        LinearLayout navbar = findViewById(R.id.navbar);
        LinearLayout navbarsub = findViewById(R.id.navbarsub);
        LinearLayout navigationLayout = findViewById(R.id.navigation);
        ConstraintLayout ticketcontent = findViewById(R.id.tikcetcontent);
        LinearLayout headerbar = findViewById(R.id.headerbar);
        navigationLayout.bringToFront();
        navbar.setVisibility(View.GONE);
        navbarsub.setVisibility(View.GONE);

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