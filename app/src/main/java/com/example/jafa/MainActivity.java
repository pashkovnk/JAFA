package com.example.jafa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bodyComposition(View view) {
        Intent toBodyCompositionScreen = new Intent(MainActivity.this, BodyComposition.class);
        startActivity(toBodyCompositionScreen);
    }

    public void trainings(View view) {
        Intent toTrainings = new Intent(MainActivity.this, Trainings.class);
        startActivity(toTrainings);
    }
}