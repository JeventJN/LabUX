package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.example.jalihara.databinding.ViewticketBinding;
import java.util.ArrayList;

public class ViewTicket extends AppCompatActivity {
    ViewticketBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListTicket> dataArrayList = new ArrayList<>();
    ListTicket listTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = ViewticketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LinearLayout navbar = findViewById(R.id.navbar);
        LinearLayout navbarsub = findViewById(R.id.navbarsub);
        ConstraintLayout ticketcontent = findViewById(R.id.tikcetcontent);
        LinearLayout headerbar = findViewById(R.id.headerbar);
        navbar.setVisibility(View.GONE);
        navbarsub.setVisibility(View.GONE);
        TextView pagetitle = findViewById(R.id.pagetitle);
        pagetitle.setText("Ticket");

        String[] artNameList = {"Ramayana", "Hamlet", "Romeo & Juliet", "The Tempest", "The Art of War"};
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
        binding.artlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewTicket.this, TicketForm.class);
                intent.putExtra("passimage", artImageList[i]);
                intent.putExtra("passimage", artImageList[i]);
                intent.putExtra("passname", artNameList[i]);
                intent.putExtra("passprice", artPriceList[i]);
                startActivity(intent);
            }
        });

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
                    ticketcontent.setAlpha(1f);
                    headerbar.setAlpha(1f);
                } else {
                    navbar.setVisibility(View.VISIBLE);
                    closenavigation.setVisibility(View.VISIBLE);
                    ticketcontent.setAlpha(0.1f);
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
                    ticketcontent.setAlpha(1f);
                    headerbar.setAlpha(1f);
                }
            }
        });
        navbar.setClickable(false);

        headerbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (closenavigation.getVisibility() == View.VISIBLE) {
                    closenavigation.setVisibility(View.GONE);
                    navbar.setVisibility(View.GONE);
                    navbarsub.setVisibility(View.GONE);
                    ticketcontent.setAlpha(1f);
                    headerbar.setAlpha(1f);
                }
//                ticketcontent.performClick(); ini kehitung klik 2x, klik headerbar terus klik ticketcontent
            }
        });

        Button butMusic = findViewById(R.id.ArtMusic);
        Button butAM = findViewById(R.id.ArtAM);
        Button butOther = findViewById(R.id.ArtOther);

        butMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTicket.this, ViewTicketMusic.class);
                startActivity(intent);
            }
        });

        butAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTicket.this, ViewTicketAM.class);
                startActivity(intent);
            }
        });

        butOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTicket.this, ViewTicketOther.class);
                startActivity(intent);
            }
        });

        NavigationView navigationShow = findViewById(R.id.navigationShow);
        navigationShow.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
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
                    Intent intent = new Intent(ViewTicket.this, ViewTicket.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.logout) {
                    Intent intent = new Intent(ViewTicket.this, Login.class);
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
                    Intent intent = new Intent(ViewTicket.this, MainAUCU.class);
                    intent.putExtra("flag", "aboutus");
                    startActivity(intent);
                    return true;
                }
                else if (itemId == R.id.aboutus2) {
                    Intent intent = new Intent(ViewTicket.this, MainAUCU.class);
                    intent.putExtra("flag", "contactus");
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }
}