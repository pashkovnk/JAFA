package com.example.jafa.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;


public class DatabaseHelper extends SQLiteOpenHelper implements Serializable {


    // Статические переменные для более удобной работы с БД
    private static final String DATABASE_NAME = "userData.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "mytable";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_HEIGHT = "height";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_MUSCLES_WEIGHT = "muscle_mass";
    private static final String COLUMN_FAT_PERCENTAGE = "fat_percentage";
    private static final String COLUMN_BMI = "bmi";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WEIGHT + " REAL, " +
                COLUMN_HEIGHT + " REAL, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_MUSCLES_WEIGHT + " REAL, " +
                COLUMN_FAT_PERCENTAGE + " REAL, " +
                COLUMN_BMI + " REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public boolean insertData(double weight, double height, String name, double muscleMass, double fatPercentage, double bmi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_WEIGHT, weight);
        contentValues.put(COLUMN_HEIGHT, height);
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_MUSCLES_WEIGHT, muscleMass);
        contentValues.put(COLUMN_FAT_PERCENTAGE, fatPercentage);
        contentValues.put(COLUMN_BMI, bmi);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public boolean updateData(int id, double weight, double height, String name, double muscleMass, double fatPercentage, double bmi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_WEIGHT, weight);
        contentValues.put(COLUMN_HEIGHT, height);
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_MUSCLES_WEIGHT, muscleMass);
        contentValues.put(COLUMN_FAT_PERCENTAGE, fatPercentage);
        contentValues.put(COLUMN_BMI, bmi);
        int result = db.update(TABLE_NAME, contentValues, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        return result > 0;
    }

    public Integer deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }
}