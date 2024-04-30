package com.example.healthtracker.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.healthtracker.Model.DataFactorsModel;
import com.example.healthtracker.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CategoryFragment extends Fragment {
    RadioGroup diabetes,alcohol,diet,medication;

    public CategoryFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_category, container, false);

        diabetes = view.findViewById(R.id.group_option_diabetes);
        alcohol = view.findViewById(R.id.group_option_alcohol);
        diet = view.findViewById(R.id.group_option_diet);
        medication = view.findViewById(R.id.group_option_medication);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("HealthFactors");
        databaseReference.child("factor").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataFactorsModel dataFactorsModel = snapshot.getValue(DataFactorsModel.class);
                diabetes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (dataFactorsModel != null){

                            if (checkedId == R.id.category_diabetes_yes){
                                dataFactorsModel.setDiabetes(1);
                            } else if (checkedId == R.id.category_diabetes_no){
                                dataFactorsModel.setDiabetes(0);
                            }
                            databaseReference.child("factor").setValue(dataFactorsModel);
                        }
                    }
                });

                alcohol.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (dataFactorsModel != null) {

                            if (checkedId == R.id.category_alcohol_yes){
                                dataFactorsModel.setAlcohol_Consumption(1);
                            } else if (checkedId == R.id.category_alcohol_no){
                                dataFactorsModel.setAlcohol_Consumption(0);
                            }
                            databaseReference.child("factor").setValue(dataFactorsModel);
                        }
                    }
                });

                diet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (dataFactorsModel != null){

                            if (checkedId == R.id.category_diet_unhealthy){
                                dataFactorsModel.setDiet(2);
                            } else if (checkedId == R.id.category_diet_average){
                                dataFactorsModel.setDiet(0);
                            } else if (checkedId == R.id.category_diet_healthy){
                                dataFactorsModel.setDiet(1);
                            }
                            databaseReference.child("factor").setValue(dataFactorsModel);
                        }

                    }
                });

                medication.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (dataFactorsModel != null){
                            if (checkedId == R.id.category_medication_yes){
                                dataFactorsModel.setMedication_Use(1);
                            } else if (checkedId == R.id.category_medication_no){
                                dataFactorsModel.setMedication_Use(0);
                            }
                            databaseReference.child("factor").setValue(dataFactorsModel);
                        }

                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}