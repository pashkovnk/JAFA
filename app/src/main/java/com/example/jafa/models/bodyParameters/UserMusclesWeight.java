package com.example.jafa.models.bodyParameters;

import java.io.Serializable;
import java.util.ArrayList;

public class UserMusclesWeight extends BodyParameterParentClass implements Serializable {
    public UserMusclesWeight() {
        super();
    }

    @Override
    public double getParameterValue() {
        return super.getParameterValue();
    }

    @Override
    public void setParameterValue(double parameterValue) {
        super.setParameterValue(parameterValue);
    }

    @Override
    public double formatting(double value) {
        return super.formatting(value);
    }

    @Override
    public ArrayList<Double> getParameterValuesHistory() {
        return super.getParameterValuesHistory();
    }

    @Override
    public double checkProgress() {
        return super.checkProgress();
    }
}
