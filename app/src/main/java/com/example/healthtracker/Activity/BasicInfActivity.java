package com.example.healthtracker.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.healthtracker.Model.DataFactorsModel;
import com.example.healthtracker.R;
import com.example.healthtracker.databinding.ActivityBasicInforBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class BasicInfActivity extends AppCompatActivity {
    ActivityBasicInforBinding binding;
    private final DataFactorsModel dataFactorsModel = new DataFactorsModel();
    private int heightValue;
    private int weightValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBasicInforBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataFactorsModel.setSex("1");

        binding.basicIn4Man.setOnClickListener(v -> {
            binding.basicIn4Man.setBackgroundResource(R.drawable.shape_select_people);
            binding.basicIn4CheckMan.setVisibility(View.VISIBLE);

            binding.basicIn4Woman.setBackgroundResource(R.drawable.shape_people);
            binding.basicIn4CheckWoman.setVisibility(View.GONE);

            dataFactorsModel.setSex("1");
        });

        binding.basicIn4Woman.setOnClickListener(v -> {
            binding.basicIn4Woman.setBackgroundResource(R.drawable.shape_select_people);
            binding.basicIn4CheckWoman.setVisibility(View.VISIBLE);

            binding.basicIn4Man.setBackgroundResource(R.drawable.shape_people);
            binding.basicIn4CheckMan.setVisibility(View.GONE);

           dataFactorsModel.setSex("0");
        });

        //Seekbar Age
        binding.basicIn4SeekbarAge.setMax(74);
        binding.basicIn4SeekbarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = progress + 16;
                binding.textAge.setText(String.valueOf(value));
                dataFactorsModel.setAge(String.valueOf(value));

                int padding = binding.basicIn4SeekbarAge.getPaddingLeft() + binding.basicIn4SeekbarAge.getPaddingRight();
                int seekBarWidth = seekBar.getWidth() - padding;
                float thumbPos = seekBarWidth * ((float)progress / seekBar.getMax());
                binding.textAge.setX(seekBar.getX() + thumbPos + (float) padding /2 - (float) binding.textAge.getWidth() / 2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //Seekbar Height
        binding.basicIn4SeekbarHeight.setMax(450);
        binding.basicIn4SeekbarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = progress + 50;
                binding.textHeight.setText(value + "cm");
                heightValue = value;

                int padding = binding.basicIn4SeekbarHeight.getPaddingLeft() + binding.basicIn4SeekbarHeight.getPaddingRight();
                int seekBarWidth = seekBar.getWidth() - padding;
                float thumbPos = seekBarWidth * ((float)progress / seekBar.getMax());
                binding.textHeight.setX(seekBar.getX() + thumbPos + (float) padding /2 - (float) binding.textHeight.getWidth() / 2);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.basicIn4SeekbarWeight.setMax(180);
        binding.basicIn4SeekbarWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = progress + 20;
                weightValue = value;
                binding.textWeight.setText(value + "kg");

                int padding = binding.basicIn4SeekbarWeight.getPaddingLeft() + binding.basicIn4SeekbarWeight.getPaddingRight();
                int seekBarWidth = seekBar.getWidth() - padding;
                float thumbPos = seekBarWidth * ((float)progress / seekBar.getMax());
                binding.textWeight.setX(seekBar.getX() + thumbPos + (float) padding /2 - (float) binding.textHeight.getWidth() / 2);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.basicIn4BtnNext.setOnClickListener(v -> {
            Map<String,Object> map = new HashMap<>();
            map.put("age",dataFactorsModel.getAge());
            map.put("sex",dataFactorsModel.getSex());

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("HealthFactors");
            databaseReference.child("factor").updateChildren(map);

            startActivity(new Intent(this,MainActivity.class));
        });
    }
}