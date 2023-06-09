package com.example.jafa.models.bodyParameters;

import java.io.Serializable;

public class UserWeight implements Serializable {
    private double weightValue;

    public UserWeight() {
        this.setParameterValue(formatting(0));
    }

    public double getParameterValue() {
        return this.weightValue;
    }

    public void setParameterValue(double value) {
        this.weightValue = value;
    }

    public double formattingFromView(String fromView){
       return Double.parseDouble(fromView.replaceAll("[^\\d.]", ""));
    }
    public double formatting(double value) {
        return Math.abs(Math.ceil(value * 10) / 10);
    }
}
