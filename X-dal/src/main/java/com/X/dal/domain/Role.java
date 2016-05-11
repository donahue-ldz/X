package com.X.dal.domain;

/**
 * Created by donahue on 5/10/16.
 */
public enum Role {
    ADMIN("1"), STUDENT("2"), TEACHER("3");
    private String SQLValue;

    Role(String SQLValue) {
        this.SQLValue = SQLValue;
    }

    public String value() {
        return this.SQLValue;
    }
}
