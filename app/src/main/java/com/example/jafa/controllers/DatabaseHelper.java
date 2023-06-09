package com.example.jafa.controllers;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс, отвечающий за работу с базой данных
 */
public class DatabaseHelper extends SQLiteOpenHelper implements Serializable {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userData";
    private static final String TABLE_NAME = "data";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_HEIGHT = "height";
    private static final String COLUMN_MUSCLES_WEIGHT = "muscle_mass";
    private static final String COLUMN_FAT_PERCENTAGE = "fat_percents";
    private static final String COLUMN_BMI = "bmi";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableCreationRequest = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WEIGHT + " REAL, " +
                COLUMN_HEIGHT + " REAL, " +
                COLUMN_MUSCLES_WEIGHT + " REAL, " +
                COLUMN_FAT_PERCENTAGE + " REAL, " +
                COLUMN_BMI + " REAL)";
        db.execSQL(tableCreationRequest);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @SuppressLint("Range")
    public List<String> getAllDataList() {
        List<String> dataList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                String dataString = "";
                dataString += cursor.getInt(cursor.getColumnIndex(COLUMN_ID)) + ", ";
                dataString += cursor.getFloat(cursor.getColumnIndex(COLUMN_WEIGHT)) + ", ";
                dataString += cursor.getFloat(cursor.getColumnIndex(COLUMN_HEIGHT)) + ", ";
                dataString += cursor.getFloat(cursor.getColumnIndex(COLUMN_MUSCLES_WEIGHT)) + ", ";
                dataString += cursor.getFloat(cursor.getColumnIndex(COLUMN_FAT_PERCENTAGE)) + ", ";
                dataString += cursor.getFloat(cursor.getColumnIndex(COLUMN_BMI));
                dataList.add(dataString);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return dataList;
    }

    @SuppressLint("Range")
    public List<String> getLastDataList() {
        List<String> dataList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY " + COLUMN_ID + " DESC LIMIT 1", null);
        if (cursor.moveToFirst()) {
            String dataString = "";
            dataString += cursor.getInt(cursor.getColumnIndex(COLUMN_ID)) + ", ";
            dataString += cursor.getFloat(cursor.getColumnIndex(COLUMN_WEIGHT)) + ", ";
            dataString += cursor.getFloat(cursor.getColumnIndex(COLUMN_HEIGHT)) + ", ";
            dataString += cursor.getFloat(cursor.getColumnIndex(COLUMN_MUSCLES_WEIGHT)) + ", ";
            dataString += cursor.getFloat(cursor.getColumnIndex(COLUMN_FAT_PERCENTAGE)) + ", ";
            dataString += cursor.getFloat(cursor.getColumnIndex(COLUMN_BMI));
            dataList.add(dataString);
        }
        cursor.close();
        db.close();
        return dataList;
    }

    public void addData(double weight, double height, double muscleMass, double fatPercents, double bmi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_WEIGHT, weight);
        values.put(COLUMN_HEIGHT, height);
        values.put(COLUMN_MUSCLES_WEIGHT, muscleMass);
        values.put(COLUMN_FAT_PERCENTAGE, fatPercents);
        values.put(COLUMN_BMI, bmi);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}