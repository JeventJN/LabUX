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

import com.example.jalihara.databinding.ViewticketartmusicBinding;
import com.google.android.material.navigation.NavigationView;
import com.example.jalihara.databinding.ViewticketBinding;
import java.util.ArrayList;

public class ViewTicketAM extends AppCompatActivity {
    ViewticketartmusicBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListTicket> dataArrayList = new ArrayList<>();
    ListTicket listTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = ViewticketartmusicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LinearLayout navbar = findViewById(R.id.navbar);
        LinearLayout navbarsub = findViewById(R.id.navbarsub);
        ConstraintLayout ticketcontent = findViewById(R.id.tikcetcontent);
        LinearLayout headerbar = findViewById(R.id.headerbar);
        navbar.setVisibility(View.GONE);
        navbarsub.setVisibility(View.GONE);
        TextView pagetitle = findViewById(R.id.pagetitle);
        pagetitle.setText("Ticket");

        String[] AMNameList = {"Disney", "The Magic Flute", "Universal", "Transtudio"};
        String[] AMDateList = {"10 Jul 2023", "12 Jul 2023", "20 May 2024", "21 Nov 2023"};
        Double[] AMPriceList = {Double.valueOf("900000"),Double.valueOf("800000"),Double.valueOf("900000"),Double.valueOf("600000")};
        int[] AMImageList = {R.drawable.disney, R.drawable.themagicflute, R.drawable.universal, R.drawable.transtudio};
        for (int i = 0; i < AMPriceList.length; i++) {
            listTicket = new ListTicket(AMNameList[i], AMDateList[i], AMPriceList[i], AMImageList[i]);
            dataArrayList.add(listTicket);
        }
        listAdapter = new ListAdapter(ViewTicketAM.this, dataArrayList);
        binding.amlist.setAdapter(listAdapter);
        binding.amlist.setClickable(true);

        binding.amlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewTicketAM.this, TicketForm.class);
                intent.putExtra("passimage", AMImageList[i]);
                intent.putExtra("passname", AMNameList[i]);
                intent.putExtra("passprice", AMPriceList[i]);
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

        Button butMusic = findViewById(R.id.AMMusic);
        Button butArt = findViewById(R.id.AMArt);
        Button butOther = findViewById(R.id.AMOther);

        butMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTicketAM.this, ViewTicketMusic.class);
                startActivity(intent);
            }
        });

        butArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTicketAM.this, ViewTicket.class);
                startActivity(intent);
            }
        });

        butOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTicketAM.this, ViewTicketOther.class);
                startActivity(intent);
            }
        });

        NavigationView navigationShow = findViewById(R.id.navigationShow);
        navigationShow.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    Intent intent = new Intent(ViewTicketAM.this, Home.class);
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
                    Intent intent = new Intent(ViewTicketAM.this, ViewTicket.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.logout) {
                    Intent intent = new Intent(ViewTicketAM.this, Login.class);
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
                    Intent intent = new Intent(ViewTicketAM.this, MainAUCU.class);
                    intent.putExtra("flag", "aboutus");
                    startActivity(intent);
                    return true;
                }
                else if (itemId == R.id.aboutus2) {
                    Intent intent = new Intent(ViewTicketAM.this, MainAUCU.class);
                    intent.putExtra("flag", "contactus");
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }
}