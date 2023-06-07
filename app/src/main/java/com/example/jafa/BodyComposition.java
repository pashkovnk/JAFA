package com.example.jafa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.jafa.classes.bodyParameters.*;
import com.example.jafa.models.*;

public class BodyComposition extends AppCompatActivity {

    private UserWeight userWeight;
    private UserHeight userHeight;
    private UserMusclesWeight userMusclesWeight;
    private UserFatPercents userFatPercents;
    private BodyCompositionCalculations bodyCompositionCalculations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_composition);

        TextView currentWeight = findViewById(R.id.currentWeight);
        currentWeight.setText(userWeight.getParameterValue() + " кг");
    }


}

