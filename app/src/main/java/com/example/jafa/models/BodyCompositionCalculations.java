package com.example.jafa.models;

import java.io.Serializable;

import com.example.jafa.classes.bodyParameters.UserFatPercents;
import com.example.jafa.classes.bodyParameters.UserHeight;
import com.example.jafa.classes.bodyParameters.UserMusclesWeight;
import com.example.jafa.classes.bodyParameters.UserWeight;
/// НУЖЕН ЛИ ЭТОТ КЛАСС?
public class BodyCompositionCalculations implements Serializable {

    private UserWeight userWeight;
    private UserHeight userHeight;

    private UserMusclesWeight userMusclesWeight;

    private UserFatPercents userFatPercents;

    // bodyMassIndex единственное поле без собственного класса,
    // т.к не подразумевается внесение этого параметра пользователем - его можно только вычислить
    private double bodyMassIndex;


    public BodyCompositionCalculations() {
        this.bodyMassIndex = 0.0;
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
        double bodyMassIndex = userWeight.getParameterValue() / Math.pow(userHeight.getParameterValue(), 2);
        setBodyMassIndex(formatting(bodyMassIndex));
    }
}
