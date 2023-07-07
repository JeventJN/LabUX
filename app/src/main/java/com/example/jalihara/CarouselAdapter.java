package com.example.jalihara;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jalihara.R;
import com.example.jalihara.ViewTicket;

import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.ImageViewHolder> {
    private Context context;
    private List<Integer> imageList;

    public CarouselAdapter(Context context, List<Integer> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carouselitem, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int imageRes = imageList.get(holder.getAdapterPosition());
        holder.bannerView.setImageResource(imageRes);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform your intent here
                Intent intent = new Intent(context, ViewTicket.class);
                // Add any necessary extras to the intent
                // For example, you can pass the clicked item position or image resource ID
                intent.putExtra("position", position);
                intent.putExtra("imageRes", imageRes);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView bannerView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerView = itemView.findViewById(R.id.bannerview);
        }
    }
}