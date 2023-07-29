package com.example.jalihara;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter extends ArrayAdapter<ListTicket> {
    public ListAdapter(@NonNull Context context, ArrayList<ListTicket> dataArrayList) {
        super(context, R.layout.templatelist, dataArrayList);
    }
    @NonNull
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ListTicket listData = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.templatelist, parent, false);
        }

        // Find other views as usual

        Button buttonBuy = view.findViewById(R.id.buttonbuy);
        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Buy button click and start another activity
                if (listData != null) {
                    Intent intent = new Intent(getContext(), TicketForm.class);
                    intent.putExtra("passimage", listData.getImage()); // Pass the image ID
                    intent.putExtra("passname", listData.getName());   // Pass the name
                    intent.putExtra("passprice", listData.getPrice()); // Pass the price
                    intent.putExtra("passdate", listData.getDate());   // Pass the date
                    getContext().startActivity(intent);
                }
            }
        });

        // Set the clickable flag for each item
        // Here, we'll set the Buy button clickable, and other items not clickable
        if (position == getCount() - 1) {
            // Last item, which is the Buy button
            listData.setClickable(true);
        } else {
            // Other items, not clickable
            listData.setClickable(false);
        }
        TextView listName = view.findViewById(R.id.nameticket);
        TextView listDate = view.findViewById(R.id.dateticket);
        TextView listPrice = view.findViewById(R.id.priceticket);
        ImageView listImage = view.findViewById(R.id.imageticket);
        listName.setText(listData.name);
        listDate.setText(listData.time);
        listPrice.setText("IDR " + String.format("%.0f", listData.price));
        listImage.setImageResource(listData.image);;
        return view;
    }

    @Override
    public boolean isEnabled(int position) {
        ListTicket item = getItem(position);
        return item != null && item.isClickable();
    }


}

