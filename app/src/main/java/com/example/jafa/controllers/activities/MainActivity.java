package com.example.jafa.controllers.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jafa.R;
import com.example.jafa.controllers.DatabaseHelper;
import com.example.jafa.models.StepCounter;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    private StepCounter stepCounter;
    private TextView stepCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);

        stepCounter = new StepCounter(this);
        stepCounter.register();
        stepCountTextView = findViewById(R.id.step_counter_value);
        updateStepCount();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        stepCounter.unregister();
    }

    private void updateStepCount() {
        int stepCount = stepCounter.getStepCount();
        stepCountTextView.setText(String.valueOf(stepCount));
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