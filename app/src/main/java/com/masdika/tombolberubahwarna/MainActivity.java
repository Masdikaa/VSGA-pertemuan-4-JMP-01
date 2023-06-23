package com.masdika.tombolberubahwarna;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.masdika.tombolberubahwarna.databinding.ActivityMainBinding;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AtomicInteger a = new AtomicInteger(1);
        int colorRed = ContextCompat.getColor(this, R.color.red);
        int colorBlue = ContextCompat.getColor(this, R.color.blue);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.button.setBackgroundTintList(ColorStateList.valueOf(colorRed));
        }

        binding.button.setOnClickListener(v -> {
            a.incrementAndGet();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (a.get() % 2 != 0) {
                    binding.button.setBackgroundTintList(ColorStateList.valueOf(colorRed));
                } else {
                    binding.button.setBackgroundTintList(ColorStateList.valueOf(colorBlue));
                }
            }
        });
    }
}