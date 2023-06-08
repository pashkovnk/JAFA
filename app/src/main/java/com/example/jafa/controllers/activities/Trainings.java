package com.example.jafa.controllers.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jafa.R;

import java.io.Serializable;

/** Класс экрана "Тренировки" **/
public class Trainings extends AppCompatActivity implements Serializable {

    /** Метод создания **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainings);
    }
}