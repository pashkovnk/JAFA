package com.example.jafa.models.bodyParameters;

import java.io.Serializable;

public class UserHeight implements Serializable {
    private double heightValue;

    public UserHeight() {
        this.setParameterValue(formatting(0));
    }

    public double getParameterValue() {
        return this.heightValue;
    }

    public void setParameterValue(double value) {
        this.heightValue = value;
    }

    public double formattingFromView(String fromView){
        return Double.parseDouble(fromView.replaceAll("[^\\d.]", ""));
    }
    public double formatting(double value) {
        return Math.abs(Math.ceil(value * 10) / 10);
    }
}
