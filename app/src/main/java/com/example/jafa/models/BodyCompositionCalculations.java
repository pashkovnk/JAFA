package com.example.jafa.models;

import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.jafa.controllers.DatabaseHelper;
import com.example.jafa.models.bodyParameters.UserFatPercents;
import com.example.jafa.models.bodyParameters.UserHeight;
import com.example.jafa.models.bodyParameters.UserMusclesWeight;
import com.example.jafa.models.bodyParameters.UserName;
import com.example.jafa.models.bodyParameters.UserWeight;
public class BodyCompositionCalculations implements Serializable {

    private UserWeight userWeight;
    private UserHeight userHeight;

    private UserMusclesWeight userMusclesWeight;

    private UserFatPercents userFatPercents;

    private UserName userName;
    // bodyMassIndex единственное поле без собственного класса,
    // т.к не подразумевается внесение этого параметра пользователем - его можно только вычислить
    private double bodyMassIndex;

    private DatabaseHelper databaseHelper;

    private SQLiteDatabase db;

//    private ArrayList<Object> parameters = new ArrayList(Arrays.asList(userWeight, userHeight, userName, userMusclesWeight, userFatPercents, bodyMassIndex));


//    private void setAllParameters(UserWeight weight, UserHeight height, UserName name, UserMusclesWeight musclesWeight,
//                             UserFatPercents userFatPercentage, double bodyMassIndex){
//        for (Object parameter: parameters){
//        }
//
//    }
    public BodyCompositionCalculations() {
        databaseHelper.onCreate(db);
        ArrayList<String> data = databaseHelper.getAllDataList();
        userWeight.setParameterValue(Double.parseDouble(data.get(0)));
        userHeight.setParameterValue(Double.parseDouble(data.get(1)));
        userName.setUserName((data.get(2)));
        userMusclesWeight.setParameterValue(Double.parseDouble(data.get(3)));
        userFatPercents.setParameterValue(Double.parseDouble(data.get(4)));
        bodyMassIndex = Double.parseDouble(data.get(5));

    }

    public double getUserWeight() {
        return userWeight.getParameterValue();
    }

    public void setUserWeight(double weight) {
        userWeight.setParameterValue(weight);
    }

    public double getUserHeight() {
        return userHeight.getParameterValue();
    }

    public void setUserHeight(double height) {
        userHeight.setParameterValue(height);
    }

    public double getUserMusclesWeight() {
        return userMusclesWeight.getParameterValue();
    }

    public void setUserMusclesWeight(double musclesWeight) {
        userMusclesWeight.setParameterValue(musclesWeight);
    }

    public double getUserFatPercents() {
        return userFatPercents.getParameterValue();
    }

    public void setUserFatPercents(double fatPercents) {
        userFatPercents.setParameterValue(fatPercents);
    }

    public double getBodyMassIndex() {
        return bodyMassIndex;
    }

    private void setBodyMassIndex(double bmi) {
        this.bodyMassIndex = bmi;
    }

    // Приведение данных в необходимый формат (никаких отрицательных чисел, 1 цифра после запятой)
    public double formatting(double value) {
        return Math.abs(Math.ceil(value * 10) / 10);
    }

    // Получение ИМТ на основе роста и веса пользователя
    public void bodyMassIndexCalculation() {
        bodyMassIndex = userWeight.getParameterValue() / Math.pow(userHeight.getParameterValue(), 2);
        setBodyMassIndex(formatting(bodyMassIndex));
    }

    public String bmiCalc(String weight, String height){
        return String.valueOf((Double.parseDouble(weight) /  Math.pow(Double.parseDouble(height), 2)));
    }
}
