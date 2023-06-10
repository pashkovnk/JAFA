package com.example.jafa.controllers.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jafa.R;
import com.example.jafa.controllers.DatabaseHelper;
import com.example.jafa.models.bodyParameters.UserBMI;
import com.example.jafa.models.bodyParameters.UserFatPercents;
import com.example.jafa.models.bodyParameters.UserHeight;
import com.example.jafa.models.bodyParameters.UserMusclesWeight;
import com.example.jafa.models.bodyParameters.UserWeight;

import java.io.Serializable;
import java.util.List;

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

    /**
     * Поля класса текстовых полей
     **/
    private TextView currentWeightView;
    private TextView currentBMIView;
    private TextView currentMusclesWeightView;
    private TextView currentFatPercentsView;
    private TextView currentHeightView;

    private TextView progressWeightView;
    private TextView progressBMIView;
    private TextView progressMusclesWeightView;
    private TextView progressFatPercentsView;
    private TextView progressHeightView;

    private UserWeight userWeight = new UserWeight();
    private UserHeight userHeight = new UserHeight();
    private UserFatPercents userFatPercents = new UserFatPercents();
    private UserMusclesWeight userMusclesWeight = new UserMusclesWeight();
    private UserBMI userBMI = new UserBMI();

    private DatabaseHelper db = new DatabaseHelper(this);

    /**
     * Метод создания экрана  - установка
     */
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_composition);

        List<String> data = db.getLastDataList();

        currentWeightView = findViewById(R.id.currentWeight);
        currentBMIView = findViewById(R.id.currentBMI);
        currentMusclesWeightView = findViewById(R.id.currentMusclesWeight);
        currentFatPercentsView = findViewById(R.id.currentFatPercents);
        currentHeightView = findViewById(R.id.currentHeight);

        progressWeightView = findViewById(R.id.progressWeight);
        progressBMIView = findViewById(R.id.progressBMI);
        progressMusclesWeightView = findViewById(R.id.progressMusclesWeight);
        progressFatPercentsView = findViewById(R.id.progressFatPercents);
        progressHeightView = findViewById(R.id.progressHeight);


        currentWeightView.setText(userWeight.getParameterValue() + " кг");
        currentBMIView.setText(userBMI.getValue() + " ед");
        currentMusclesWeightView.setText(userMusclesWeight.getParameterValue() + " кг");
        currentFatPercentsView.setText(userFatPercents.getParameterValue() + " %");
        currentHeightView.setText(userHeight.getParameterValue() + "м");

    }

    /**
     * Метод обработки нажатия кнопки "Внести изменения"
     *
     * @param view
     */
    public void editParametersButton(View view) {

        if ((String.valueOf(currentWeightView.getText())).replaceAll("[^\\d.]", "") != null) {
            progressWeightView.setText(String.valueOf(userWeight.formattingFromView(String.valueOf(currentWeightView.getText())) - userWeight.getParameterValue()) + " кг");
            userWeight.setParameterValue(userWeight.formattingFromView(String.valueOf(currentWeightView.getText())));
        } else {
            currentWeightView.setText(String.valueOf(userWeight.getParameterValue()));
        }

        if ((String.valueOf(currentMusclesWeightView.getText())).replaceAll("[^\\d.]", "") != null) {
            progressMusclesWeightView.setText(String.valueOf(userMusclesWeight.formattingFromView(String.valueOf(currentMusclesWeightView.getText())) - userMusclesWeight.getParameterValue()) + " кг");
            userMusclesWeight.setParameterValue(userMusclesWeight.formattingFromView(String.valueOf(currentMusclesWeightView.getText())));
        } else {
            currentMusclesWeightView.setText(String.valueOf(userMusclesWeight.getParameterValue()));
        }

        if ((String.valueOf(currentFatPercentsView.getText())).replaceAll("[^\\d.]", "") != null) {
            progressFatPercentsView.setText(String.valueOf(userFatPercents.formattingFromView(String.valueOf(currentFatPercentsView.getText())) - userFatPercents.getParameterValue()) + " %");
            userFatPercents.setParameterValue(userFatPercents.formattingFromView(String.valueOf(currentFatPercentsView.getText())));

        } else {
            currentFatPercentsView.setText(String.valueOf(userFatPercents.getParameterValue()));
        }

        if ((String.valueOf(currentHeightView.getText())).replaceAll("[^\\d.]", "") != null || (Double.parseDouble(String.valueOf(currentHeightView.getText()).replaceAll("[^\\d.]", "")) != 0.0)) {
            progressHeightView.setText(String.valueOf(userHeight.formattingFromView(String.valueOf(currentHeightView.getText())) - userHeight.getParameterValue()) + " м");
            userHeight.setParameterValue(userHeight.formattingFromView(String.valueOf(currentHeightView.getText())));
        } else {
            currentHeightView.setText(String.valueOf(userFatPercents.getParameterValue()));
        }

        if (((String.valueOf(currentHeightView.getText())).replaceAll("[^\\d.]", "") != null) && ((String.valueOf(currentWeightView.getText())).replaceAll("[^\\d.]", "") != null)) {
            progressBMIView.setText(String.valueOf(userBMI.bmiCalc(userWeight.getParameterValue(), userHeight.getParameterValue()) - userBMI.getValue()) + " ед");
            userBMI.setParameterValue(userWeight.getParameterValue(), userHeight.getParameterValue());
            currentBMIView.setText(String.valueOf(userBMI.getParameterValue(userWeight.getParameterValue(), userHeight.getParameterValue())) + " ед");
        } else {
            currentBMIView.setText(String.valueOf(userBMI.getValue()));
        }

        db.addData(userWeight.getParameterValue(), userHeight.getParameterValue(), userMusclesWeight.getParameterValue(), userFatPercents.getParameterValue(), userBMI.getValue());
    }


}

