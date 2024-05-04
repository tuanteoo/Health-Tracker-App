package com.example.healthtracker.Adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.healthtracker.Model.HealthFactorsModel;
import com.example.healthtracker.R;
import com.google.android.material.transition.Hold;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

        HealthFactorsModel healthFactorsModel = healthFactorsModels.get(position);

        switch (healthFactorsModel.getNameFactor()) {
            case "Cholesterol":
                replaceLayout(holder, "#F1ECFA", "#7042C9");
                break;
            case "Resting BP":
                replaceLayout(holder, "#E7F7F7", "#0DB1AD");
                break;
            case "Fasting BP":
                replaceLayout(holder, "#E8F2FA", "#197BD2");
                break;
        }
        holder.icon_factors.setImageResource(healthFactorsModels.get(position).getImage());
        holder.name_factors.setText(healthFactorsModels.get(position).getNameFactor());
        holder.value_factors.setText(healthFactorsModels.get(position).getValue());
        holder.measure_factors.setText(healthFactorsModels.get(position).getMeasure());

        holder.itemView.setOnClickListener(v -> {
            final DialogPlus dialogPlus = DialogPlus.newDialog(holder.itemView.getContext())
                    .setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.layout_factor_detail))
                    .setExpanded(true,800)
                    .create();

            View dialogView = dialogPlus.getHolderView();

            Button btnUpdate = dialogView.findViewById(R.id.btn_update);
            TextView nameFactor = dialogView.findViewById(R.id.layout_name_factor);
            TextView valueFactor = dialogView.findViewById(R.id.layout_value_factor);

            nameFactor.setText(healthFactorsModels.get(position).getNameFactor());
            valueFactor.setText(healthFactorsModels.get(position).getValue());

            btnUpdate.setOnClickListener(v1 -> {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("HealthFactors").child("factor");
                Map<String,Object> map = new HashMap<>();
                if (nameFactor.getText().toString().equals("Heart Rate")){
                    map.put("max_heart_rate",valueFactor.getText().toString());
                } else if (nameFactor.getText().toString().equals("Cholesterol")){
                    map.put("cholesterol",valueFactor.getText().toString());
                }else if (nameFactor.getText().toString().equals("Resting BP")){
                    map.put("resting_bp_s",valueFactor.getText().toString());
                }else if (nameFactor.getText().toString().equals("Fasting BP")){
                    String i;
                    if (Integer.parseInt(valueFactor.getText().toString()) > 120 ){
                        i = "1";
                    }else {
                        i = "0";
                    }
                    map.put("fasting_blood_sugar",i);
                    map.put("value_fasting_blood_sugar",valueFactor.getText().toString());
                }else if (nameFactor.getText().toString().equals("OldPeak")){
                    map.put("oldpeak",valueFactor.getText().toString());
                }
                databaseReference.updateChildren(map);
                dialogPlus.dismiss();
            });

            dialogPlus.show();

        });
    }

    private void replaceLayout(ViewHolder holder,String colorLayout,String colorText){
        holder.itemView.getBackground().setColorFilter(Color.parseColor(colorLayout), PorterDuff.Mode.SRC_ATOP);
        holder.name_factors.setTextColor(Color.parseColor(colorText));
        holder.value_factors.setTextColor(Color.parseColor(colorText));
        holder.measure_factors.setTextColor(Color.parseColor(colorText));
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
