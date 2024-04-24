package com.example.healthtracker.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.healthtracker.Model.HealthFactorsModel;
import com.example.healthtracker.R;

import java.util.ArrayList;

public class HealthFactorsAdapter extends RecyclerView.Adapter<HealthFactorsAdapter.ViewHolder> {
    private final ArrayList<HealthFactorsModel> healthFactorsModels;

    public HealthFactorsAdapter(ArrayList<HealthFactorsModel> healthFactorsModels) {
        this.healthFactorsModels = healthFactorsModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_health_factors,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Glide.with(holder.itemView.getContext())
//                .load(healthFactorsModels.get(position).getImage())
//                .into(holder.icon_factors);
        holder.name_factors.setText(healthFactorsModels.get(position).getNameFactor());
        holder.value_factors.setText(String.valueOf(healthFactorsModels.get(position).getValue()));
        holder.measure_factors.setText(healthFactorsModels.get(position).getMeasure());
    }

    @Override
    public int getItemCount() {
        return healthFactorsModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon_factors;
        TextView name_factors,value_factors,measure_factors;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            icon_factors = itemView.findViewById(R.id.item_health_icon);
            name_factors = itemView.findViewById(R.id.item_health_name);
            value_factors = itemView.findViewById(R.id.item_value_factors);
            measure_factors = itemView.findViewById(R.id.item_measure_factors);
        }
    }
}
