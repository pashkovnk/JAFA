package com.example.jafa.controllers.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jafa.R;
import com.example.jafa.models.*;

public class BodyComposition extends AppCompatActivity {


    private BodyCompositionCalculations bodyCompositionCalculations;

    TextView currentWeightView;
    TextView currentBMIView;
    TextView currentMusclesWeightView;
    TextView currentFatPercentsView;
    TextView currentHeightView;

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

        currentWeightView = findViewById(R.id.currentWeight);
        currentBMIView = findViewById(R.id.currentBMI);
        currentMusclesWeightView = findViewById(R.id.currentMusclesWeight);
        currentFatPercentsView = findViewById(R.id.currentFatPercents);
        currentHeightView = findViewById(R.id.currentHeight);

        currentWeightView.setText(0.0 + " кг");
        currentBMIView.setText(0.0 + " eд");
        currentMusclesWeightView.setText(0.0 + " кг");
        currentFatPercentsView.setText(0.0 + " %");
        currentHeightView.setText(0.0 + "м");



//        currentWeight.setText(bodyCompositionCalculations.getUserWeight() + " кг");
//        currentBMI.setText(bodyCompositionCalculations.getBodyMassIndex() + " eд");
//        currentMusclesWeight.setText(bodyCompositionCalculations.getUserWeight() + " кг");
//        currentFatPercents.setText(bodyCompositionCalculations.getUserFatPercents() + " %");
//        currentHeight.setText(bodyCompositionCalculations.getUserHeight() + "м");

    }

    public void editParametersButton(View view){
        currentWeightView.setText(3.0 + " кг");
        currentBMIView.setText(3.0 + " eд");
        currentMusclesWeightView.setText(3.0 + " кг");
        currentFatPercentsView.setText(3.0 + " %");
        currentHeightView.setText(3.0 + "м");
    }


}

