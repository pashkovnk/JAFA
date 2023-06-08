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

    private BodyCompositionCalculations bodyCompositionCalculations = new BodyCompositionCalculations();


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_composition);


        TextView[] currentValues = {findViewById(R.id.currentWeight), findViewById(R.id.currentBMI), findViewById(R.id.currentMusclesWeight), findViewById(R.id.currentFatPercents), findViewById(R.id.currentHeight),
                findViewById(R.id.progressWeight), findViewById(R.id.progressBMI), findViewById(R.id.progressMusclesWeight), findViewById(R.id.progressFatPercents), findViewById(R.id.progressHeight)};
        String[] values = {bodyCompositionCalculations.getUserWeight() + " кг", bodyCompositionCalculations.getBodyMassIndex() + " eд", bodyCompositionCalculations.getUserMusclesWeight() + " кг", bodyCompositionCalculations.getUserFatPercents() + " %", bodyCompositionCalculations.getUserHeight() + " м",
                //допиши для прогрессов
        };

        for (int i = 0; i < currentValues.length; i++) {
            currentValues[i].setText(values[i]);
        }


        /* Замени эту стену на че попроще*/
//        TextView currentWeight = findViewById(R.id.currentWeight);
//        TextView currentBMI = findViewById(R.id.currentBMI);
//        TextView currentMusclesWeight = findViewById(R.id.currentMusclesWeight);
//        TextView currentFatPercents = findViewById(R.id.currentFatPercents);
//        TextView currentHeight = findViewById(R.id.currentHeight);

//        TextView progressWeight = findViewById(R.id.progressWeight);
//        TextView progressBMI = findViewById(R.id.progressBMI);
//        TextView progressMusclesWeight = findViewById(R.id.progressMusclesWeight);
//        TextView progressFatPercents = findViewById(R.id.progressFatPercents);
//        TextView progressHeight = findViewById(R.id.progressHeight);

//        currentWeight.setText(bodyCompositionCalculations.getUserWeight() + " кг");
//        currentBMI.setText(bodyCompositionCalculations.getBodyMassIndex() + " eд");
//        currentMusclesWeight.setText(bodyCompositionCalculations.getUserMusclesWeight() + " кг");
//        currentFatPercents.setText(bodyCompositionCalculations.getUserFatPercents() + " %");
//        currentHeight.setText(bodyCompositionCalculations.getUserHeight() + " м");

    }


}

