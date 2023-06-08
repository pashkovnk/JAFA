package com.example.jafa.models;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.io.Serializable;

/**
 *  Класс подсчета шагов
 * @author Пашков Никита
 * @version 1.0
 */
public class StepCounter implements SensorEventListener, Serializable {

    /** Поле **/
    private SensorManager sensorManager;
    /** Поле **/
    private Sensor stepSensor;
    /** Поле количество шагов**/
    private int stepCount = 0;

    /**
     * Конструктор - создание нового объекта
     * @param context
     */
    public StepCounter(Context context) {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    }

    /**
     * Функция регистрации слушателя событий датчика шагов
     */
    public void register() {
        sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    /**
     * Функция отмены регистрации слушателя событий датчика шагов
     */
    public void unregister() {
        sensorManager.unregisterListener(this);
    }

    /**
     * Функция обработки событий датчика шагов
     * @param event the {@link android.hardware.SensorEvent SensorEvent}.
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            stepCount = (int) event.values[0];
        }
    }

    /**
     *Неиспользумая функция
     * @param sensor
     * @param accuracy The new accuracy of this sensor, one of
     *         {@code SensorManager.SENSOR_STATUS_*}
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // не используется
    }

    /**
     * Функция получения количества шагов
     * @return
     */
    public int getStepCount() {
        return stepCount;
    }
}