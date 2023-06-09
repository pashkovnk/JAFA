package com.example.jafa.models;

import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.jafa.controllers.DatabaseHelper;
import com.example.jafa.models.bodyParameters.UserFatPercents;
import com.example.jafa.models.bodyParameters.UserHeight;
import com.example.jafa.models.bodyParameters.UserMusclesWeight;
import com.example.jafa.models.bodyParameters.UserWeight;

/**
 * Класс, вычисляющий ИМТ
 **/
public class BodyCompositionCalculations implements Serializable {

//    /**
//     * Поле веса пользователя
//     **/
//    private UserWeight userWeight;
//    /**
//     * Поле роста пользователя
//     **/
//    private UserHeight userHeight;
//    /**
//     * Поле мышечной массы пользователя
//     **/
//    private UserMusclesWeight userMusclesWeight;
//    /**
//     * Поле процента жира пользователя
//     **/
//    private UserFatPercents userFatPercents;
//    /**
//     * Поле имени пользователя
//     **/
//    private UserName userName;
//    /**
//     * Поле ИМТ пользователя
//     **/
//    private double bodyMassIndex;
//
//    /**
//     * Поле обработчика запросов к БД
//     **/
//    private DatabaseHelper databaseHelper;
//
//    /**
//     * Поле базы данных
//     **/
//    private SQLiteDatabase db;
//
//    /**
//     * Конструктор класса - получение актуальных значений из БД
//     */
//    public BodyCompositionCalculations() {
////        databaseHelper.onCreate(db);
//        ArrayList<String> data = databaseHelper.getAllDataList();
//        userWeight.setParameterValue(Double.parseDouble(data.get(0)));
//        userHeight.setParameterValue(Double.parseDouble(data.get(1)));
//        userName.setUserName((data.get(2)));
//        userMusclesWeight.setParameterValue(Double.parseDouble(data.get(3)));
//        userFatPercents.setParameterValue(Double.parseDouble(data.get(4)));
//        bodyMassIndex = Double.parseDouble(data.get(5));
//
//    }
//
//    /** Метод получения веса пользователя **/
//    public double getUserWeight() {
//        return userWeight.getParameterValue();
//    }
//    /** Метод установки веса пользователя **/
//    public void setUserWeight(double weight) {
//        userWeight.setParameterValue(weight);
//    }
//    /** Метод получения роста пользователя **/
//    public double getUserHeight() {
//        return userHeight.getParameterValue();
//    }
//    /** Метод установки роста пользователя **/
//    public void setUserHeight(double height) {
//        userHeight.setParameterValue(height);
//    }
//    /** Метод получения мышечной массы пользователя **/
//    public double getUserMusclesWeight() {
//        return userMusclesWeight.getParameterValue();
//    }
//    /** Метод установки мышечной массы пользователя **/
//    public void setUserMusclesWeight(double musclesWeight) {
//        userMusclesWeight.setParameterValue(musclesWeight);
//    }
//    /** Метод получения процента жира пользователя **/
//    public double getUserFatPercents() {
//        return userFatPercents.getParameterValue();
//    }
//    /** Метод установки процента жира пользователя **/
//    public void setUserFatPercents(double fatPercents) {
//        userFatPercents.setParameterValue(fatPercents);
//    }
//    /** Метод получения ИМТ пользователя **/
//    public double getBodyMassIndex() {
//        return bodyMassIndex;
//    }
//    /** Метод установки ИМТ пользователя **/
//    private void setBodyMassIndex(double bmi) {
//        this.bodyMassIndex = bmi;
//    }
//
//    /** Метод приведения данных к необходимому виду **/
//    public double formatting(double value) {
//        return Math.abs(Math.ceil(value * 10) / 10);
//    }
//
//    /** Метод приведения данных к необходимому виду **/
//    public double formattingDifference(double value) {
//        return Math.ceil(value * 10) / 10;
//    }
//    /** Метод вычисления и занесения в поле ИМТ пользователя **/
//    public void bodyMassIndexCalculation() {
//        bodyMassIndex = userWeight.getParameterValue() / Math.pow(userHeight.getParameterValue(), 2);
//        setBodyMassIndex(formatting(bodyMassIndex));
//    }
//
//    public String getDifference(String previous, String current){
//        double previousValue = Double.parseDouble(previous);
//        double currentValue = Double.parseDouble(current.replaceAll("[^\\d.]", ""));
//        String differenceString = String.valueOf(formattingDifference(currentValue - previousValue));
//        return differenceString;
//    }
//
//    /** Метод вычисления ИМТ пользователя и вывод в строковом формате */
//    public double bmiCalc(double weight, double height) {
//        return (weight / Math.pow(height, 2));
//    }

    private double bmi;
    private double weight;
    private double height;

    public BodyCompositionCalculations(double userWeight, double userHeight) {
        setWeight(userWeight);
        setHeight(userHeight);
        setBmi(formatting(weight / Math.pow(height, 2)));
    }

    public BodyCompositionCalculations(){
        setBmi(0.00);
    }

    private double formatting(double value){
        return Math.ceil(value * 10) / 10;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
