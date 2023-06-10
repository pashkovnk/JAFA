package com.example.jafa.models.bodyParameters;

import java.io.Serializable;

public class UserBMI implements Serializable {
    private static double bmiValue = 0.0;

    public UserBMI() {
        this.setBaseParameterValue();
    }

    public double getParameterValue(double weight, double height) {
        return bmiValue = bmiCalc(weight, height);
    }

    public double getValue(){
        return bmiValue;
    }

    public void setParameterValue(double weight, double height) {
        this.bmiValue = formatting(weight / Math.pow(height, 2));
    }

    private void setBaseParameterValue() {
        bmiValue = 0.0;
    }

    public double bmiCalc(double weight, double height) {
        return formatting(weight / Math.pow(height, 2));
    }

    public double formattingFromView(String fromView) {
        return Double.parseDouble(fromView.replaceAll("[^\\d.]", ""));
    }

    public double formatting(double value) {
        return Math.ceil(value * 10) / 10;
    }
}

