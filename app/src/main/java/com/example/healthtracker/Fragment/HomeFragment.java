package com.example.healthtracker.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeFragment extends Fragment {

    RecyclerView listFactors;
    HealthFactorsAdapter healthFactorsAdapter;
    ImageView btnBack,btnSync;
    TextView resultPredict;
    private final String url = "https://health-tracker-app-542fdafa4368.herokuapp.com/predict";

    public HomeFragment() {
        // Required empty public constructor
    }

    @SuppressLint({"NotifyDataSetChanged", "DefaultLocale", "MissingInflatedId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        listFactors = view.findViewById(R.id.list_health_factors);
        listFactors.setLayoutManager(new GridLayoutManager(getContext(),2));
        btnBack = view.findViewById(R.id.home_btn_backbasicinf);
        btnSync = view.findViewById(R.id.home_btn_sync);
        resultPredict = view.findViewById(R.id.home_result_predict);

        //Firebase
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("HealthFactors");

        //Get dataFactorsModel from firebase with child "factor"
        databaseReference.child("factor").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataFactorsModel dataFactorsModel = snapshot.getValue(DataFactorsModel.class);

                ArrayList<HealthFactorsModel> healthFactorsModels = new ArrayList<>();

                if (dataFactorsModel != null){
                    healthFactorsModels.add(new HealthFactorsModel("Heart Rate","bpm",dataFactorsModel.getMax_heart_rate(),R.drawable.icon_heart));
                    healthFactorsModels.add(new HealthFactorsModel("Cholesterol","mg/dL",dataFactorsModel.getCholesterol(),R.drawable.cholesterol));
                    healthFactorsModels.add(new HealthFactorsModel("Resting BP","mmHg",dataFactorsModel.getResting_bp_s(),R.drawable.bloodpressure));
                    healthFactorsModels.add(new HealthFactorsModel("Fasting BP","mg/dl",dataFactorsModel.getValue_fasting_blood_sugar(),R.drawable.bloodpressure));
                    healthFactorsModels.add(new HealthFactorsModel("OldPeak","level",dataFactorsModel.getOldpeak(),R.drawable.stress));
                    healthFactorsModels.add(new HealthFactorsModel("Test Feature","",dataFactorsModel.getTestfeature(),R.drawable.stress));
                }

                healthFactorsAdapter = new HealthFactorsAdapter(healthFactorsModels);
                healthFactorsAdapter.notifyDataSetChanged();
                listFactors.setAdapter(healthFactorsAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // Sync data from Firebase and POST data to server to get result
        btnSync.setOnClickListener(v -> {
            databaseReference.child("factor").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    DataFactorsModel dataFactorsModel = snapshot.getValue(DataFactorsModel.class);
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        String result = jsonObject.getString("Heart Disease");
                                        if (result.equals("1")){
                                            resultPredict.setText("You may have a heart condition. Please see the doctor for a timely check-up");
                                        } else {
                                            resultPredict.setText("Your heart is still normal");
                                        }
                                    } catch (JSONException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            },
                            volleyError -> {
                                String errorMessage = (volleyError.getMessage() != null) ? volleyError.getMessage() : "An error occurred";
                                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show();
                            }){
                        @NonNull
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<>();

                            if (dataFactorsModel != null) {
                                params.put("age", dataFactorsModel.getAge());
                                params.put("sex", dataFactorsModel.getSex());
                                params.put("chest pain type", dataFactorsModel.getChest_pain_type());
                                params.put("resting bp s", dataFactorsModel.getResting_bp_s());
                                params.put("cholesterol", dataFactorsModel.getCholesterol());
                                params.put("fasting blood sugar", dataFactorsModel.getFasting_blood_sugar());
                                params.put("resting ecg", dataFactorsModel.getResting_ecg());
                                params.put("max heart rate", dataFactorsModel.getMax_heart_rate());
                                params.put("exercise angina", dataFactorsModel.getExercise_angina());
                                params.put("oldpeak", dataFactorsModel.getOldpeak());
                                params.put("ST slope", dataFactorsModel.getST_slope());
                                params.put("Test Feature", dataFactorsModel.getTestfeature());
                            }
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
                    requestQueue.add(stringRequest);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });

        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(requireActivity(), BasicInfActivity.class));
        });

        return view;
    }
}