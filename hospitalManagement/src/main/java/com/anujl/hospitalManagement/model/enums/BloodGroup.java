package com.anujl.hospitalManagement.model.enums;


public enum BloodGroup {
    A_POSITIVE("A+"),
    A_NEGATIVE("A−"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B−"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB−"),
    O_POSITIVE("O+"),
    O_NEGATIVE("O−");

    private final String label;

    BloodGroup(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
