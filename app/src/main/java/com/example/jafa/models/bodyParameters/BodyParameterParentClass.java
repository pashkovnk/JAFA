package com.example.jafa.models.bodyParameters;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Класс-родитель для параметров пользователя
 **/
public class BodyParameterParentClass implements Serializable {
    private Double parameterValue;

    /**
     * Конструктор класса, в котором задается базовое значение параметра
     * в поле истории значений
     **/
    public BodyParameterParentClass() {
        setParameterValue(formatting(0));
    }

    /**
     * Метод получения истории значений параметра
     **/
    public double getParameterValue() {
        return parameterValue;
    }

    /**
     * Метод установки текущего значения параметра
     **/
    public void setParameterValue(double value) {
        parameterValue = value;
    }

    /**
     * Метод приведения данных к необходимому виду
     **/
    public double formatting(double value) {
        return Math.abs(Math.ceil(value * 10) / 10);
    }
}
