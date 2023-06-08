package com.example.jafa.controllers.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jafa.R;
import com.example.jafa.models.*;

public class BodyComposition extends AppCompatActivity {

//    private UserWeight userWeight = new UserWeight();
//    private UserHeight userHeight = new UserHeight();
//    private UserMusclesWeight userMusclesWeight = new UserMusclesWeight();
//    private UserFatPercents userFatPercents = new UserFatPercents();

    //private BodyCompositionCalculations bodyCompositionCalculations = new BodyCompositionCalculations();


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_composition);




        /* Замени эту стену на че попроще*/
        TextView currentWeight = findViewById(R.id.currentWeight);
        TextView currentBMI = findViewById(R.id.currentBMI);
        TextView currentMusclesWeight = findViewById(R.id.currentMusclesWeight);
        TextView currentFatPercents = findViewById(R.id.currentFatPercents);
        TextView currentHeight = findViewById(R.id.currentHeight);

        currentWeight.setText("0.0" + " кг");
        currentBMI.setText("0.0" + " eд");
        currentMusclesWeight.setText("0.0" + " кг");
        currentFatPercents.setText("0.0" + " %");
        currentHeight.setText("0.0" + "м");

    }


}

