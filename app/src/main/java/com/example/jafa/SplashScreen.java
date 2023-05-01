package com.example.jafa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    Animation logoAnimation;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);





        ImageView logo = findViewById(R.id.logosplash);
        logoAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_anim_splashscreen);
        logo.setAnimation(logoAnimation);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                finish();

            }
        },1800);

    }
}