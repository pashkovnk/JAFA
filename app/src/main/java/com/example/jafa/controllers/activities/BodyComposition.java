package com.example.jafa.controllers.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jafa.R;
import com.example.jafa.models.*;

import java.io.Serializable;

/**
 * Класс экрана "Состав тела"
 *
 * @author Пашков Никита
 * @version 1.0
 */
public class BodyComposition extends AppCompatActivity implements Serializable {

    /**
     * Поле класса с вычислениями
     **/
    private BodyCompositionCalculations bodyCompositionCalculations;

    /**
     * Поля класса текстовых полей
     **/
    private TextView currentWeightView;
    private TextView currentBMIView;
    private TextView currentMusclesWeightView;
    private TextView currentFatPercentsView;
    private TextView currentHeightView;


    /**
     * Метод создания экрана
     */
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

    }

    /**
     * Метод обработки нажатия кнопки "Внести изменения"
     *
     * @param view
     */
    public void editParametersButton(View view) {
        currentWeightView.setText(3.0 + " кг");
        currentMusclesWeightView.setText(3.0 + " кг");
        currentFatPercentsView.setText(3.0 + " %");
        currentHeightView.setText(3.0 + "м");
        currentBMIView.setText(String.valueOf((Math.ceil(3.0 / Math.pow(3.0, 2) * 10) / 10)) + " ед");
    }


}

