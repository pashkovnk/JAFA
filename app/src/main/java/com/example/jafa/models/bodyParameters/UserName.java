package com.example.jafa.models.bodyParameters;

import java.io.Serializable;
import java.util.ArrayList;

public class UserName implements Serializable {
    private String userName;

    public UserName() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
