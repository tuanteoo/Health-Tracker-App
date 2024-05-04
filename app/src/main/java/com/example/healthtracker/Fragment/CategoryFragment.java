package com.example.healthtracker.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.healthtracker.Model.DataFactorsModel;
import com.example.healthtracker.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CategoryFragment extends Fragment {
    RadioGroup Chestpaintype,regc,ExerciseAngina,STlope;

    public CategoryFragment() {
        // Required empty public constructor
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_category, container, false);

        Chestpaintype = view.findViewById(R.id.group_option_Chestpaintype);
        regc = view.findViewById(R.id.group_option_regc);
        ExerciseAngina = view.findViewById(R.id.group_option_ExerciseAngina);
        STlope = view.findViewById(R.id.group_option_STlope);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("HealthFactors");
        databaseReference.child("factor").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataFactorsModel dataFactorsModel = snapshot.getValue(DataFactorsModel.class);
                Chestpaintype.setOnCheckedChangeListener((group, checkedId) -> {
                    if (dataFactorsModel != null){

                        if (checkedId == R.id.category_Chestpaintype_ata){
                            dataFactorsModel.setChest_pain_type("2");
                        } else if (checkedId == R.id.category_Chestpaintype_nap){
                            dataFactorsModel.setChest_pain_type("3");
                        }else if (checkedId == R.id.category_Chestpaintype_ta){
                            dataFactorsModel.setChest_pain_type("1");
                        }else if (checkedId == R.id.category_Chestpaintype_asy){
                            dataFactorsModel.setChest_pain_type("4");
                        }
                        databaseReference.child("factor").setValue(dataFactorsModel);
                    }
                });

                regc.setOnCheckedChangeListener((group, checkedId) -> {
                    if (dataFactorsModel != null) {

                        if (checkedId == R.id.category_regc_normal){
                            dataFactorsModel.setResting_ecg("0");
                        } else if (checkedId == R.id.category_regc_abnormality){
                            dataFactorsModel.setResting_ecg("1");
                        }else if (checkedId == R.id.category_regc_Hypertrophy) {
                            dataFactorsModel.setResting_ecg("2");
                        }
                        databaseReference.child("factor").setValue(dataFactorsModel);
                    }
                });

                ExerciseAngina.setOnCheckedChangeListener((group, checkedId) -> {
                    if (dataFactorsModel != null){

                        if (checkedId == R.id.category_ExerciseAngina_yes){
                            dataFactorsModel.setExercise_angina("1");
                        } else if (checkedId == R.id.category_ExerciseAngina_no){
                            dataFactorsModel.setExercise_angina("0");
                        }
                        databaseReference.child("factor").setValue(dataFactorsModel);
                    }

                });

                STlope.setOnCheckedChangeListener((group, checkedId) -> {
                    if (dataFactorsModel != null){
                        if (checkedId == R.id.category_STlope_UpSloping){
                            dataFactorsModel.setST_slope("1");
                        } else if (checkedId == R.id.category_STlope_Flat){
                            dataFactorsModel.setST_slope("2");
                        }else if (checkedId == R.id.category_STlope_downsloping){
                            dataFactorsModel.setST_slope("3");
                        }
                        databaseReference.child("factor").setValue(dataFactorsModel);
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