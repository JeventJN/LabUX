package com.example.jalihara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class ListAdapterPopular extends ArrayAdapter<ListTicket> {
    public ListAdapterPopular(@NonNull Context context, ArrayList<ListTicket> dataArrayList) {
        super(context, R.layout.templatelisthome, dataArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ListTicket listData = getItem(position);
        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.templatelisthome, parent, false);
        }
        TextView listName = view.findViewById(R.id.popularname);
        TextView listDate = view.findViewById(R.id.populardate);
        TextView listPrice = view.findViewById(R.id.popularprice);
        ImageView listImage = view.findViewById(R.id.popularimage);
        listName.setText(listData.name);
        listDate.setText(listData.time);
        listPrice.setText("IDR" + String.valueOf(listData.price));
        listImage.setImageResource(listData.image);;
        return view;
    }
}

