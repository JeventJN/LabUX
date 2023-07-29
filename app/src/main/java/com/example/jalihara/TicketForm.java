package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.jalihara.databinding.TicketformBinding;
import com.google.android.material.navigation.NavigationView;

import java.text.BreakIterator;

public class TicketForm extends AppCompatActivity {
    TicketformBinding binding;

    private Dialog dialog;

    private View dialogView;

    private void showDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.ticketdialog);
        dialog.setCancelable(false);
        dialog.show();
        dialogView = dialog.findViewById(android.R.id.content);

        EditText customerEditText = findViewById(R.id.customer);
        String customerName = customerEditText.getText().toString();;
        EditText quantityEditText = findViewById(R.id.quantity);
        String quantity = quantityEditText.getText().toString();;
        Double quantityCount = Double.parseDouble(quantity);
        TextView ticketdialogTitle = dialogView.findViewById(R.id.ticketdialogTitle);
        TextView customerPassed = dialogView.findViewById(R.id.customerPassed);
        TextView quantityPassed = dialogView.findViewById(R.id.quantityPassed);
        TextView boothPassed = dialogView.findViewById(R.id.boothPassed);
        TextView totalprice = dialogView.findViewById(R.id.totalprice);
        TextView pricedetailed = dialogView.findViewById(R.id.pricedetailed);
        TextView confirmpassworderror = dialogView.findViewById(R.id.confirmpassworderror);
        confirmpassworderror.setVisibility(View.INVISIBLE);

        Intent intent = this.getIntent();
        String name = intent.getStringExtra("passname");
        Double price = intent.getDoubleExtra("passprice", 0);

        RadioGroup boothtype = findViewById(R.id.boothtype);
        int selectedRadioButtonId = boothtype.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String boothstring = selectedRadioButton.getText().toString();

        String passwordLogin = Login.getInstance().getPasswordLogin();

        ticketdialogTitle.setText(name);
        customerPassed.setText("Name           :  " + customerName);
        quantityPassed.setText("Quantity      :  " + quantity);
        boothPassed.setText("Seat type     :  " + boothstring);

        if (boothstring.equals("VIP")){
            Double price2 = price * 2 * quantityCount;
            String convertprice2 = new Double(price2).toString();
            totalprice.setText("Total Price   : IDR " + String.format("%.0f", price2));
        }
        else{
            Double price2 = price * quantityCount;
            String convertprice2 = new Double(price2).toString();
            totalprice.setText("Total Price   :  IDR " + String.format("%.0f", price2));
        }
        pricedetailed.setText("VIP=2*Regular");


        ImageView closedialog = dialogView.findViewById(R.id.closedialog);
        closedialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissDialog();
            }
        });

        TextView dialogcancel = dialogView.findViewById(R.id.dailogcancel);
        dialogcancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismissDialog();
            }
        });

        TextView dialogpurchase = dialogView.findViewById(R.id.dailogpurchase);
        dialogpurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView passwordtest = dialogView.findViewById(R.id.password);
                String passwordValue = passwordtest.getText().toString();
                if (passwordLogin.equals(passwordValue)){
                    Intent intent = new Intent(TicketForm.this, Home.class);
                    startActivity(intent);
                }
                else{
                    confirmpassworderror.setText("Password is not the same");
                    confirmpassworderror.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void dismissDialog() {
        dialog.dismiss();
    }

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
        TextView pagetitle = findViewById(R.id.pagetitle);
        pagetitle.setText("Buy Ticket");
        ImageView backbutton = findViewById(R.id.backbutton);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketForm.this, ViewTicket.class);
                startActivity(intent);
            }
        });

        Intent intent = this.getIntent();
        String name = intent.getStringExtra("passname");
        Double price = intent.getDoubleExtra("passprice", 0);
        int image = intent.getIntExtra("passimage", 0);
        String convertprice = new Double(price).toString();
        binding.passedname.setText(name);
        binding.passedprice.setText("IDR" + String.format("%.0f", price));
        binding.passedimage.setImageResource(image);


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
                    ticketformcontent.setAlpha(1.0f);
                    headerbar.setAlpha(1.0f);
                } else {
                    navbar.setVisibility(View.VISIBLE);
                    closenavigation.setVisibility(View.VISIBLE);
                    ticketformcontent.setAlpha(0.1f);
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
                    ticketformcontent.setAlpha(1f);
                    headerbar.setAlpha(1f);
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
                    ticketformcontent.setAlpha(1f);
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
                    bootherror.setVisibility(View.INVISIBLE);
                }

                if (isNameValid && isQuantityValid && isBoothValid) {
                    showDialog();

                }
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
                    Intent intent = new Intent(TicketForm.this, Login.class);
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
                    Intent intent = new Intent(TicketForm.this, MainAUCU.class);
                    intent.putExtra("flag", "aboutus");
                    startActivity(intent);
                    return true;
                }
                else if (itemId == R.id.aboutus2) {
                    Intent intent = new Intent(TicketForm.this, MainAUCU.class);
                    intent.putExtra("flag", "contactus");
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }
}
