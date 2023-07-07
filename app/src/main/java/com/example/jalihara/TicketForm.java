package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.navigation.NavigationView;
public class TicketForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticketform);

        LinearLayout navbar = findViewById(R.id.navbar);
        LinearLayout navbarsub = findViewById(R.id.navbarsub);
        ConstraintLayout ticketformcontent = findViewById(R.id.formticketcontent);
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
                    ticketformcontent.setAlpha(1f);
                    headerbar.setAlpha(1f);
                } else {
                    navbar.setVisibility(View.VISIBLE);
                    ticketformcontent.setAlpha(0.1f);
                    headerbar.setAlpha(0.1f);
                }
            }
        });
        ticketformcontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (navbar.getVisibility() == View.VISIBLE) {
                    navbar.setVisibility(View.GONE);
                    navbarsub.setVisibility(View.GONE);
                    ticketformcontent.setAlpha(1f);
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
                    ticketformcontent.setAlpha(1f);
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
                    Intent intent = new Intent(TicketForm.this, Home.class);
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
                    Intent intent = new Intent(TicketForm.this, ViewTicket.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.logout) {
                    Intent intent = new Intent(TicketForm.this, TicketForm.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
    }
}