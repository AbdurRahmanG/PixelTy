package com.techilyfly.pixelty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.techilyfly.pixelty.databinding.ActivityResultBinding;

import com.google.android.gms.ads.InterstitialAd;

public class ResultActivity extends AppCompatActivity {
    ActivityResultBinding binding;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.imageViewFinalImage.setImageURI(getIntent().getData());

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7843981062980856/9696145550");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

                if (mInterstitialAd.isLoaded())
                    mInterstitialAd.show();
            }
        });

    }
}