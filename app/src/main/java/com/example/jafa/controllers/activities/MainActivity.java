package com.example.jafa.controllers.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.jafa.R;
import com.example.jafa.controllers.DatabaseHelper;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
    }

    public void bodyComposition(View view) {

//        SQLiteDatabase database = databaseHelper.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();

        Intent toBodyCompositionScreen = new Intent(MainActivity.this, BodyComposition.class);
        startActivity(toBodyCompositionScreen);
    }

    public void trainings(View view) {
        Intent toTrainings = new Intent(MainActivity.this, Trainings.class);
        startActivity(toTrainings);
    }
}