package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.jalihara.databinding.TicketformBinding;
import com.example.jalihara.databinding.ViewticketBinding;
import com.google.android.material.navigation.NavigationView;
public class TicketForm extends AppCompatActivity {
    TicketformBinding binding;

    private Dialog dialog;

    private void showDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.ticketdialog);
        dialog.setCancelable(false);
        dialog.show();
    }

//    private void dismissDialog() {
//        if (dialog.isShowing()) {
//            public void
//            dialog.dismiss();
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = TicketformBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayout navbar = findViewById(R.id.navbar);
        LinearLayout navbarsub = findViewById(R.id.navbarsub);
        Button buttonbuy = findViewById(R.id.buttonbuy);
        FrameLayout ticketformcontent = findViewById(R.id.formticketcontent);
        LinearLayout headerbar = findViewById(R.id.headerbar);
        TextView customer = findViewById(R.id.customer);
        TextView quantity = findViewById(R.id.quantity);
        TextView customererror = findViewById(R.id.customershowerror);
        TextView quantityerror = findViewById(R.id.quantityshowerror);
        RadioGroup boothtype = findViewById(R.id.boothtype);
        TextView bootherror = findViewById(R.id.radioshowerror);
        customererror.setVisibility(View.GONE);
        quantityerror.setVisibility(View.GONE);
        bootherror.setVisibility(View.GONE);
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

        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("passname");
            Double price = intent.getDoubleExtra("passprice", 0);
            int image = intent.getIntExtra("passimage", 0);
            String convertprice = new Double(price).toString();
            binding.passedname.setText(name);
            binding.passedprice.setText("Rp" + convertprice);
            binding.passedimage.setImageResource(image);

        }
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

        buttonbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customerName = customer.getText().toString().trim();
                String quantityTicket = quantity.getText().toString().trim();
                boolean isNameValid = true;
                boolean isQuantityValid = true;
                boolean isBoothValid = true;

                if (customerName.isEmpty()) {
                    customererror.setText("Name must be filled");
                    customererror.setVisibility(View.VISIBLE);
                    isNameValid = false;
                } else {
                    customererror.setVisibility(View.INVISIBLE);
                }

                if (quantityTicket.isEmpty()) {
                    quantityerror.setText("Quantity must be filled");
                    quantityerror.setVisibility(View.VISIBLE);
                    isQuantityValid = false;
                }
                else{
                    try {
                        int convertQuantity = Integer.parseInt(quantityTicket);
                        if (convertQuantity < 1){
                            quantityerror.setText("Quantity must be more than 0");
                            quantityerror.setVisibility(View.VISIBLE);
                            isQuantityValid = false;
                        }
                        else {
                            quantityerror.setVisibility(View.INVISIBLE);
                        }
                    } catch (NumberFormatException e) {
                        quantityerror.setText("Please enter a valid input");
                        quantityerror.setVisibility(View.VISIBLE);
                        isQuantityValid = false;
                    }
                }

                if (boothtype.getCheckedRadioButtonId() == -1) {
                    bootherror.setText("Booth type be choosen");
                    bootherror.setVisibility(View.VISIBLE);
                    isBoothValid = false;
                } else {
                    int selectedRadioButtonId = boothtype.getCheckedRadioButtonId();
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String boothstring = selectedRadioButton.getText().toString();
                    bootherror.setVisibility(View.INVISIBLE);
                }

                if (isNameValid && isQuantityValid && isBoothValid) {
                    showDialog();
                }
            }
        });

//        @Override
//        protected void onPause() {
//            super.onPause();
//            dismissDialog();
//        }

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
                    Intent intent = new Intent(TicketForm.this, Login.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }
}
