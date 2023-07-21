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

import com.example.jalihara.databinding.ViewticketmusicBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ViewTicketMusic extends AppCompatActivity {
    ViewticketmusicBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListTicket> dataArrayList = new ArrayList<>();
    ListTicket listTicketMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = ViewticketmusicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LinearLayout navbar = findViewById(R.id.navbar);
        LinearLayout navbarsub = findViewById(R.id.navbarsub);
        ConstraintLayout ticketcontent = findViewById(R.id.tikcetcontent);
        LinearLayout headerbar = findViewById(R.id.headerbar);
        navbar.setVisibility(View.GONE);
        navbarsub.setVisibility(View.GONE);
        TextView pagetitle = findViewById(R.id.pagetitle);
        pagetitle.setText("Ticket");

        String[] MusicNameList = {"Coldplay", "Kodaline", "Sheila on 7", "Simple Plan", "Maroon5"};
        String[] MusicDateList = {"10 Jun 2024", "20 Feb 2024", "12 Dec 2023", "19 Jul 2023", "25 Mar 2024"};
        Double[] MusicPriceList = {Double.valueOf("800000"),Double.valueOf("600000"),Double.valueOf("450000"),Double.valueOf("500000"),Double.valueOf("850000")};
        int[] MusicImageList = {R.drawable.coldplay, R.drawable.kodaline, R.drawable.sheilaon7, R.drawable.simpleplan, R.drawable.maroon5};
        for (int i = 0; i < MusicPriceList.length; i++) {
            listTicketMusic = new ListTicket(MusicNameList[i], MusicDateList[i], MusicPriceList[i], MusicImageList[i]);
            dataArrayList.add(listTicketMusic);
        }
        listAdapter = new ListAdapter(ViewTicketMusic.this, dataArrayList);
        binding.musiclist.setAdapter(listAdapter);
        binding.musiclist.setClickable(true);

        binding.musiclist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewTicketMusic.this, TicketForm.class);
                intent.putExtra("passimage", MusicImageList[i]);
                intent.putExtra("passname", MusicNameList[i]);
                intent.putExtra("passprice", MusicPriceList[i]);
                startActivity(intent);
            }
        });

        Button butArt = findViewById(R.id.MusicArt);
        Button butAM = findViewById(R.id.MusicAM);
        Button butOther = findViewById(R.id.MusicOther);

        butArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTicketMusic.this, ViewTicket.class);
                startActivity(intent);
            }
        });

        butAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTicketMusic.this, ViewTicketAM.class);
                startActivity(intent);
            }
        });

        butOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTicketMusic.this, ViewTicketOther.class);
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

        NavigationView navigationShow = findViewById(R.id.navigationShow);
        navigationShow.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    Intent intent = new Intent(ViewTicketMusic.this, Home.class);
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
                    Intent intent = new Intent(ViewTicketMusic.this, ViewTicket.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.logout) {
                    Intent intent = new Intent(ViewTicketMusic.this, Login.class);
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
                    Intent intent = new Intent(ViewTicketMusic.this, MainAUCU.class);
                    intent.putExtra("flag", "aboutus");
                    startActivity(intent);
                    return true;
                }
                else if (itemId == R.id.aboutus2) {
                    Intent intent = new Intent(ViewTicketMusic.this, MainAUCU.class);
                    intent.putExtra("flag", "contactus");
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }
}