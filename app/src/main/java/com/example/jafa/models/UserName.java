package com.example.jafa.models;

import java.io.Serializable;

/** Класс имени пользователя **/
public class UserName implements Serializable {

    /** Поле имени **/
    private String userName;

    /** Конструктор - получение имени пользователя**/
    public UserName() {
        userName = this.getUserName();
    }

    /** Метод получения имени пользователя**/
    public String getUserName() {
        return userName;
    }

    /** Метод установки имени пользователя **/
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
