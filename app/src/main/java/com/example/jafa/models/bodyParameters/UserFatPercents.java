package com.example.jafa.models.bodyParameters;

import java.io.Serializable;

public class UserFatPercents implements Serializable {
    private double fatPercentsValue;

    public UserFatPercents() {
        this.setParameterValue(formatting(0));
    }

    public double getParameterValue() {
        return this.fatPercentsValue;
    }

    public void setParameterValue(double value) {
        this.fatPercentsValue = value;
    }

    public double formattingFromView(String fromView){
        return Double.parseDouble(fromView.replaceAll("[^\\d.]", ""));
    }
    public double formatting(double value) {
        return Math.abs(Math.ceil(value * 10) / 10);
    }
}
