package com.anujl.blacknwhite.util.constants;

public enum Privilages {
    RESET_ANY_USER_PASSWORD(1,"RESET_ANY_USER_PASSWORD"),
    ACCESS_ADMIN_DASHBOARD(2,"ACCESS_ADMIN_DASHBOARD");
    private final long id;
    private final String privilage;
    Privilages(int id, String privilage) {
        this.id = id;
        this.privilage = privilage;
    }
    public long getId() {
        return id;
    }
    public String getPrivilage() {
        return privilage;
    }
}
