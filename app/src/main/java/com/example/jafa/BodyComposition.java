package com.example.jafa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jafa.classes.bodyParameters.*;
import com.example.jafa.models.*;

public class BodyComposition extends AppCompatActivity {

    private UserWeight userWeight = new UserWeight();
    private UserHeight userHeight = new UserHeight();
    private UserMusclesWeight userMusclesWeight = new UserMusclesWeight();
    private UserFatPercents userFatPercents = new UserFatPercents();
    private BodyCompositionCalculations bodyCompositionCalculations = new BodyCompositionCalculations();


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_composition);

        TextView currentWeight = findViewById(R.id.currentWeight);
        TextView currentBMI = findViewById(R.id.currentBMI);
        TextView currentMusclesWeight = findViewById(R.id.currentMusclesWeight);
        TextView currentFatPercents = findViewById(R.id.currentFatPercents);
        TextView currentHeight = findViewById(R.id.currentHeight);

        currentWeight.setText(userWeight.getParameterValue() + " кг");
        currentBMI.setText(userWeight.getParameterValue() + " eд");
        currentMusclesWeight.setText(userMusclesWeight.getParameterValue() + " кг");
        currentFatPercents.setText(userFatPercents.getParameterValue() + " %");
        currentHeight.setText(userHeight.getParameterValue() + " м");

    }


}

