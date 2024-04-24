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

import com.example.healthtracker.R;
import com.example.healthtracker.databinding.ActivityBasicInforBinding;

public class BasicInfActivity extends AppCompatActivity {
    ActivityBasicInforBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBasicInforBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.basicIn4Man.setOnClickListener(v -> {
            binding.basicIn4Man.setBackgroundResource(R.drawable.shape_select_people);
            binding.basicIn4CheckMan.setVisibility(View.VISIBLE);

            binding.basicIn4Woman.setBackgroundResource(R.drawable.shape_people);
            binding.basicIn4CheckWoman.setVisibility(View.GONE);
        });

        binding.basicIn4Woman.setOnClickListener(v -> {
            binding.basicIn4Woman.setBackgroundResource(R.drawable.shape_select_people);
            binding.basicIn4CheckWoman.setVisibility(View.VISIBLE);

            binding.basicIn4Man.setBackgroundResource(R.drawable.shape_people);
            binding.basicIn4CheckMan.setVisibility(View.GONE);
        });

        binding.basicIn4SeekbarHeight.setMax(450);
        binding.basicIn4SeekbarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = progress + 50;
                binding.textHeight.setText(String.valueOf(value) + "cm");

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
            startActivity(new Intent(this,MainActivity.class));
        });
    }
}