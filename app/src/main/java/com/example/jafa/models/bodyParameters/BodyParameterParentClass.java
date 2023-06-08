package com.example.jafa.models.bodyParameters;

import java.io.Serializable;
import java.util.ArrayList;

/** Класс-родитель для параметров пользователя **/
public class BodyParameterParentClass implements Serializable {

    /** Метод установки истории значений параметра
     *  для списка с историей значений параметра**/
    public void setParameterValuesHistory(ArrayList<Double> parameterValuesHistory) {
        this.parameterValuesHistory = parameterValuesHistory;
    }

    /** Поле истории значений параметра **/
    private ArrayList<Double> parameterValuesHistory = new ArrayList<>();

    /** Конструктор класса, в котором задается базовое значение параметра
     * в поле истории значений **/
    public BodyParameterParentClass() {
        this.parameterValuesHistory.add(formatting(0));
    }

    /** Метод получения истории значений параметра **/
    public double getParameterValue() {
        return parameterValuesHistory.get(parameterValuesHistory.size() - 1);
    }

    /** Метод установки текущего значения параметра **/
    public void setParameterValue(double parameterValue) {
        this.parameterValuesHistory.add(formatting(parameterValue));
    }

    /** Метод приведения данных к необходимому виду **/
    public double formatting(double value) {
        return Math.abs(Math.ceil(value * 10) / 10);
    }

    /** Метод получения истории значений параметра **/
    public ArrayList<Double> getParameterValuesHistory() {
        return this.parameterValuesHistory;
    }

    /** Метод получения разницы между актуальным значением параметра
     * и предыдущим **/
    public double checkProgress() {
        try {
            return parameterValuesHistory.get(parameterValuesHistory.size() - 1) - parameterValuesHistory.get(parameterValuesHistory.size() - 2);
        } catch (ArrayIndexOutOfBoundsException exception) {
            return formatting(0);
        }
    }
}
