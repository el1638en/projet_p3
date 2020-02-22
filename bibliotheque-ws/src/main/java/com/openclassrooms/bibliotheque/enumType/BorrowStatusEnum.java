package com.openclassrooms.bibliotheque.enumType;

public enum BorrowStatusEnum {

    ENCOURS("En Cours"),
    PROLONGE("Prolongé"),
    RENDU("Rendu");

    private String status;

    BorrowStatusEnum(String status) {
        this.status = status;
    }

    public String value() {
        return status;
    }
}