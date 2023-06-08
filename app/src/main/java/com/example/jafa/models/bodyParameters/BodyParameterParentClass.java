package com.example.jafa.models.bodyParameters;

import java.io.Serializable;
import java.util.ArrayList;

public class BodyParameterParentClass implements Serializable {

    private ArrayList<Double> parameterValuesHistory = new ArrayList<>();

    public BodyParameterParentClass() {
        this.parameterValuesHistory.add(formatting(0));
    }

    public double getParameterValue() {
        return parameterValuesHistory.get(parameterValuesHistory.size() - 1);
    }

    public void setParameterValue(double parameterValue) {
        this.parameterValuesHistory.add(formatting(parameterValue));
    }

    public double formatting(double value) {
        return Math.abs(Math.ceil(value * 10) / 10);
    }

    public ArrayList<Double> getParameterValuesHistory() {
        return this.parameterValuesHistory;
    }

    public double checkProgress() {
        try {
            return parameterValuesHistory.get(parameterValuesHistory.size() - 1) - parameterValuesHistory.get(parameterValuesHistory.size() - 2);
        } catch (ArrayIndexOutOfBoundsException exception) {
            return formatting(0);
        }
    }
}
