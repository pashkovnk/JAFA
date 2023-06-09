package com.example.jafa.models.bodyParameters;

import java.io.Serializable;

public class UserMusclesWeight implements Serializable {
    private double musclesWeightValue;

    public UserMusclesWeight() {
        this.setParameterValue(formatting(0));
    }

    public double getParameterValue() {
        return this.musclesWeightValue;
    }

    public void setParameterValue(double value) {
        this.musclesWeightValue = value;
    }

    public double formattingFromView(String fromView){
        return Double.parseDouble(fromView.replaceAll("[^\\d.]", ""));
    }
    public double formatting(double value) {
        return Math.abs(Math.ceil(value * 10) / 10);
    }
}
