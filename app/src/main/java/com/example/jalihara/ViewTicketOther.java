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
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jalihara.databinding.ViewticketotherBinding;
import com.google.android.material.navigation.NavigationView;
import com.example.jalihara.databinding.ViewticketBinding;
import java.util.ArrayList;

public class ViewTicketOther extends AppCompatActivity {
    ViewticketotherBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListTicket> dataArrayList = new ArrayList<>();
    ListTicket listTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = ViewticketotherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LinearLayout navbar = findViewById(R.id.navbar);
        LinearLayout navbarsub = findViewById(R.id.navbarsub);
        ConstraintLayout ticketcontent = findViewById(R.id.tikcetcontent);
        LinearLayout headerbar = findViewById(R.id.headerbar);
        navbar.setVisibility(View.GONE);
        navbarsub.setVisibility(View.GONE);

        String[] OtherNameList = {"SnakeBoy"};
        String[] OtherDateList = {"10 Jun 2024"};
        Double[] OtherPriceList = {Double.valueOf("200000")};
        int[] OtherImageList = {R.drawable.sneakyboy};
        for (int i = 0; i < OtherPriceList.length; i++) {
            listTicket = new ListTicket(OtherNameList[i], OtherDateList[i], OtherPriceList[i], OtherImageList[i]);
            dataArrayList.add(listTicket);
        }
        listAdapter = new ListAdapter(ViewTicketOther.this, dataArrayList);
        binding.otherlist.setAdapter(listAdapter);
        binding.otherlist.setClickable(true);
        binding.otherlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewTicketOther.this, TicketForm.class);
                intent.putExtra("passimage", OtherImageList[i]);
                intent.putExtra("passimage", OtherImageList[i]);
                intent.putExtra("passname", OtherNameList[i]);
                intent.putExtra("passprice", OtherPriceList[i]);
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

        Button butArt = findViewById(R.id.OtherArt);
        Button butMusic = findViewById(R.id.OtherMusic);
        Button butAM = findViewById(R.id.OtherAM);

        butMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTicketOther.this, ViewTicketMusic.class);
                startActivity(intent);
            }
        });

        butAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTicketOther.this, ViewTicketAM.class);
                startActivity(intent);
            }
        });

        butArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTicketOther.this, ViewTicket.class);
                startActivity(intent);
            }
        });

        NavigationView navigationShow = findViewById(R.id.navigationShow);
        navigationShow.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    Intent intent = new Intent(ViewTicketOther.this, Home.class);
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
                    Intent intent = new Intent(ViewTicketOther.this, ViewTicket.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.logout) {
                    Intent intent = new Intent(ViewTicketOther.this, Login.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
    }
}