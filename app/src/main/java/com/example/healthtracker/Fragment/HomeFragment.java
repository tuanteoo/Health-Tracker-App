package com.example.healthtracker.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.healthtracker.Activity.BasicInfActivity;
import com.example.healthtracker.Adapter.HealthFactorsAdapter;
import com.example.healthtracker.Model.DataFactorsModel;
import com.example.healthtracker.Model.HealthFactorsModel;
import com.example.healthtracker.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class HomeFragment extends Fragment {

    RecyclerView listFactors;
    HealthFactorsAdapter healthFactorsAdapter;
    ImageView btnBack;

    public HomeFragment() {
        // Required empty public constructor
    }

    @SuppressLint({"NotifyDataSetChanged", "DefaultLocale"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        listFactors = view.findViewById(R.id.list_health_factors);
        listFactors.setLayoutManager(new GridLayoutManager(getContext(),2));
        btnBack = view.findViewById(R.id.home_btn_backbasicinf);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("HealthFactors");

        databaseReference.child("factor").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataFactorsModel dataFactorsModel = snapshot.getValue(DataFactorsModel.class);

                ArrayList<HealthFactorsModel> healthFactorsModels = new ArrayList<>();

                healthFactorsModels.add(new HealthFactorsModel("Heart Rate","bpm",String.valueOf(dataFactorsModel.getHeart_Rate()),R.drawable.icon_heart));
                healthFactorsModels.add(new HealthFactorsModel("Exercise","hrs",String.valueOf(dataFactorsModel.getExercise_Hours_Per_Week()),R.drawable.icon_exercise));
                healthFactorsModels.add(new HealthFactorsModel("Sleep","hrs",String.valueOf(dataFactorsModel.getSleep_Hours_Per_Day()),R.drawable.icon_sleep));
                healthFactorsModels.add(new HealthFactorsModel("Cholesterol","mg/dL",String.valueOf(dataFactorsModel.getCholesterol()),R.drawable.cholesterol));
                healthFactorsModels.add(new HealthFactorsModel("Stress","level",String.valueOf(dataFactorsModel.getStress_Level()),R.drawable.stress));
                healthFactorsModels.add(new HealthFactorsModel("Sedentary","hrs",String.valueOf(dataFactorsModel.getSedentary_Hours_Per_Day()),R.drawable.sedentary));
                healthFactorsModels.add(new HealthFactorsModel("Physical Activity","day",String.valueOf(dataFactorsModel.getPhysical_Activity_Days_Per_Week()),R.drawable.physical_activity));
                healthFactorsModels.add(new HealthFactorsModel("Blood Pressure","",String.format("%d/%d",dataFactorsModel.getSystolic_BP(),dataFactorsModel.getDiastolic_BP()),R.drawable.bloodpressure));

                healthFactorsAdapter = new HealthFactorsAdapter(healthFactorsModels);
                healthFactorsAdapter.notifyDataSetChanged();
                listFactors.setAdapter(healthFactorsAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(requireActivity(), BasicInfActivity.class));
        });

        return view;
    }
}